package com.example.rockpaperscissors

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var playerChoiceText: TextView
    private lateinit var computerChoiceText: TextView
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        playerChoiceText = findViewById(R.id.tvPlayerChoice)
        computerChoiceText = findViewById(R.id.tvComputerChoice)
        resultText = findViewById(R.id.tvResult)

        val rockButton: Button = findViewById(R.id.btnRock)
        val paperButton: Button = findViewById(R.id.btnPaper)
        val scissorsButton: Button = findViewById(R.id.btnScissors)

        rockButton.setOnClickListener {
            playGame("Rock")
        }

        paperButton.setOnClickListener {
            playGame("Paper")
        }

        scissorsButton.setOnClickListener {
            playGame("Scissors")
        }
    }

    private fun playGame(playerChoice: String) {
        val choices = listOf("Rock", "Paper", "Scissors")
        val computerChoice = choices[Random.nextInt(choices.size)]

        val result = findWinner(playerChoice, computerChoice)

        playerChoiceText.text = "Your choice: $playerChoice"
        computerChoiceText.text = "Computer choice: $computerChoice"
        resultText.text = result
    }

    private fun findWinner(
        playerChoice: String,
        computerChoice: String
    ): String {

        if (playerChoice == computerChoice) {
            return "Draw!"
        }

        if (
            (playerChoice == "Rock" && computerChoice == "Scissors") ||
            (playerChoice == "Paper" && computerChoice == "Rock") ||
            (playerChoice == "Scissors" && computerChoice == "Paper")
        ) {
            return "You win!"
        }

        return "Computer wins!"
    }
}
