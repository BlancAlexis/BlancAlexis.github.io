package fr.balexis.cv


class WasmPlatform : DevicePlatform {
    override val name: String = "JS"
}

actual fun getPlatform(): DevicePlatform = WasmPlatform()