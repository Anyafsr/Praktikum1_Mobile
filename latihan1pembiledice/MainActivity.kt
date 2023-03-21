package com.example.latihan1pembiledice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/** untuk membuat tampilan hasil acak dadu pada user */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button3)
        rollButton.setOnClickListener { rollDice() }
        //akan roll dadu otomatis saat aplikasi dibuka
        rollDice()
    }
    /** untuk mengupdate tampilan ke user setelah dadu di Roll */
    private fun rollDice() {
        // membuat objek dadu baru 6 sisi kemudian Roll
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // memanggil image
        val diceImage: ImageView = findViewById(R.id.imageView)
        // deklarasi image sesuai dengan nama file yang tersimpan
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

// membuat class dadu untuk logika roll dadu
class Dice(private val numSides: Int) {
    //untuk roll dadu acak dan mengembalikan hasilnya
    fun roll(): Int {
        return (1..numSides).random()
    }
}