package com.mowael.universities.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mowael.core.data.UniversityDto
import com.mowael.universities.data.model.UniversityItem
import com.mowael.universities.databinding.LayoutUniversityItemBinding

class UniversitiesAdapter(
    private val universities: ArrayList<UniversityDto>,
    private val onClick: (id: Long, name: String?) -> Unit
) :
    RecyclerView.Adapter<UniversitiesAdapter.UniversitiesViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setUniversities(universities: List<UniversityDto>) {
        this.universities.clear()
        this.universities.addAll(universities)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversitiesViewHolder {
        val binding = LayoutUniversityItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UniversitiesViewHolder(binding, binding.root)
    }

    override fun getItemCount(): Int = universities.size


    override fun onBindViewHolder(holder: UniversitiesViewHolder, position: Int) {
        holder.bind(universities[position], onClick)
    }

    class UniversitiesViewHolder(private val binding: LayoutUniversityItemBinding, itemView: View) :
        ViewHolder(itemView) {
        fun bind(university: UniversityDto, onClick: (id: Long, name: String?) -> Unit) {
            binding.root.setOnClickListener {
                onClick(university.id, university.name)
            }
            binding.tvName.text = university.name
            binding.tvState.text = university.stateProvince
        }
    }
}