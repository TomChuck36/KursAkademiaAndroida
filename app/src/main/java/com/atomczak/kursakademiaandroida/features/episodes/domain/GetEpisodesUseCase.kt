package com.atomczak.kursakademiaandroida.features.episodes.domain

import com.atomczak.kursakademiaandroida.core.base.UseCase
import com.atomczak.kursakademiaandroida.features.episodes.EpisodeRepository
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(
    private val episodeRepository: EpisodeRepository
) : UseCase<List<Episode>, Unit>() {
    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}