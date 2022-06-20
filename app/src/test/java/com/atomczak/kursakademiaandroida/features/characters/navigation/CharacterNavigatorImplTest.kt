package com.atomczak.kursakademiaandroida.features.characters.navigation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import com.atomczak.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterNavigatorImplTest {

    @Test
    fun `WHEN openCharacterDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and character model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)
        val character = CharacterDisplayable.mock()
        val slot = slot<Pair<String, CharacterDisplayable>>()

        //when
        characterNavigator.openCharacterDetailsScreen(character)

        //than
        verify {
            fragmentNavigator.navigateTo(
                destinationID = R.id.action_navigate_from_characters_to_character_details_screen,
                param = capture(slot)
            )
        }
        slot.captured.second shouldBe character
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val characterNavigator: CharacterNavigator = CharacterNavigatorImpl(fragmentNavigator)

        //when
        characterNavigator.goBack()

        //than
        verify {
            fragmentNavigator.goBack()
        }
    }
}