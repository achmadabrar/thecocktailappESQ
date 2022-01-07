package com.abrar.thecocktailapps.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abrar.thecocktailapps.R
import com.abrar.thecocktailapps.data.source.remote.models.Drink

class ListCocktailAdapter(private var drinks: List<Drink>, private var listener: Listener?): RecyclerView.Adapter<ListCocktailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCocktailViewHolder {
        return  ListCocktailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_cocktail, parent, false))
    }

    override fun onBindViewHolder(holder: ListCocktailViewHolder, position: Int) {
        drinks.get(position).let {
            holder.bind(it, listener)
        }
    }

    override fun getItemCount(): Int {
        return drinks.size
    }
}