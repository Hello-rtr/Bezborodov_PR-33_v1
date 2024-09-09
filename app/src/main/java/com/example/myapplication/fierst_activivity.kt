package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class fierst_activivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fierst_activivity)

        var sharedPreferences: SharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)

        val editTextLogin = findViewById<EditText>(R.id.login)
        val editTextPassword = findViewById<EditText>(R.id.pass)
        val buttonRegister = findViewById<Button>(R.id.Registr)

        buttonRegister.setOnClickListener {
            val login = editTextLogin.text.toString()
            val password = editTextPassword.text.toString()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
            } else {
                val savedLogin = sharedPreferences.getString("login", "")
                val savedPassword = sharedPreferences.getString("password", "")

                if (login == "hello " && password == "hello " || (login == savedLogin && password == savedPassword)) {
                    val editor = sharedPreferences.edit()
                    editor.putString("login", login)
                    editor.putString("password", password)
                    editor.apply()

                    val intent = Intent(this, second_activivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}