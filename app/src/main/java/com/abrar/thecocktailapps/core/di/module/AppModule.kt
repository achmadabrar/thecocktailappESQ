package com.abrar.thecocktailapps.core.di.module

import com.abrar.thecocktailapps.presentation.detail.DetailCockTailViewModel
import com.abrar.thecocktailapps.presentation.list.ListCocktailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { ListCocktailViewModel(get()) }

    viewModel { DetailCockTailViewModel(get()) }

    single { createListUseCase(get()) }

    single { createListRepository(get()) }
}