package com.atomczak.kursakademiaandroida.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.atomczak.kursakademiaandroida.core.base.UiState
import com.atomczak.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.mock.mock
import com.atomczak.kursakademiaandroida.utils.ViewModelTest
import com.atomczak.kursakademiaandroida.utils.getOrAwaitValue
import com.atomczak.kursakademiaandroida.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN characters live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every {
                this@mockk(Unit, any(), any(), any())
            } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.status shouldBe character.status
            characterDisplayable.type shouldBe character.type
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN characters live data is observed THEN set idle state AND show error message`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every {
                this@mockk(Unit, any(), any(), any())
            } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = CharacterViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}