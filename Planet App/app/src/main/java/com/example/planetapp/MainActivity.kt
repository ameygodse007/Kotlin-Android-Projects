package com.example.planetapp

import com.example.planetapp.R
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var planetsArrayList: ArrayList<Planet>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1- AdapterView: a ListView
        listView = findViewById(R.id.listview)

        // 2- Data Source: ArrayList<Planet>
        planetsArrayList = ArrayList()
        val planet3 = Planet("Earth", "1 Moon", R.drawable.earth)
        val planet1 = Planet("Mercury", "0 Moons", R.drawable.mercury)
        val planet2 = Planet("Venus", "0 Moons", R.drawable.venus)
        val planet4 = Planet("Mars", "2 Moons", R.drawable.mars)
        val planet5 = Planet("Jupiter", "79 Moons", R.drawable.jupiter)
        val planet6 = Planet("Saturn", "83 Moons", R.drawable.saturn)
        val planet7 = Planet("Uranus", "27 Moons", R.drawable.uranus)
        val planet8 = Planet("Neptune", "14 Moons", R.drawable.neptune)
        planetsArrayList!!.add(planet1)
        planetsArrayList!!.add(planet2)
        planetsArrayList!!.add(planet3)
        planetsArrayList!!.add(planet4)
        planetsArrayList!!.add(planet5)
        planetsArrayList!!.add(planet6)
        planetsArrayList!!.add(planet7)
        planetsArrayList!!.add(planet8)


        // Adapter:
        adapter = MyCustomAdapter(planetsArrayList!!, applicationContext)
        this.listView?.adapter = adapter


        // Handling Click Events
        listView?.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                this@MainActivity,
                "Planet Name: " + adapter!!.getItem(position)!!.getPlanetName(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        private var adapter: MyCustomAdapter? = null
    }
}