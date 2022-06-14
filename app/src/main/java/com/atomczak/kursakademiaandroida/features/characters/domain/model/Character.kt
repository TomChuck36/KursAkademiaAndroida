package com.atomczak.kursakademiaandroida.features.characters.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originLocation: CharacterOriginLocation,
    val lastLocation: CharacterLastLocation,
    val imageUrl: String,
    val episodeUrls: List<String>,
    val url: String,
) {
    companion object
}

data class CharacterOriginLocation(
    val name: String,
    val url: String
)

data class CharacterLastLocation(
    val name: String,
    val url: String
)