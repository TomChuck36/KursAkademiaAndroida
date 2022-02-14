package com.atomczak.kursakademiaandroida.features.locations

import android.location.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}