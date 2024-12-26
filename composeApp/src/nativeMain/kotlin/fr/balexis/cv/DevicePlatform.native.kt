package fr.balexis.cv


import platform.UIKit.UIDevice

class IOSPlatform: DevicePlatform {
    override val name: String = "IOS"
}

actual fun getPlatform(): DevicePlatform = IOSPlatform()