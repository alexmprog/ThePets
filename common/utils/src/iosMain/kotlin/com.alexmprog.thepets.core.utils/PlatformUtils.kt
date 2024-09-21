package com.alexmprog.thepets.core.utils

import platform.UIKit.UIDevice

actual val platform: Platform = Platform(
    type = PlatformType.Ios,
    name = UIDevice.currentDevice.systemName(),
    version = UIDevice.currentDevice.systemVersion
)
