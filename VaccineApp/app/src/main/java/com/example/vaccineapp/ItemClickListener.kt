package com.example.vaccineapp

import android.view.View

interface ItemClickListener {
    fun onClick(view: View?, pos: Int)
}