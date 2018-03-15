package com.example.arnassmicius.currencyconverter.currencyconversion.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import com.example.arnassmicius.currencyconverter.CurrencyConversionView
import com.example.arnassmicius.currencyconverter.common.dagger.DaggerApplication
import com.example.arnassmicius.currencyconverter.currencyconversion.api.CurrencyConversionApiClient
import org.joda.money.Money
import javax.inject.Inject

/**
 * Created by arnas on 18.2.24.
 */
class CurrencyConversionController : Controller(), CurrencyConversionView.CurrencyConversionViewDelegate {

    @Inject
    lateinit var client: CurrencyConversionApiClient

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return CurrencyConversionView(applicationContext, this)
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        (applicationContext as DaggerApplication).appComponent.inject(this)
    }

    override fun onSubmitTapped(amount: String) {
        val task = client.calculate(Money.parse("USD $amount"), "EUR")

        task.continueWith({ a -> when(a.isFaulted) {
            true -> println("Error occurred when downloading data")
            false -> println("amount = " + task.result.getAmountMoney())
        }})
    }
}