package com.atomczak.kursakademiaandroida.features.characters.domain.model

data class Character(
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
    )

    data class LastLocation(
        val name: String,
        val url: String
    )
}