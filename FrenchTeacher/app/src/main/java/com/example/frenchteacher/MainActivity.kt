package com.example.frenchteacher;


import com.example.frenchteacher.R
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var blackBtn: Button? = null
    var yellowBtn: Button? = null
    var redBtn: Button? = null
    var purpleBtn: Button? = null
    var greenBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        blackBtn = findViewById(R.id.blackBtn)
        redBtn = findViewById(R.id.redBtn)
        yellowBtn = findViewById(R.id.yellowBtn)
        purpleBtn = findViewById(R.id.purpleBtn)
        greenBtn = findViewById(R.id.greenBtn)
        redBtn?.setOnClickListener(this)
        blackBtn?.setOnClickListener(this)
        yellowBtn?.setOnClickListener(this)
        purpleBtn?.setOnClickListener(this)
        greenBtn?.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        // Find the button by ID and play the correct sound
        val clickedBtnId = v.id
        if (clickedBtnId == R.id.redBtn) {
            PlaySounds(R.raw.red)
        } else if (clickedBtnId == R.id.blackBtn) {
            PlaySounds(R.raw.black)
        } else if (clickedBtnId == R.id.greenBtn) {
            PlaySounds(R.raw.green)
        } else if (clickedBtnId == R.id.purpleBtn) {
            PlaySounds(R.raw.purple)
        } else if (clickedBtnId == R.id.yellowBtn) {
            PlaySounds(R.raw.yellow)
        }
    }

    fun PlaySounds(id: Int) {
        val mediaPlayer = MediaPlayer.create(
            this,
            id
        )
        mediaPlayer.start()
    }
}