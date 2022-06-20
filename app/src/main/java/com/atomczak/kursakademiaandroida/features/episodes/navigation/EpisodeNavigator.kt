package com.atomczak.kursakademiaandroida.features.episodes.navigation

import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {
    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}