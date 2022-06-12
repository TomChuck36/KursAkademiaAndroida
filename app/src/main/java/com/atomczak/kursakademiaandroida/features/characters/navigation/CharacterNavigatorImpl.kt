package com.atomczak.kursakademiaandroida.features.characters.navigation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

class CharacterNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            destinationID = R.id.action_navigate_from_characters_to_character_details_screen,
            param = CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}