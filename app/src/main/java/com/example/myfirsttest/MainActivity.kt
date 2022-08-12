package com.example.myfirsttest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirsttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val emailValidator = EmailValidator()

    private val emailValidatorPattern = EmailValidatorImplPattern()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            editTextTextEmailAddress.addTextChangedListener(emailValidatorPattern)

            btnSave.setOnClickListener {
                when {
                    emailValidatorPattern.isValid -> {
                        Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_LONG).show()
                    }
                    emailValidatorPattern.text == null -> {
                        editTextTextEmailAddress.error = getString(R.string.error_email_null)
                    }
                    else -> {
                        editTextTextEmailAddress.error = getString(R.string.error_email)
                    }
                }
            }
        }
    }
}