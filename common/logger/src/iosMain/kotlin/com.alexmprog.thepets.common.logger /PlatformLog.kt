package com.alexmprog.thepets.common.logger

actual fun platformLog(tag: String, message: String) {
    println("$tag $message")
}
