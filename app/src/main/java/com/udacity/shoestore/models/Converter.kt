package com.udacity.shoestore.models

import androidx.databinding.InverseMethod

object Converter {
    @InverseMethod("stringToDouble")
    @JvmStatic fun doubleToString(
        value: Double
    ): String {
        return value.toString()
    }
    @JvmStatic fun stringToDouble(
        value: String
    ): Double {
        return if(value.isNotEmpty()) {
            value.toDouble()
        } else {
            "0".toDouble()
        }
    }
}