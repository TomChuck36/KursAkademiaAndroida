package com.atomczak.kursakademiaandroida.features.episodes

import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}