package com.atomczak.kursakademiaandroida.features.characters.di

import com.atomczak.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.atomczak.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.atomczak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.CharacterFragment
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.CharacterViewModel
import com.atomczak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import com.atomczak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsViewModel
import com.atomczak.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import com.atomczak.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }
    factory { GetCharactersUseCase(get()) }
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
    viewModel { CharacterViewModel(get(), get(), get()) }
    viewModel { CharacterDetailsViewModel() }
    factory { CharacterFragment() }
    factory { CharacterDetailsFragment() }
}