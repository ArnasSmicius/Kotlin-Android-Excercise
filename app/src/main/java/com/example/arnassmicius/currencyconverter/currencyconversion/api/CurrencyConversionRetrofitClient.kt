package com.example.arnassmicius.currencyconverter.currencyconversion.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by arnas on 18.2.21.
 */
interface CurrencyConversionRetrofitClient {

    @GET("/currency/commercial/exchange/{fromAmount}-{fromCurrency}/{toCurrency}/latest")
    fun getConversionResult(@Path("fromAmount") fromAmount: String,
                            @Path("fromCurrency") fromCurrency: String,
                            @Path("toCurrency") toCurrency: String): Call<CurrencyConversionResult>
}