package com.monica.ec3_monica_gonzales_.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.monica.ec3_monica_gonzales_.databinding.ItemListBinding

import com.monica.ec3_monica_gonzales_.model.List_

class RvListAdapter(var lista: List<List_>) : RecyclerView.Adapter<ListVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListVH {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListVH(binding)

    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: ListVH, position: Int) {
        holder.bind(lista [position])
    }
}

class ListVH(private val binding: ItemListBinding) : ViewHolder(binding.root) {
    fun bind(list_: List_) {
        binding.txtListNameAnime.text = list_.anime_name

    }
}