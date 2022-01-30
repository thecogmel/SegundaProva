package com.example.segundaprova.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.R
import com.example.segundaprova.data.Restaurante
import com.example.segundaprova.fragments.HomeFragmentDirections

class ListAdapter() : RecyclerView.Adapter<ListViewHolder>() {

    private var restauranteList = emptyList<Restaurante>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
        return ListViewHolder(view)
    }
    override fun getItemCount(): Int {
        return restauranteList.size
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = restauranteList[position]
        holder.textViewId.text = currentItem.id.toString()
        holder.textViewNome.text = currentItem.nome

        holder.rowLayout.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAlteraFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }
    }

    fun setData(restaurante : List<Restaurante>){
        this.restauranteList = restaurante
        notifyDataSetChanged()
    }
}