package com.atomczak.kursakademiaandroida.features.episodes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

@Entity
data class EpisodeCached(
    @PrimaryKey val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characterUrls: List<String>,
    val url: String
) {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characterUrls = episode.characterUrls,
        url = episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characterUrls = characterUrls,
        url = url
    )
}