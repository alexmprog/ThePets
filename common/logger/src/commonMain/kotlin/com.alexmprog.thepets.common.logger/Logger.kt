package com.alexmprog.thepets.common.logger

object Logger {

    private var isEnabled: Boolean = true

    fun init(isEnabled: Boolean = true) {
        this.isEnabled = isEnabled
    }

    fun log(tag: String, message: String) {
        if (!isEnabled) return
        platformLog(tag = tag, message = message)
    }
}
