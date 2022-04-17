package com.swancodes.dicegame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        val firstDice = Dice(6)
        val firstDiceRoll = firstDice.roll()

        val secondDice = Dice(6)
        val secondDiceRoll = secondDice.roll()

        val thirdDice = Dice(6)
        val thirdDiceRoll = thirdDice.roll()

        // Find the ImageView in the layout
        val diceImage1: ImageView = findViewById(R.id.diceImage1)
        val diceImage2: ImageView = findViewById(R.id.diceImage2)
        val diceImage3: ImageView = findViewById(R.id.diceImage3)

        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource1 = when (firstDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (secondDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource3 = when (thirdDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        if (firstDiceRoll == 6 && secondDiceRoll == 6 ||
            firstDiceRoll == 6 && thirdDiceRoll == 6 ||
            secondDiceRoll == 6 && thirdDiceRoll == 6
        ) {
            Toast.makeText(this, "You Win \uD83E\uDD29 \uD83E\uDD29", Toast.LENGTH_SHORT).show()
        } else if (firstDiceRoll == 5 && secondDiceRoll == 4 ||
            firstDiceRoll == 4 && secondDiceRoll == 5 ||
            secondDiceRoll == 4 && thirdDiceRoll == 5 ||
            secondDiceRoll == 5 && thirdDiceRoll == 4 ||
            thirdDiceRoll == 4 && firstDiceRoll == 5 ||
            thirdDiceRoll == 5 && firstDiceRoll == 4
        ) {
            Toast.makeText(this, "You Lose \uD83D\uDE41\uD83D\uDE41" , Toast.LENGTH_SHORT).show()
        }


        // Update the ImageView with the correct drawable resource ID
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        diceImage3.setImageResource(drawableResource3)

        // Update the content description
        diceImage1.contentDescription = firstDiceRoll.toString()
        diceImage2.contentDescription = secondDiceRoll.toString()
        diceImage3.contentDescription = thirdDiceRoll.toString()
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
