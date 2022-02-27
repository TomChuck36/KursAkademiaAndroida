package com.atomczak.kursakademiaandroida.core.api.model.remote

import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterLastLocation
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterOriginLocation
import com.google.gson.annotations.SerializedName

data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val originLocation: CharacterOriginLocationRemote,
    @SerializedName("location") val lastLocation: CharacterLastLocationRemote,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("episode") val episodeUrls: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
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

data class CharacterOriginLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toOriginLocation() = CharacterOriginLocation(
        name = name,
        url = url
    )
}

data class CharacterLastLocationRemote(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) {
    fun toLastLocation() = CharacterLastLocation(
        name = name,
        url = url
    )
}