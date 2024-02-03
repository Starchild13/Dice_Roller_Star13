package com.starchild13.dicerollerstar
/**
 * The code imports necessary Android classes: Bundle, Button, TextView, and AppCompatActivity.
Bundle is used to store and pass data between different components of an Android app.
Button represents a button widget for user interaction.
TextView displays text on the screen.
AppCompatActivity is a base class for activities that supports modern UI components on older Android versions.
 */
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * The code defines a class named MainActivity that extends AppCompatActivity.
The onCreate function is overridden to handle activity creation.
super.onCreate(savedInstanceState) performs necessary setup for the activity.
setContentView(R.layout.activity_main) sets the activity's layout.
val rollButton: Button = findViewById(R.id.button) finds the button view.
rollButton.setOnClickListener { rollDice() } sets a click listener on the button to execute the rollDice() function when clicked.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Define a variable called `rollButton` to hold a reference to the Button element from the layout with the ID `button`
        val rollButton: Button = findViewById(R.id.button)

// Set an `OnClickListener` on the `rollButton`.
// When `rollButton` is clicked, the `rollDice()` function will be called.
        rollButton.setOnClickListener { rollDice() }


        // Do a dice roll when the app starts
        rollDice()
    }
    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Define a variable called `diceImage` to hold a reference to the ImageView element from the layout with the ID `imageView`
        val diceImage: ImageView = findViewById(R.id.imageView)

// Set the content description of `diceImage` to the string value of `diceRoll`.
// This is important for accessibility purposes to describe the image to users with visual impairments.
        diceImage.contentDescription = diceRoll.toString()

// Determine the drawable resource ID based on the value of `diceRoll` using a `when` expression.
// This will map the value of `diceRoll` (which presumably is the result of a dice roll) to a specific drawable resource.
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            // If `diceRoll` is 6 or any other value, use `R.drawable.dice_6`
            else -> R.drawable.dice_6
        }

// Set the image resource of `diceImage` to the determined drawable resource.
// This will update the image displayed by `diceImage` to reflect the result of the dice roll.
        diceImage.setImageResource(drawableResource)



        // Update the screen with the dice roll
    }
}

/**
 * Allows for the dice to change values between 1 and 6 randomly.
 */
class Dice(private val numSides: Int) {
    //creating a function roll()
    fun roll(): Int {
        return (1..numSides).random() // return a number randomly from 1 to 6

    }
}