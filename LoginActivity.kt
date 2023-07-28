package com.monica.ec3_monica_gonzales_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import androidx.core.widget.addTextChangedListener
import com.monica.ec3_monica_gonzales_.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tilCorreo.editText?.addTextChangedListener { text ->
            binding.btnlogin.isEnabled = validateEmailPassword(text.toString(), binding.tilPassword.editText?.text.toString())
        }
        binding.tilPassword.editText?.addTextChangedListener { text ->
            binding.btnlogin.isEnabled = validateEmailPassword(binding.tilCorreo.editText?.text.toString(), text.toString())
        }
        binding.btnlogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun validateEmailPassword(email: String,password: String):Boolean{
        val isEmailValid = email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches() && email=="ejemplo@idat.edu.pe"
        val isPasswordValid = password.length >=6 && password=="123456"
        return isEmailValid && isPasswordValid
    }
}