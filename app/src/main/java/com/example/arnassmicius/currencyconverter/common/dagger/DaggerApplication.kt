package com.example.arnassmicius.currencyconverter.common.dagger

import android.app.Application

/**
 * Created by arnas on 18.2.22.
 */
class DaggerApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        appComponent.inject(this)
    }
}