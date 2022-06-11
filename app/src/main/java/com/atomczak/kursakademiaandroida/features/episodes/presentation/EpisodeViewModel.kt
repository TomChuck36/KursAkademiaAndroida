package com.atomczak.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.atomczak.kursakademiaandroida.core.base.BaseViewModel
import com.atomczak.kursakademiaandroida.core.exception.ErrorMapper
import com.atomczak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.atomczak.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>().also {
            getEpisodes(it)
        }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map {
                EpisodeDisplayable(it)
            }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}