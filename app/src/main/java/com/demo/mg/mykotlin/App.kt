package com.demo.mg.mykotlin

import android.app.Application
import com.demo.mg.mykotlin.http.ApiClient

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiClient.instance.init() //这里
    }
}