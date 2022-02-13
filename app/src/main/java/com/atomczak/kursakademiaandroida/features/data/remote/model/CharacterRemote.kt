package com.atomczak.kursakademiaandroida.features.data.remote.model

import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName


data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val originLocation: OriginLocation,
    @SerializedName("location") val lastLocation: LastLocation,
    @SerializedName("image") val imageUrl: String,
    @SerializedName("episode") val episodeUrls: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    data class OriginLocation(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toOriginLocation() = Character.OriginLocation(
            name = name,
            url = url
        )
    }

    data class LastLocation(
        @SerializedName("name") val name: String,
        @SerializedName("url") val url: String
    ) {
        fun toLastLocation() = Character.LastLocation(
            name = name,
            url = url
        )
    }

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