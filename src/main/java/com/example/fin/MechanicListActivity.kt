package com.example.fin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MechanicListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MechanicAdapter
    private val mechanicsList = mutableListOf<Mechanic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample mechanics data (Replace this with actual data from the database)
        mechanicsList.add(Mechanic("John Doe", "Engine Specialist", "123 Main Street, NY", "123-456-7890"))
        mechanicsList.add(Mechanic("Jane Smith", "Transmission Expert", "456 Oak Road, LA", "987-654-3210"))
        mechanicsList.add(Mechanic("Mike Johnson", "Brake Repair", "789 Pine Ave, TX", "555-123-4567"))

        // Set up the adapter with click listener
        adapter = MechanicAdapter(mechanicsList) { mechanic ->
            val intent = Intent(this, Mechanic::class.java).apply {
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
