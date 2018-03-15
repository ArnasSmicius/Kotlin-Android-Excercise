package com.example.arnassmicius.currencyconverter.common.dagger

import android.app.Application
import com.example.arnassmicius.currencyconverter.MainActivity
import com.example.arnassmicius.currencyconverter.currencyconversion.controllers.CurrencyConversionController
import dagger.Component
import javax.inject.Singleton

/**
 * Created by arnas on 18.2.22.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(application: DaggerApplication)

    fun inject(mainActivity: MainActivity)

    fun inject(test: Application)

    fun inject(currencyConversionController: CurrencyConversionController)
}