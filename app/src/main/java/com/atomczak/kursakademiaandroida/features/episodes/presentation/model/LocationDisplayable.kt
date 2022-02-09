package com.atomczak.kursakademiaandroida.features.episodes.presentation.model

import com.atomczak.kursakademiaandroida.features.episodes.domain.model.Location

data class LocationDisplayable(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residentUrls: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        id = location.id,
        name = location.name,
        type = location.type,
        dimension = location.dimension,
        residentUrls = location.residentUrls,
        url = location.url
    )
}