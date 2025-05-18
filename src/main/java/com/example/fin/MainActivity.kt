package com.example.fin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var appointmentLayout: LinearLayout
    private lateinit var txtBookedDetails: TextView
    private lateinit var btnCancelAppointment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Mechanic Finder"

        // Initialize views
        val btnFindMechanic = findViewById<Button>(R.id.btnFindMechanic)
        appointmentLayout = findViewById(R.id.appointmentLayout)
        txtBookedDetails = findViewById(R.id.txtBookedDetails)
        btnCancelAppointment = findViewById(R.id.btnCancelAppointment)

        // Set click listener for "Find Mechanic" button
        btnFindMechanic.setOnClickListener {
            val intent = Intent(this, FindMechanicActivity::class.java)
            startActivity(intent)
        }

        // Set click listener for "Cancel Appointment" button
        btnCancelAppointment.setOnClickListener {
            val prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
            prefs.edit().clear().apply()
            appointmentLayout.visibility = View.GONE
            Toast.makeText(this, "Appointment canceled", Toast.LENGTH_SHORT).show()
        }

        // Load saved appointment if available
        val prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val savedDetails = prefs.getString("appointment_details", null)
        if (savedDetails != null) {
            txtBookedDetails.text = savedDetails
            appointmentLayout.visibility = View.VISIBLE
        } else {
            appointmentLayout.visibility = View.GONE
        }
    }
}
