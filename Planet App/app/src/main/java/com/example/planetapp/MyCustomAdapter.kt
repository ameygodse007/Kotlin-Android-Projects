package com.example.planetapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(planetsArrayList: ArrayList<Planet>, context: Context) :
    ArrayAdapter<Planet?>(context, R.layout.item_list_layout, planetsArrayList as List<Planet?>) {
    // Using Custom Layouts --> MyCustomAdapter
    // Using Custom Objects --> extends ArrayAdapter<Planet>
    private val planetsArrayList: ArrayList<Planet>;
    var contexts: Context;

    init {
        this.planetsArrayList = planetsArrayList
        this.contexts = context
    }

    // View Holder Class: used to cache references to the views within
    //                    an item layout, so that they don't need to be
    //                    repeatedly looked up during scrolling
    private class MyViewHolder {
        var planetName: TextView? = null
        var moonCount: TextView? = null
        var planetImg: ImageView? = null
    }

    // getView(): used to create and return a view for a
    //            specific item in the list.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // 1- Get the planet object for the current position
        var convertView = convertView
        val planets: Planet? = getItem(position)

        // 2- Inflate Layout:
        val myViewHolder: MyViewHolder
        val result: View
        if (convertView == null) {
            myViewHolder = MyViewHolder()
            val inflater = LayoutInflater.from(getContext())
            convertView = inflater.inflate(
                R.layout.item_list_layout,
                parent,
                false
            )

            // Finding Views:
            myViewHolder.planetName =
                convertView!!.findViewById<View>(R.id.planet_name) as TextView?
            myViewHolder.moonCount =
                convertView.findViewById<View>(R.id.moon_count_text) as TextView?
            myViewHolder.planetImg = convertView.findViewById<View>(R.id.imageView) as ImageView?
            result = convertView
            convertView.setTag(myViewHolder)
        } else {
            // the view is recycled
            myViewHolder = convertView.tag as MyViewHolder
            result = convertView
        }

        // Getting the data from model class (Planet)
        if (planets != null) {
            myViewHolder.planetName?.text = planets.getPlanetName()
        }
        if (planets != null) {
            myViewHolder.moonCount?.text = planets.getMoonCount()
        }
        if (planets != null) {
            myViewHolder.planetImg!!.setImageResource(planets.getPlanetImage())
        }
        return result
    }
}