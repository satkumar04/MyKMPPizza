package com.example.mypizzakmp.android

import android.app.Application
import com.example.mypizzakmp.di.initKoin

@Suppress("unused")
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
        }
    }
}