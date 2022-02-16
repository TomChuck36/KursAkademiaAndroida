package com.atomczak.kursakademiaandroida.features.characters.domain

import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}