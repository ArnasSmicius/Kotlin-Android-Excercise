package com.example.arnassmicius.currencyconverter.common.dagger

import com.example.arnassmicius.currencyconverter.currencyconversion.api.CurrencyConversionRetrofitClient
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by arnas on 18.2.22.
 */
@Module
class AppModule constructor(application: DaggerApplication) {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://api.evp.lt/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesCurrencyConversionRetrofitClient(retrofit: Retrofit): CurrencyConversionRetrofitClient {
        return retrofit.create(CurrencyConversionRetrofitClient::class.java)
    }


}