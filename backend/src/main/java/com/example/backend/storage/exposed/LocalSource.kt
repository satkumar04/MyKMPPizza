package com.example.backend.storage.exposed

internal interface LocalSource {
    suspend fun getPizza(): String
}