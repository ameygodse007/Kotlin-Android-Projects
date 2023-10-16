package com.example.luckynumber


import com.example.luckynumber.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.luckynumber.R.layout

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var btn: Button? = null
    var txt: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.textView)
        editText = findViewById(R.id.edit_text)
        btn = findViewById(R.id.btn)
        btn?.setOnClickListener(View.OnClickListener {
            val userName = editText?.getText().toString()

            // Explicit Intent
            val i = Intent(
                applicationContext,
                SecondActivity::class.java
            )

            // Passing the name to second activity
            i.putExtra("name", userName)
            startActivity(i)
        })
    }
}