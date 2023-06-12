package com.example.l2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText
import kotlin.math.sqrt
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun solve(view: View) {
        val output = findViewById<TextView>(R.id.output)
        try {
            val a = findViewById<EditText>(R.id.inputA).text.toString().toDouble()
            val b = findViewById<EditText>(R.id.inputB).text.toString().toDouble()
            val c = findViewById<EditText>(R.id.inputC).text.toString().toDouble()
            val d = (b * b - 4 * a * c)

            if (d > 0.0){
                if (a == 0.0) {
                    val x = String.format("%.2f", (-c / b)).trimEnd('0').trimEnd('.')
                    output.text = "Линейное уравнение: x = $x"
                }
                else {
                    val x1 = String.format("%.2f", ((-b + sqrt(d)) / (2 * a))).trimEnd('0').trimEnd('.')
                    val x2 = String.format("%.2f", ((-b - sqrt(d)) / (2 * a))).trimEnd('0').trimEnd('.')
                    output.text = "x1 = $x1\nx2 = $x2"
                }
            }
            else if (d == 0.0) {
                if (a != 0.0){
                    val x = String.format("%.2f",(-b / (2 * a))).trimEnd('0').trimEnd('.')
                    output.text = "x1 = x2 = $x"
                }
                else if (a == 0.0 && b == 0.0 && c == 0.0) {
                    output.text = "Уравнение решаемо при любых корнях"
                }
                else {
                    output.text = "Нет корней"
                }
            }
            else {
                output.text = "Нет корней"
            }
        }

        catch (e: Exception) {
            output.text = "Ошибка, введите значения коэффициентов"
        }
    }
}