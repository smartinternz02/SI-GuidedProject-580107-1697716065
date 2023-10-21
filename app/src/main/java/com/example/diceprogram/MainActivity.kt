package com.example.diceprogram

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

import java.util.*

class MainActivity : ComponentActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var rollButton: Button
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
        rollButton = findViewById(R.id.rollButton)
        imageView = findViewById(R.id.imageView)

        rollButton.setOnClickListener{ rollDice() }
    }

    private fun rollDice() {
        val random = Random()
        val randomNumber = random.nextInt(6) + 1
        val resultText = "You rolled a $randomNumber"
        resultTextView.text = resultText

        val diceImage: ImageView = findViewById(R.id.imageView)

        if (randomNumber == 1) {
            diceImage.setImageResource(R.drawable.dice1)
        }
        else if (randomNumber == 2) {
            diceImage.setImageResource(R.drawable.dice2)
        }
        else if (randomNumber == 3) {
            diceImage.setImageResource(R.drawable.dice3)
        }
        else if (randomNumber == 4) {
            diceImage.setImageResource(R.drawable.dice4)
        }
        else if (randomNumber == 5) {
            diceImage.setImageResource(R.drawable.dice5)
        }
        else {
            diceImage.setImageResource(R.drawable.dice6)
        }
    }
}