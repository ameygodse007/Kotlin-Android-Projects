package com.example.planetapp

// This class is acting as Model Class for our ListView
class Planet {

    // Attributes
    private var planetName: String? = null
    private var moonCount: String? = null
    private var planetImage = 0

    // Constructor
    constructor(planetName: String?, moonCount: String?, planetImage: Int) {
        this.planetName = planetName
        this.moonCount = moonCount
        this.planetImage = planetImage
    }

    // Getters & Setters
    fun getPlanetName(): String? {
        return planetName
    }

    fun setPlanetName(planetName: String?) {
        this.planetName = planetName
    }

    fun getMoonCount(): String? {
        return moonCount
    }

    fun setMoonCount(moonCount: String?) {
        this.moonCount = moonCount
    }

    fun getPlanetImage(): Int {
        return planetImage
    }

    fun setPlanetImage(planetImage: Int) {
        this.planetImage = planetImage
    }
}
