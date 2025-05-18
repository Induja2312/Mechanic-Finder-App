package com.example.fin

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MechanicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val nameTextView: TextView = itemView.findViewById(R.id.txtName)
    private val specialtyTextView: TextView = itemView.findViewById(R.id.txtSpecialty)
    private val phoneTextView: TextView = itemView.findViewById(R.id.txtPhone)
    private val addressTextView: TextView = itemView.findViewById(R.id.txtAddress) // New

    fun bind(mechanic: Mechanic) {
        nameTextView.text = mechanic.name
        specialtyTextView.text = mechanic.specialty
        phoneTextView.text = mechanic.phone
        addressTextView.text = mechanic.address // New
    }
}
