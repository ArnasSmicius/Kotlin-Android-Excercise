package com.example.arnassmicius.currencyconverter.currencyconversion.api

import bolts.Task
import bolts.TaskCompletionSource
import org.joda.money.Money
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by arnas on 18.2.21.
 */
class CurrencyConversionApiClient @Inject constructor(private var client: CurrencyConversionRetrofitClient) {

    fun calculate(fromAmount: Money, toCurrency: String): Task<CurrencyConversionResult> {
        val call = client.getConversionResult(fromAmount.amount.toString(),
                                              fromAmount.currencyUnit.toString(),
                                              toCurrency)

        val result:TaskCompletionSource<CurrencyConversionResult> = TaskCompletionSource()

        call.enqueue(object : Callback<CurrencyConversionResult> {
            override fun onResponse(call: Call<CurrencyConversionResult>?, response: Response<CurrencyConversionResult>?) {
                println(call!!.request().url().toString())
                result.setResult(response!!.body())
            }

            override fun onFailure(call: Call<CurrencyConversionResult>?, t: Throwable?) {
                result.setError(RuntimeException("Error occurred when downloading data"))
            }
        })

        return result.task
    }
}