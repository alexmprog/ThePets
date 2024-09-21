package com.alexmprog.thepets.core.utils

import android.os.Build

actual val platform: Platform = Platform(
    type = PlatformType.Android,
    name = "${Build.MANUFACTURER} ${Build.MODEL}",
    version = "${Build.VERSION.SDK_INT}"
)
