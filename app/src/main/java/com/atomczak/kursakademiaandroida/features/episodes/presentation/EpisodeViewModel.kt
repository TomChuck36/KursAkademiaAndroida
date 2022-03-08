package com.atomczak.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.*
import com.atomczak.kursakademiaandroida.core.base.UiState
import com.atomczak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.atomczak.kursakademiaandroida.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase
) : ViewModel() {

    private val _uiState by lazy {
        MutableLiveData<UiState>()
    }

    val uiState: LiveData<UiState> by lazy {
        _uiState
    }

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
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }
            result.onFailure {

            }
        }
    }

    private fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UiState.Pending
    }
}