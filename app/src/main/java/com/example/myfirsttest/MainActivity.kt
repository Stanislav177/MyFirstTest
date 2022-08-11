package com.example.myfirsttest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myfirsttest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            editTextTextEmailAddress.addTextChangedListener(emailValidator)

            btnSave.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_LONG).show()
                } else {
                    val errorEmail = getString(R.string.error_email)
                    editTextTextEmailAddress.error = errorEmail
                }
            }
        }
    }
}