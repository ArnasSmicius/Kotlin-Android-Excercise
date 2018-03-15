package com.example.arnassmicius.currencyconverter.currencyconversion.api

import org.joda.money.CurrencyUnit
import org.joda.money.Money
import java.math.BigDecimal

/**
 * Created by arnas on 18.2.21.
 */
data class CurrencyConversionResult(
    private val amount: String,
    private val currency: String) {

    fun getAmountMoney(): Money {
        return Money.of(CurrencyUnit.of(currency), BigDecimal(amount))
    }
}