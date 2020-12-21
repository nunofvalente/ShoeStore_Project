package com.udacity.shoestore.util

import java.math.BigDecimal

class StringFormatter {

    companion object {
        fun formatStringSize(number: Double): String {
            return String.format("Shoe size: ${BigDecimal(number).toPlainString()}")
        }
    }
}