package com.example.worlde

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.KeyListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val answerView = findViewById<TextView>(R.id.answerView)
        answerView.text = wordToGuess

        val guess1View = findViewById<TextView>(R.id.guess1TextView)
        val guess1Text = findViewById<EditText>(R.id.guess1)

        val guess2View = findViewById<TextView>(R.id.guess2TextView)
        val guess2Text = findViewById<EditText>(R.id.guess2)

        val guess3View = findViewById<TextView>(R.id.guess3TextView)
        val guess3Text = findViewById<EditText>(R.id.guess3)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val resetButton = findViewById<Button>(R.id.resetButton)


        var arrayIndex = 0
        val viewArray = arrayOf(guess1View,guess2View,guess3View)
        val textArray = arrayOf(guess1Text,guess2Text,guess3Text)

        submitButton.setOnClickListener{
            val currTArray = textArray[arrayIndex]
            val guess = currTArray.text.toString().uppercase()

            if (guess.length.equals(4))
            {
                if (guess.equals(wordToGuess))
                {
                    answerView.visibility = View.VISIBLE
                    resetButton.visibility = View.VISIBLE
                    submitButton.visibility = View.INVISIBLE
                }
                else
                {
                    arrayIndex++
                }

                currTArray.setText(checkGuess(guess))

                // Disable the text box
                currTArray.setInputType(InputType.TYPE_NULL)
                currTArray.setEnabled(false)

                // Toast.makeText(it.context,wordToGuess,Toast.LENGTH_SHORT).show()

                if (arrayIndex > 2)
                {
                    submitButton.visibility = View.INVISIBLE
                    answerView.visibility = View.VISIBLE
                    resetButton.visibility = View.VISIBLE
                }
                else
                {
                    viewArray[arrayIndex].visibility = View.VISIBLE
                    textArray[arrayIndex].visibility = View.VISIBLE
                }

                //Toast.makeText(it.context,textArray[arrayIndex].text,Toast.LENGTH_SHORT).show()
            }
        }

        resetButton.setOnClickListener {
            // Enable input and clear the text boxes for guesses
            for(view in textArray)
            {
                view.inputType = InputType.TYPE_CLASS_TEXT
                view.setEnabled(true)
                view.setText("",TextView.BufferType.EDITABLE)
            }
            for (index in 1..2)
            {
                viewArray[index].visibility = View.INVISIBLE
                textArray[index].visibility = View.INVISIBLE
            }

            submitButton.visibility = View.VISIBLE
            resetButton.visibility = View.INVISIBLE
            answerView.visibility = View.INVISIBLE

            arrayIndex = 0

            // set a new random word to guess
            wordToGuess = FourLetterWordList.getRandomFourLetterWord()
            answerView.text = wordToGuess
        }
    }


    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

}