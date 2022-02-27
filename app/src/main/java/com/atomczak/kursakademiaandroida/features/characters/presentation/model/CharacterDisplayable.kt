package com.atomczak.kursakademiaandroida.features.characters.presentation.model

import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterLastLocation
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterOriginLocation

data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: CharacterOriginLocationDisplayable,
    val lastLocation: CharacterLastLocationDisplayable,
    val imageUrl: String,
    val episodeUrls: List<String>,
    val url: String,
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        originLocation = CharacterOriginLocationDisplayable(character.originLocation),
        lastLocation = CharacterLastLocationDisplayable(character.lastLocation),
        imageUrl = character.imageUrl,
        episodeUrls = character.episodeUrls,
        url = character.url
    )
}

data class CharacterOriginLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(origin: CharacterOriginLocation) : this(
        name = origin.name,
        url = origin.url
    )
}

data class CharacterLastLocationDisplayable(
    val name: String,
    val url: String
) {
    constructor(location: CharacterLastLocation) : this(
        name = location.name,
        url = location.url
    )
}