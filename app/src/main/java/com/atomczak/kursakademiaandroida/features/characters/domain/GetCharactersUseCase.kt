package com.atomczak.kursakademiaandroida.features.characters.domain

import com.atomczak.kursakademiaandroida.core.base.UseCase
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(
    private val characterRepository: CharacterRepository
) : UseCase<List<Character>, Unit>() {
    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}