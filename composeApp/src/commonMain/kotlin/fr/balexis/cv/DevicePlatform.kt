package fr.balexis.cv

interface DevicePlatform {
    val name: String
}

expect fun getPlatform(): DevicePlatform