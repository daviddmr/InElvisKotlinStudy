package br.com.david.inelviskotlinstudy

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import java.util.*

fun Float.getPriceHumam() = String.format(Locale.GERMAN, "R$ %,.2f", this)

fun String.bold(): SpannableStringBuilder {
    val spannableStringBuilder = SpannableStringBuilder(this)

    spannableStringBuilder.setSpan(StyleSpan(Typeface.BOLD), 0, this.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

    return spannableStringBuilder
}

