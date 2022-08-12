package com.example.myfirsttest

import android.text.Editable
import java.util.regex.Pattern

class EmailValidatorImplPattern : EmailValidatorPattern() {

    var isValid = false
    var text: String? = null

    override fun isNullText(email: String?): String? {
        return EmailValidatorImplPattern.isNullText(email)
    }

    override fun isValidEmail(email: CharSequence?): Boolean {
        return EmailValidatorImplPattern.isValidEmail(email)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit

    override fun afterTextChanged(s: Editable?) {
        isValid = isValidEmail(s)
        text = isNullText(s.toString())
    }

    companion object {
        private val PATTERN_EMAIL = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
        )

        fun isNullText(email: String?): String? {
            return email
        }

        fun isValidEmail(email: CharSequence?): Boolean {
            return email != null && PATTERN_EMAIL.matcher(email).matches()
        }
    }

}