package com.atomczak.kursakademiaandroida.features.episodes.data.repository

import com.atomczak.kursakademiaandroida.core.api.RickAndMortyApi
import com.atomczak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return api.getEpisodes().results.map {
            it.toEpisode()
        }
    }
}