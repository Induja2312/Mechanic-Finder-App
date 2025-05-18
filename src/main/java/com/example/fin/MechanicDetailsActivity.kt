package com.example.fin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MechanicDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic_details)

        val txtName: TextView = findViewById(R.id.txtName)
        val txtSpecialty: TextView = findViewById(R.id.txtSpecialty)
        val txtAddress: TextView = findViewById(R.id.txtAddress)
        val txtPhone: TextView = findViewById(R.id.txtPhone)
        val btnBookAppointment: Button = findViewById(R.id.btnBookAppointment)

        val name = intent.getStringExtra("name") ?: ""
        val specialty = intent.getStringExtra("specialty") ?: ""
        val address = intent.getStringExtra("address") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""

        txtName.text = name
        txtSpecialty.text = specialty
        txtAddress.text = "📍 $address"
        txtPhone.text = "📞 $phone"

        btnBookAppointment.setOnClickListener {
            val intent = Intent(this, BookAppointmentActivity::class.java).apply {
                putExtra("name", name)
                putExtra("specialty", specialty)
                putExtra("address", address)
                putExtra("phone", phone)
            }
            startActivity(intent)
        }
    }
}
