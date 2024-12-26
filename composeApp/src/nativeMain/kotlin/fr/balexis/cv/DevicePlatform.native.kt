package fr.balexis.cv


class IOSPlatform : DevicePlatform {
    override val name: String = "IOS"
}

actual fun getPlatform(): DevicePlatform = IOSPlatform()