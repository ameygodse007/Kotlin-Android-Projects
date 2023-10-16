package com.example.luckynumber

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import com.example.luckynumber.R.layout

class SecondActivity : AppCompatActivity() {
    var welcomeTxt: TextView? = null
    var luckyNumberTxt: TextView? = null
    var share_btn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        welcomeTxt = findViewById(R.id.textView2)
        luckyNumberTxt = findViewById(R.id.lucky_number_txt)
        share_btn = findViewById(R.id.share_btn)

        // Receiving the data from Main Activity
        val i = intent
        val userName = i.getStringExtra("name")

        // Generating Random Numbers
        val random_num = generateRandomNumber()
        luckyNumberTxt?.setText("" + random_num)
        share_btn?.setOnClickListener(View.OnClickListener { shareData(userName, random_num) })
    }

    fun generateRandomNumber(): Int {
        val random = Random()
        val upper_limit = 1000
        return random.nextInt(upper_limit)
    }

    fun shareData(username: String?, randomNum: Int) {
        // Implicit Intent
        val i = Intent(Intent.ACTION_SEND)
        i.type = "text/plain"

        // Additional Info
        i.putExtra(Intent.EXTRA_SUBJECT, "$username got lucky today!")
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: $randomNum")
        startActivity(Intent.createChooser(i, "Choose a Platform"))
    }
}