package com.atomczak.kursakademiaandroida.features.episodes.data.repository

import com.atomczak.kursakademiaandroida.core.api.RickAndMortyApi
import com.atomczak.kursakademiaandroida.core.exception.ErrorWrapper
import com.atomczak.kursakademiaandroida.core.exception.callOrThrow
import com.atomczak.kursakademiaandroida.core.network.NetworkStateProvider
import com.atomczak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.atomczak.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) {
                getEpisodesFromRemote()
            }.also {
                saveEpisodesToLocal(it)
            }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return rickAndMortyApi.getEpisodes().results.map {
            it.toEpisode()
        }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map {
            EpisodeCached(it)
        }.toTypedArray().let {
            episodeDao.saveEpisodes(*it)    // * służy do mapowania TypedArray na vararg
        }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes().map {
            it.toEpisode()
        }
    }
}