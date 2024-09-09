package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast

class second_activivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_activivity)

        val spinnerShape = findViewById<Spinner>(R.id.spinner)
        val editTextValue = findViewById<EditText>(R.id.dannie)
        val buttonCalculate = findViewById<Button>(R.id.but2)
        val imageViewShape = findViewById<ImageView>(R.id.img)

        val shapes = arrayOf("Треугольник", "Круг")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerShape.adapter = adapter

        spinnerShape.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedShape = parent.getItemAtPosition(position).toString()
                when (selectedShape) {
                    "Треугольник" -> imageViewShape.setImageResource(R.drawable.treug)
                    "Круг" -> imageViewShape.setImageResource(R.drawable.circle)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        })
        buttonCalculate.setOnClickListener {
            val selectedShape = spinnerShape.selectedItem.toString()
            val value = editTextValue.text.toString().toDoubleOrNull()

            if (value != null) {
                val intent = Intent(this, fierd_activivity::class.java)
                intent.putExtra("shape", selectedShape)
                intent.putExtra("value", value)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Введите корректное значение", Toast.LENGTH_SHORT).show()
            }
        }
    }
}