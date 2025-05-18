package com.example.fin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MechanicAdapter(
    private val mechanics: List<Mechanic>,
    private val onItemClick: (Mechanic) -> Unit
) : RecyclerView.Adapter<MechanicAdapter.MechanicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MechanicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mechanic, parent, false)
        return MechanicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MechanicViewHolder, position: Int) {
        val mechanic = mechanics[position]
        holder.bind(mechanic)
        holder.itemView.setOnClickListener {
            onItemClick(mechanic) // delegate click to activity
        }
    }

    override fun getItemCount(): Int = mechanics.size

    class MechanicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.txtName)
        private val txtSpecialty: TextView = itemView.findViewById(R.id.txtSpecialty)
        private val txtAddress: TextView = itemView.findViewById(R.id.txtAddress)
        private val txtPhone: TextView = itemView.findViewById(R.id.txtPhone)

        fun bind(mechanic: Mechanic) {
            txtName.text = mechanic.name
            txtSpecialty.text = mechanic.specialty
            txtAddress.text = "📍 ${mechanic.address}"
            txtPhone.text = "📞 ${mechanic.phone}"

            // Optional: increase text size & make it dark
            val textViews = listOf(txtName, txtSpecialty, txtAddress, txtPhone)
            for (tv in textViews) {
                tv.textSize = 16f
                tv.setTextColor(android.graphics.Color.BLACK)
            }
        }
    }
}

