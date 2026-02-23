package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Змінні для збереження стану, як ви робили на парах
    var first = ""
    var second = ""
    var action = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Функція для швидкого оновлення екрану
        fun updateScreen() {
            tvResult.text = first + action + second
        }

        // ================= ЦИФРИ =================
        val btn0 = findViewById<Button>(R.id.btn0)
        btn0.setOnClickListener { if (action.isEmpty()) first += "0" else second += "0"; updateScreen() }

        val btn1 = findViewById<Button>(R.id.btn1)
        btn1.setOnClickListener { if (action.isEmpty()) first += "1" else second += "1"; updateScreen() }

        val btn2 = findViewById<Button>(R.id.btn2)
        btn2.setOnClickListener { if (action.isEmpty()) first += "2" else second += "2"; updateScreen() }

        val btn3 = findViewById<Button>(R.id.btn3)
        btn3.setOnClickListener { if (action.isEmpty()) first += "3" else second += "3"; updateScreen() }

        val btn4 = findViewById<Button>(R.id.btn4)
        btn4.setOnClickListener { if (action.isEmpty()) first += "4" else second += "4"; updateScreen() }

        val btn5 = findViewById<Button>(R.id.btn5)
        btn5.setOnClickListener { if (action.isEmpty()) first += "5" else second += "5"; updateScreen() }

        val btn6 = findViewById<Button>(R.id.btn6)
        btn6.setOnClickListener { if (action.isEmpty()) first += "6" else second += "6"; updateScreen() }

        val btn7 = findViewById<Button>(R.id.btn7)
        btn7.setOnClickListener { if (action.isEmpty()) first += "7" else second += "7"; updateScreen() }

        val btn8 = findViewById<Button>(R.id.btn8)
        btn8.setOnClickListener { if (action.isEmpty()) first += "8" else second += "8"; updateScreen() }

        val btn9 = findViewById<Button>(R.id.btn9)
        btn9.setOnClickListener { if (action.isEmpty()) first += "9" else second += "9"; updateScreen() }


        // ================= ДІЇ (+, -, *, /) =================
        val btnPlus = findViewById<Button>(R.id.btnPlus)
        btnPlus.setOnClickListener {
            if (first.isNotEmpty()) { action = "+"; updateScreen() }
        }

        val btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMinus.setOnClickListener {
            if (first.isNotEmpty()) { action = "-"; updateScreen() }
        }

        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnMultiply.setOnClickListener {
            if (first.isNotEmpty()) { action = "*"; updateScreen() }
        }

        val btnDivide = findViewById<Button>(R.id.btnDivide)
        btnDivide.setOnClickListener {
            if (first.isNotEmpty()) { action = "/"; updateScreen() }
        }


        // ================= ОЧИЩЕННЯ (CLEAR) =================
        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener {
            first = ""
            second = ""
            action = ""
            tvResult.text = ""
        }


        // ================= ДОРІВНЮЄ (=) =================
        val btnEquals = findViewById<Button>(R.id.btnEquals)
        btnEquals.setOnClickListener {
            // Перевіряємо, чи введено всі дані для розрахунку
            if (first.isNotEmpty() && second.isNotEmpty() && action.isNotEmpty()) {
                val num1 = first.toInt()
                val num2 = second.toInt()
                var res = 0

                // Виконуємо математику
                if (action == "+") res = num1 + num2
                if (action == "-") res = num1 - num2
                if (action == "*") res = num1 * num2
                if (action == "/") {
                    if (num2 != 0) {
                        res = num1 / num2
                    } else {
                        // Захист від ділення на нуль, щоб додаток не вилетів
                        tvResult.text = "Помилка"
                        first = ""
                        second = ""
                        action = ""
                        return@setOnClickListener
                    }
                }

                // Виводимо результат і записуємо його як перше число для наступних дій
                tvResult.text = res.toString()
                first = res.toString()
                second = ""
                action = ""
            }
        }
    }
}