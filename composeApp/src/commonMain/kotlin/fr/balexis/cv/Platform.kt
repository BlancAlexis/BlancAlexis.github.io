package fr.balexis.cv

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform