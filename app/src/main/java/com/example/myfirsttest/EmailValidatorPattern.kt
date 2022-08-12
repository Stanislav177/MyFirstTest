package com.example.myfirsttest

import android.text.TextWatcher

abstract class EmailValidatorPattern : TextWatcher {

    abstract fun isNullText(email: String?): String?

    abstract fun isValidEmail(email: CharSequence?): Boolean
}