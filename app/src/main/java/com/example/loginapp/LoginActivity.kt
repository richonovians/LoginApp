package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.emailInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email == "richo@gmail.com" && password == "123") {
                Log.d("LoginActivity", "Login berhasil dengan email: $email")
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("USER_EMAIL", email)
                startActivity(intent)
                finish()
            } else {
                val errorMessage = when {
                    email.isEmpty() -> "Email tidak boleh kosong"
                    password.isEmpty() -> "Password tidak boleh kosong"
                    else -> "Email atau password salah"
                }
                Log.d("LoginActivity", "Login gagal: $errorMessage")
                Toast.makeText(this, "Login gagal! $errorMessage", Toast.LENGTH_SHORT).show()
            }
        }
    }
}