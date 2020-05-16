package com.example.rma_lv3_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeCounter();
        initializeButtons();
    }

    private fun initializeCounter() {
        counter = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE).getInt("COUNTER", 0)
        counterTv.text = counter.toString()
        counterTv.setTextColor(getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE).getInt("COLOR", Colors.BLACK.color))
    }

    private fun initializeButtons() {
        buttonRed.setOnClickListener{ counterIncrement(Colors.RED) }
        buttonGreen.setOnClickListener { counterIncrement(Colors.GREEN) }
        buttonBlue.setOnClickListener { counterIncrement(Colors.BLUE) }
        buttonYellow.setOnClickListener { counterIncrement(Colors.YELLOW) }
        reset.setOnClickListener { reset() }
    }

    override fun onStop() {
        super.onStop()
        setSharedPrefs(counter, counterTv.currentTextColor)
    }

    private fun setSharedPrefs(counter: Int, color: Int) {
        val sharedPrefs = getSharedPreferences("SHARED_PREFS", Context.MODE_PRIVATE)
        sharedPrefs.edit().putInt("COUNTER", counter).apply()
        sharedPrefs.edit().putInt("COLOR", color).apply()
    }

    private fun reset() {
        counter = 0
        counterTv.text = counter.toString()
        counterTv.setTextColor(getColor(R.color.black))
    }

    private fun counterIncrement (color: Colors) {
        counter++
        counterTv.text = counter.toString()
        val textColor = when (color) {
            Colors.BLUE -> getColor(R.color.blue)
            Colors.RED -> getColor(R.color.red)
            Colors.YELLOW -> getColor(R.color.yellow)
            Colors.GREEN -> getColor(R.color.green)
            else -> getColor(R.color.black)
        }
        counterTv.setTextColor(textColor)
    }
}
