package com.example.vaccineapp

class VaccineModel(val title: String, private val image: Int) {

    @JvmName("getTitle1")
    fun getTitle(): String {
        return title
    }

    fun getImage(): Int {
        return image
    }
}
