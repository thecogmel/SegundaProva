package com.example.segundaprova.adapters

import android.text.Layout
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.segundaprova.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class ListViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    val textViewId : TextView
    val textViewNome  : TextView
    val rowLayout : View

    init {
        textViewId = v.findViewById(R.id.id_txt)
        textViewNome = v.findViewById(R.id.nome_txt)
        rowLayout = v.findViewById(R.id.rowLayout)
    }
}