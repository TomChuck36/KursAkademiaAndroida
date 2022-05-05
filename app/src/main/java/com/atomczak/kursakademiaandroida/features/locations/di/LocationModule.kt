package com.atomczak.kursakademiaandroida.features.locations.di

import com.atomczak.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.atomczak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.atomczak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.atomczak.kursakademiaandroida.features.locations.presentation.LocationFragment
import com.atomczak.kursakademiaandroida.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    factory<LocationRepository> {
        LocationRepositoryImpl(get(), get(), get())
    }

    factory {
        GetLocationsUseCase(get())
    }

    viewModel {
        LocationViewModel(get())
    }

    factory {
        LocationFragment()
    }
}