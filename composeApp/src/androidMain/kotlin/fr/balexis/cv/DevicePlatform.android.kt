package fr.balexis.cv


class AndroidPlatform : DevicePlatform {
    override val name: String = "Android"
}

actual fun getPlatform(): DevicePlatform = AndroidPlatform()