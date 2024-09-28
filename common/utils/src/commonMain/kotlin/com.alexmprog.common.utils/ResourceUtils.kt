package com.alexmprog.common.utils

interface Error

enum class GenericError : Error {
    NO_INTERNET,
    DATABASE_ERROR,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN;
}

// add Loading state if needed
sealed interface Resource<out D, out E : Error> {
    data class Success<out D>(val data: D) : Resource<D, Nothing>
    data class Error<out E : com.alexmprog.common.utils.Error>(val error: E) : Resource<Nothing, E>
}

inline fun <T, E : Error, R> Resource<T, E>.map(map: (T) -> R): Resource<R, E> {
    return when (this) {
        is Resource.Error -> Resource.Error(error)
        is Resource.Success -> Resource.Success(map(data))
    }
}

inline fun <T, E : Error> Resource<T, E>.onSuccess(action: (T) -> Unit): Resource<T, E> {
    return when (this) {
        is Resource.Error -> this
        is Resource.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : Error> Resource<T, E>.onError(action: (E) -> Unit): Resource<T, E> {
    return when (this) {
        is Resource.Error -> {
            action(error)
            this
        }

        is Resource.Success -> this
    }
}