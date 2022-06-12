package com.atomczak.kursakademiaandroida.mock

import com.atomczak.kursakademiaandroida.core.api.model.remote.*
import com.atomczak.kursakademiaandroida.core.api.model.response.CharacterResponse
import com.atomczak.kursakademiaandroida.core.api.model.response.EpisodesResponse
import com.atomczak.kursakademiaandroida.core.api.model.response.LocationResponse
import com.atomczak.kursakademiaandroida.core.api.model.response.ResponseInfo
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterLastLocationCached
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterOriginLocationCached
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterLastLocation
import com.atomczak.kursakademiaandroida.features.characters.domain.model.CharacterOriginLocation
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.atomczak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.atomczak.kursakademiaandroida.features.locations.domain.model.Location
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

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characterUrls = emptyList(),
    url = "episode url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characterUrls = emptyList(),
    url = "episode url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    originLocation = CharacterOriginLocationRemote(name = "location name", url = "location url"),
    lastLocation = CharacterLastLocationRemote(name = "location name", url = "location url"),
    imageUrl = "image url",
    episodeUrls = emptyList(),
    url = "character url",
    created = "example date"
)

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    originLocation = CharacterOriginLocationCached(name = "location name", url = "location url"),
    lastLocation = CharacterLastLocationCached(name = "location name", url = "location url"),
    imageUrl = "image url",
    episodeUrls = emptyList(),
    url = "character url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    originLocation = CharacterOriginLocation(name = "location name", url = "location url"),
    lastLocation = CharacterLastLocation(name = "location name", url = "location url"),
    imageUrl = "image url",
    episodeUrls = emptyList(),
    url = "character url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residentUrls = emptyList(),
    url = "location url",
    created = "example date"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residentUrls = emptyList(),
    url = "location url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residentUrls = emptyList(),
    url = "location date",
)