package com.atomczak.kursakademiaandroida.mock

import com.atomczak.kursakademiaandroida.core.api.model.EpisodeRemote
import com.atomczak.kursakademiaandroida.core.api.model.EpisodesResponse
import com.atomczak.kursakademiaandroida.core.api.model.ResponseInfo
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "next page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characterUrls = emptyList(),
    url = "episode url",
    created = "example date"
)

@TestOnly
fun EpisodesResponse.Companion.mock() = EpisodesResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characterUrls = emptyList(),
    url = "episode url"
)