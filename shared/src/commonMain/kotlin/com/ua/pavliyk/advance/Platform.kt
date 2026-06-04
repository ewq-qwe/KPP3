package com.ua.pavliyk.advance

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform