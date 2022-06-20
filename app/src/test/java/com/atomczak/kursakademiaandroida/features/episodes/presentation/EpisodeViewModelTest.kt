package com.atomczak.kursakademiaandroida.features.episodes.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.atomczak.kursakademiaandroida.core.base.UiState
import com.atomczak.kursakademiaandroida.core.exception.ErrorMapper
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.EpisodeViewModel
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.atomczak.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.atomczak.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import com.atomczak.kursakademiaandroida.mock.mock
import com.atomczak.kursakademiaandroida.utils.ViewModelTest
import com.atomczak.kursakademiaandroida.utils.getOrAwaitValue
import com.atomczak.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodeViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THAN open episode details screen`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, episodeNavigator, errorMapper)
        val episode = EpisodeDisplayable.mock()

        //when
        viewModel.onEpisodeClick(episode)

        //than
        verify {
            episodeNavigator.openEpisodeDetailsScreen(episode)
        }
    }

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN episodes live data is observed THEN set idle state AND set result in live data`() {
        //given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val useCase = mockk<GetEpisodesUseCase> {
            every {
                this@mockk(Unit, any(), any(), any())
            } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodeViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episodes live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every {
                this@mockk(Unit, any(), any(), any())
            } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = EpisodeViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}