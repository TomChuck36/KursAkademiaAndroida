package com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode

@Parcelize
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characterUrls: List<String>,
    val url: String
): Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characterUrls = episode.characterUrls,
        url = episode.url
    )

    companion object
}