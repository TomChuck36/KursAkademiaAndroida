package com.atomczak.kursakademiaandroida.features.locations.domain

import android.location.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}