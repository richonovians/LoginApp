package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra("USER_EMAIL") ?: "User"
        val username = email.substringBefore("@") // Ambil bagian sebelum '@'

        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        welcomeText.text = "Hallo, $username! Selamat datang di Aplikasi Sederhana."

        // Animasi fade in
        val fadeIn = AlphaAnimation(0.0f, 1.0f)
        fadeIn.duration = 1000
        welcomeText.startAnimation(fadeIn)

        // Tombol Logout
        val logoutButton = findViewById<Button>(R.id.logoutButton)
        logoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Hapus back stack
            startActivity(intent)
            finish()
        }
    }
}