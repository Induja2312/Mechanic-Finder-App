package com.example.fin

import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class BookAppointmentActivity : AppCompatActivity() {

    private var selectedDate: String = ""
    private var selectedTime: String = ""
    private lateinit var vehicleSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        val txtMechanicDetails: TextView = findViewById(R.id.txtMechanicDetails)
        val calendarView: CalendarView = findViewById(R.id.calendarView)
        val txtTime: TextView = findViewById(R.id.txtTime)
        val btnPickTime: Button = findViewById(R.id.btnPickTime)
        val btnConfirm: Button = findViewById(R.id.btnConfirm)
        vehicleSpinner = findViewById(R.id.spinnerVehicle)

        // Mechanic data
        val name = intent.getStringExtra("name") ?: "Unknown"
        val specialty = intent.getStringExtra("specialty") ?: ""
        val address = intent.getStringExtra("address") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""

        txtMechanicDetails.text = "👨‍🔧 $name\n🔧 $specialty\n📍 $address\n📞 $phone"

        // Vehicle dropdown
        val vehicles = arrayOf("Bike", "Car", "Truck", "Scooter", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, vehicles)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        vehicleSpinner.adapter = adapter

        // Date selection
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$year-${month + 1}-$dayOfMonth"
        }

        // Time selection
        btnPickTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minute = cal.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this, { _, hourOfDay, min ->
                selectedTime = String.format("%02d:%02d", hourOfDay, min)
                txtTime.text = "⏰ $selectedTime"
            }, hour, minute, false)

            timePicker.show()
        }
// Assuming this is within your BookAppointmentActivity

// After collecting all necessary appointment details
        val selectedVehicle = "Car" // Example value; replace with actual selected vehicle
        val mechanicName = "John Doe" // Replace with actual mechanic name
        val mechanicAddress = "123 Main St" // Replace with actual address
        val mechanicPhone = "(555) 123-4567" // Replace with actual phone number
        val selectedDate = "2025-04-13" // Replace with actual selected date
        val selectedTime = "14:00" // Replace with actual selected time

// Save appointment details to SharedPreferences
        val prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE).edit()
        val details = """
    🚗 Vehicle: $selectedVehicle
    🔧 Mechanic: $mechanicName
    📍 Address: $mechanicAddress
    📞 Phone: $mechanicPhone
    📅 Date: $selectedDate
    ⏰ Time: $selectedTime
""".trimIndent()
        prefs.putString("appointment_details", details)
        prefs.apply()

        // Confirm button
        btnConfirm.setOnClickListener {
            val vehicle = vehicleSpinner.selectedItem.toString()

            if (selectedDate.isEmpty() || selectedTime.isEmpty()) {
                Toast.makeText(this, "Please select date and time", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "✅ Appointment booked on $selectedDate at $selectedTime for your $vehicle.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}
