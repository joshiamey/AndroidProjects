package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()

        }
    }

    private fun rollDice() {
        val buttonToast: Toast = Toast.makeText(this, "Roll Button Clicked!",
            Toast.LENGTH_LONG)
        buttonToast.show()

        val resultTxt: TextView = findViewById(R.id.result_text)

        val randomInt = Random.nextInt(6) + 1

        resultTxt.text = randomInt.toString()

    }
}