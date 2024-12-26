package fr.balexis.cv

import android.os.Build


class AndroidPlatform : DevicePlatform {
    override val name: String = "Android"
}

actual fun getPlatform(): DevicePlatform = AndroidPlatform()