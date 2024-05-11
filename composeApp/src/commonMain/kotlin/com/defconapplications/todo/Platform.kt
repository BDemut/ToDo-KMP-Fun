package com.defconapplications.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform