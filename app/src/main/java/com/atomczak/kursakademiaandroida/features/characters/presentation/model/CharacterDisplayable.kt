package com.atomczak.kursakademiaandroida.features.characters.presentation.model

import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character

data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: OriginLocation,
    val lastLocation: LastLocation,
    val imageUrl: String,
    val episodeUrls: List<String>,
    val url: String,
) {
    data class OriginLocation(
        val name: String,
        val url: String
    ) {
        constructor(origin: Character.OriginLocation) : this(
            name = origin.name,
            url = origin.url
        )
    }

    data class LastLocation(
        val name: String,
        val url: String
    ) {
        constructor(location: Character.LastLocation) : this(
            name = location.name,
            url = location.url
        )
    }

    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        originLocation = OriginLocation(character.originLocation),
        lastLocation = LastLocation(character.lastLocation),
        imageUrl = character.imageUrl,
        episodeUrls = character.episodeUrls,
        url = character.url
    )
}