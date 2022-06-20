package com.atomczak.kursakademiaandroida.features.characters.navigation

import com.atomczak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {
    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}