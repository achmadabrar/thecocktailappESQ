package com.abrar.thecocktailapps.presentation.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abrar.thecocktailapps.data.source.remote.models.Drink
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_cocktail.view.*

class ListCocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(drink: Drink, listener: Listener?) {
        with(itemView) {
            Glide.with(this).load(drink.strDrinkThumb).into(iv_thumb)
            if (drink.strCategory.isNullOrBlank()) {
                tv_category.visibility = View.GONE
            }
            tv_category.text = "Category : "+drink.strCategory
            tv_drink_instructions.text = drink.strInstructions
            tv_drink_name.text = drink.strDrink
            itemView.setOnClickListener {
                listener?.onClickItem(drink.idDrink)
            }
        }
    }
}

interface Listener {
    fun onClickItem(id: String)
}