package com.atomczak.kursakademiaandroida.features.locations.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.atomczak.kursakademiaandroida.features.locations.domain.model.Location

@Entity
data class LocationCached(
    @PrimaryKey val id: Int,
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

    companion object

    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residentUrls = residentUrls,
        url = url
    )
}