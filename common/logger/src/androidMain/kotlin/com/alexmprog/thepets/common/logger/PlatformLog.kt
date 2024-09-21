package com.alexmprog.thepets.common.logger

import android.util.Log

actual fun platformLog(tag: String, message: String) {
    Log.d(tag, message)
}
