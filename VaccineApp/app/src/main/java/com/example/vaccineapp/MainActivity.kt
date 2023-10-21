package com.example.vaccineapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ItemClickListener {

    // 1- AdapterView: RecyclerView
    private lateinit var recyclerView: RecyclerView

    // 2- Data Source:
    private lateinit var myListData: Array<VaccineModel>

    // 3- Adapter
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        myListData = arrayOf(
            VaccineModel("Hepatitis B Vaccine", R.drawable.vaccine1),
            VaccineModel("Tetanus Vaccine", R.drawable.vaccine4),
            VaccineModel("Pneumococcal Vaccine", R.drawable.vaccine5),
            VaccineModel("Rotavirus Vaccine", R.drawable.vaccine6),
            VaccineModel("Measles Virus", R.drawable.vaccine7),
            VaccineModel("Cholera  Virus", R.drawable.vaccine8),
            VaccineModel("Covid-19 Virus", R.drawable.vaccine9)
        )

        // Adapter
        adapter = MyAdapter(myListData)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Handling the Click Events
        adapter.setClickListener(this)
    }

    override fun onClick(view: View?, pos: Int) {
        Toast.makeText(
            this,
            "Vaccine name: " + myListData[pos].title, Toast.LENGTH_SHORT
        ).show()
    }
}
