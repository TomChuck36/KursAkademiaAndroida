package com.atomczak.kursakademiaandroida.features.episodes.di

import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.EpisodeAdapter
import com.atomczak.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import com.atomczak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.EpisodeFragment
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.EpisodeViewModel
import com.atomczak.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment
import com.atomczak.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.atomczak.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.atomczak.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //navigator
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }

    //presentaion
    viewModel { EpisodeViewModel(get(), get(), get()) }
    viewModel { EpisodeDetailsViewModel() }

    factory { EpisodeFragment() }
    factory { EpisodeDetailsFragment() }
    factory { EpisodeAdapter() }
}