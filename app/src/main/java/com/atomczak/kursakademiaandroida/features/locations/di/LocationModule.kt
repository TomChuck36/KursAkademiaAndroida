package com.atomczak.kursakademiaandroida.features.locations.di

import com.atomczak.kursakademiaandroida.features.locations.all.presentation.LocationFragment
import com.atomczak.kursakademiaandroida.features.locations.all.presentation.LocationViewModel
import com.atomczak.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import com.atomczak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment
import com.atomczak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsViewModel
import com.atomczak.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import com.atomczak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.atomczak.kursakademiaandroida.features.locations.navigation.LocationNavigator
import com.atomczak.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }
    factory { GetLocationsUseCase(get()) }
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
    viewModel { LocationViewModel(get(), get(), get()) }
    viewModel { LocationDetailsViewModel() }
    factory { LocationFragment() }
    factory { LocationDetailsFragment() }
}