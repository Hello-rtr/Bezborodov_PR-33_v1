package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class fierd_activivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fierd_activivity)

        val textViewResult = findViewById<TextView>(R.id.rez)
        val textViewFigure = findViewById<TextView>(R.id.figure)

        val shape = intent.getStringExtra("shape")
        val value = intent.getDoubleExtra("value", 0.0)

        val result = when (shape) {
            "Треугольник" -> "Периметр треугольника: ${value * 3}"
            "Круг" -> "Радиус круга: ${value / (2 * Math.PI)}"
            else -> "Неизвестная фигура"
        }
        val figure = when (shape) {
            "Треугольник" -> "Треугольник"
            "Круг" -> "Круг"
            else -> "Неизвестная фигура"
        }
        textViewResult.text = result
        textViewFigure.text = figure
    }
}