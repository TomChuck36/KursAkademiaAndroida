package com.atomczak.kursakademiaandroida.features.episodes.di

import com.atomczak.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.atomczak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.atomczak.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.atomczak.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> {
        EpisodeRepositoryImpl(get(), get(), get(), get())
    }

    //domain
    factory {
        GetEpisodesUseCase(get())
    }

    //presentaion
    viewModel {
        EpisodeViewModel(get())
    }

    factory {
        EpisodeFragment()
    }
}