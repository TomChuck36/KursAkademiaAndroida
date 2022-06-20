package com.atomczak.kursakademiaandroida.features.characters.all.presentation.model

import android.os.Parcelable
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterLastLocation
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterOriginLocation
import kotlinx.parcelize.Parcelize

@Parcelize
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
) : Parcelable {
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

    companion object
}

@Parcelize
data class CharacterOriginLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(origin: CharacterOriginLocation) : this(
        name = origin.name,
        url = origin.url
    )
}

@Parcelize
data class CharacterLastLocationDisplayable(
    val name: String,
    val url: String
) : Parcelable {
    constructor(location: CharacterLastLocation) : this(
        name = location.name,
        url = location.url
    )
}