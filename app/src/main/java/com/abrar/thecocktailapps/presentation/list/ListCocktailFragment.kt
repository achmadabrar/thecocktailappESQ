package com.abrar.thecocktailapps.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.abrar.thecocktailapps.R
import com.abrar.thecocktailapps.external.isNetworkAvailable
import com.abrar.thecocktailapps.presentation.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_list_cocktail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCocktailFragment : Fragment(), Listener {

    lateinit var adapter: ListCocktailAdapter
    private val listCocktailViewModel: ListCocktailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_cocktail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (requireContext().isNetworkAvailable()) {
            listCocktailViewModel.getListCocktailByName("Margarita")
        } else {
            Toast.makeText(requireContext(), "Periksa Kembali Koneksi", Toast.LENGTH_SHORT).show()
        }

        loadSpinner()

        with(listCocktailViewModel) {
            listCocktail.observe(viewLifecycleOwner, Observer {
                adapter = ListCocktailAdapter(it.drinks, this@ListCocktailFragment)
                loadRecyclerView()
            })
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                listCocktailViewModel.getListCocktailByName(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    fun loadSpinner() {
        val adapter = ArrayAdapter.createFromResource(requireContext(), R.array.filter_list, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_filter.adapter = adapter
        spinner_filter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                when(parent?.getItemAtPosition(position).toString()) {
                   "Alcoholic" -> listCocktailViewModel.getListCocktailByAlcoholic(parent?.getItemAtPosition(position).toString())
                   "Non_Alcoholic" -> listCocktailViewModel.getListCocktailByAlcoholic(parent?.getItemAtPosition(position).toString())
                    "Ordinary_Drink" -> listCocktailViewModel.getListCocktailByCategory(parent?.getItemAtPosition(position).toString())
                    "Cocktail" -> listCocktailViewModel.getListCocktailByCategory(parent?.getItemAtPosition(position).toString())
                    "Cocktail_glass" -> listCocktailViewModel.getListCocktailByGlass(parent?.getItemAtPosition(position).toString())
                    "Champagne_flute" -> listCocktailViewModel.getListCocktailByGlass(parent?.getItemAtPosition(position).toString())
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //do nothing
            }

        }
    }

    fun loadRecyclerView() {
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onClickItem(id: String) {
        fragmentManager?.beginTransaction()?.replace(R.id.frameLayout, DetailFragment.newInstance(id))?.addToBackStack("detail")?.commit()
    }

}