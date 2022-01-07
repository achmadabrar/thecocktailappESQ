package com.abrar.thecocktailapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abrar.thecocktailapps.presentation.list.ListCocktailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack("popular")
        transaction.replace(R.id.frameLayout, ListCocktailFragment(), "listCocktailFr")
        transaction.commit()
    }
}