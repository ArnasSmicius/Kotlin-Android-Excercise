package com.example.arnassmicius.currencyconverter

import android.content.Context
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout

/**
 * Created by arnas on 18.2.24.
 */
class CurrencyConversionView(context: Context?, private val delegate: CurrencyConversionViewDelegate) : LinearLayout(context) {

    private var etAmount: EditText
    private var submitButton: Button

    interface CurrencyConversionViewDelegate {
        fun onSubmitTapped(amount: String)
    }

    init {
        LinearLayout.inflate(context, R.layout.controller_convert, this)
        etAmount = findViewById(R.id.et_from_amount)
        submitButton = findViewById(R.id.bt_convert)
        submitButton.setOnClickListener({ v -> delegate.onSubmitTapped(etAmount.text.toString())})
    }
}