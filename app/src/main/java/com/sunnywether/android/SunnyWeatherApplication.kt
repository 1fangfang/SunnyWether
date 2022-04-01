package com.sunnywether.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/*
全局获取Context
 */
class SunnyWeatherApplication : Application() {

    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        //彩云天气令牌
        const val TOKEN = "Ua8rxzL86VpnGtSJ"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}