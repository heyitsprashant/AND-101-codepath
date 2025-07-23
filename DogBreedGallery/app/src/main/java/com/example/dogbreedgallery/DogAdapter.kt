// DogAdapter.kt
package com.example.dogbreedgallery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.*
import kotlin.collections.ArrayList

class DogAdapter(private val context: Context) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private val dogs = ArrayList<Dog>()
    private val allDogs = ArrayList<Dog>()

    fun setDogs(newDogs: List<Dog>) {
        dogs.clear()
        dogs.addAll(newDogs)
        allDogs.clear()
        allDogs.addAll(newDogs)
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        val filtered = allDogs.filter {
            it.breedName.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))
        }
        setDogs(filtered)
    }

    inner class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dogImage: ImageView = view.findViewById(R.id.dogImage)
        val breedName: TextView = view.findViewById(R.id.breedName)

        init {
            view.setOnClickListener {
                val dog = dogs[absoluteAdapterPosition]
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("imageUrl", dog.imageUrl)
                    putExtra("breedName", dog.breedName) // Pass raw key format e.g. "terrier-bedlington"
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dog = dogs[position]
        holder.breedName.text = formatBreedName(dog.breedName)
        Glide.with(context).load(dog.imageUrl).into(holder.dogImage)
    }

    override fun getItemCount(): Int = dogs.size

    private fun formatBreedName(raw: String): String {
        val parts = raw.split("-")
        return if (parts.size > 1) parts.reversed().joinToString(" ") { it.replaceFirstChar(Char::uppercaseChar) }
        else raw.replaceFirstChar(Char::uppercaseChar)
    }
}
