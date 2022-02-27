package com.atomczak.kursakademiaandroida.features.episodes.data.repository

import com.atomczak.kursakademiaandroida.core.api.RickAndMortyApi
import com.atomczak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.atomczak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return rickAndMortyApi.getEpisodes().results.map {
            it.toEpisode()
        }.also {
            saveEpisodes(it)
        }
    }

    private suspend fun saveEpisodes(episodes: List<Episode>) {
        episodes.map {
            EpisodeCached(it)
        }.toTypedArray().let {
            episodeDao.saveEpisodes(*it)    // * służy do mapowania TypedArray na vararg
        }
    }
}