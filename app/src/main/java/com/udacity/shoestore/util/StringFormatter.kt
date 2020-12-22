package com.udacity.shoestore.util

import java.math.BigDecimal

class StringFormatter {

    companion object {

        @JvmStatic
        fun formatStringSize(number: Double): String {
            return String.format("Shoe size: ${BigDecimal(number).toPlainString()}")
        }

        @JvmStatic
        fun formatString(number: Double): String {
            return BigDecimal(number).toPlainString()
        }
    }
}