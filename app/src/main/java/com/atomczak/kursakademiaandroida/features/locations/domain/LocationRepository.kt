package com.atomczak.kursakademiaandroida.features.locations.domain

import com.atomczak.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}