package com.atomczak.kursakademiaandroida.core.api.model

import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.google.gson.annotations.SerializedName

data class EpisodeRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("air_date") val airDate: String,
    @SerializedName("episode") val code: String,
    @SerializedName("characters") val characterUrls: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characterUrls = characterUrls,
        url = url
    )
}