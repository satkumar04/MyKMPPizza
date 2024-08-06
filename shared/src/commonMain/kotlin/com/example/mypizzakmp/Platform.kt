package com.example.mypizzakmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform