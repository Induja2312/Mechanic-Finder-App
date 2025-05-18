package com.example.fin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FindMechanicActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MechanicAdapter
    private val mechanicsList = mutableListOf<Mechanic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_mechanic)

        // Toolbar setup
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Find Mechanic"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Adding sample mechanics (Replace with real data from database)
        mechanicsList.add(Mechanic("John Doe", "Engine Specialist", "123 Main St", "555-1234"))
        mechanicsList.add(Mechanic("Jane Smith", "Brake Repair", "456 Elm St", "555-5678"))

        adapter = MechanicAdapter(mechanicsList) { mechanic ->
            val intent = Intent(this, MechanicDetailsActivity::class.java).apply {
                putExtra("name", mechanic.name)
                putExtra("specialty", mechanic.specialty)
                putExtra("address", mechanic.address)
                putExtra("phone", mechanic.phone)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
