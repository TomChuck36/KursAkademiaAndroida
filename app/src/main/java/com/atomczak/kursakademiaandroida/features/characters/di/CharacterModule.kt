package com.atomczak.kursakademiaandroida.features.characters.di

import com.atomczak.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import com.atomczak.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.atomczak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.atomczak.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.atomczak.kursakademiaandroida.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    factory<CharacterRepository> {
        CharacterRepositoryImpl(get(), get(), get(), get())
    }

    factory {
        GetCharactersUseCase(get())
    }

    viewModel {
        CharacterViewModel(get(), get())
    }

    factory {
        CharacterFragment()
    }
}