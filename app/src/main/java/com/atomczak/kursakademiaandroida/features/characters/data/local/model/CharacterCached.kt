package com.atomczak.kursakademiaandroida.features.characters.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.atomczak.kursakademiaandroida.core.db.CharacterLastLocationConverter
import com.atomczak.kursakademiaandroida.core.db.CharacterOriginLocationConverter
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterLastLocation
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterOriginLocation

@Entity
@TypeConverters(
    CharacterLastLocationConverter::class,
    CharacterOriginLocationConverter::class
)
data class CharacterCached(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: CharacterOriginLocationCached,
    val lastLocation: CharacterLastLocationCached,
    val imageUrl: String,
    val episodeUrls: List<String>,
    val url: String
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        originLocation = CharacterOriginLocationCached(character.originLocation),
        lastLocation = CharacterLastLocationCached(character.lastLocation),
        imageUrl = character.imageUrl,
        episodeUrls = character.episodeUrls,
        url = character.url
    )

    companion object

    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        originLocation = originLocation.toOriginLocation(),
        lastLocation = lastLocation.toLastLocation(),
        imageUrl = imageUrl,
        episodeUrls = episodeUrls,
        url = url
    )
}

data class CharacterOriginLocationCached(
    val name: String,
    val url: String
) {
    constructor(location: CharacterOriginLocation) : this(
        name = location.name,
        url = location.url
    )

    fun toOriginLocation() = CharacterOriginLocation(
        name = name,
        url = url
    )
}

data class CharacterLastLocationCached(
    val name: String,
    val url: String
) {
    constructor(location: CharacterLastLocation) : this(
        name = location.name,
        url = location.url
    )

    fun toLastLocation() = CharacterLastLocation(
        name = name,
        url = url
    )
}