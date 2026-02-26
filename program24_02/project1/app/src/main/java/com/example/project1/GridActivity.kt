package com.example.project1

import android.graphics.Color
import android.os.Bundle
import android.widget.GridLayout
import androidx.appcompat.app.AppCompatActivity

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        // 1. Знаходимо нашу сітку за ID
        val gridLayout = findViewById<GridLayout>(R.id.myGridLayout)

        // Масив наших кольорів: Червоний, Зелений, Синій (RGB)
        val colors = arrayOf(Color.RED, Color.GREEN, Color.BLUE)

        // 2. Проходимося по всіх елементах сітки (від 0 до 14)
        for (i in 0 until gridLayout.childCount) {
            val cell = gridLayout.getChildAt(i)

            // Визначаємо колонку: залишок від ділення на 3 (буде 0, 1 або 2)
            var currentColorIndex = i % 3

            // Встановлюємо стартовий колір
            cell.setBackgroundColor(colors[currentColorIndex])

            // 3. Вішаємо обробник натискання на кожну клітинку
            cell.setOnClickListener {
                // При натисканні беремо наступний колір (0->1, 1->2, 2->0)
                currentColorIndex = (currentColorIndex + 1) % 3

                // Змінюємо колір клітинки
                cell.setBackgroundColor(colors[currentColorIndex])
            }
        }
    }
}