package com.abrar.thecocktailapps.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.abrar.thecocktailapps.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ID = "id"

class DetailFragment : Fragment() {

    private var id: String? = null
    private val detailCockTailViewModel: DetailCockTailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getString(ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailCockTailViewModel.getDetail(id)

        with(detailCockTailViewModel) {
            details.observe(viewLifecycleOwner, Observer {
                tv_tags.text = "Tags : " +it.drinks.get(0).strTags
                tv_iba.text = "IBA :" +it.drinks.get(0).strIBA
                tv_drink_instructions.text = it.drinks.get(0).strInstructions
                tv_category.text = "Category :" +it.drinks.get(0).strCategory
                tv_drink_name.text = it.drinks.get(0).strDrink
                Glide.with(requireContext()).load(it.drinks[0].strDrinkThumb).into(iv_thumb)

                if (it.drinks.get(0).strTags == null) {
                    tv_tags.visibility = View.GONE
                }

                if (it.drinks.get(0).strIBA == null) {
                    tv_iba.visibility = View.GONE
                }

                if (it.drinks.get(0).strCategory == null) {
                    tv_category.visibility = View.GONE
                }
            })
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ID, id)
                }
            }
    }
}