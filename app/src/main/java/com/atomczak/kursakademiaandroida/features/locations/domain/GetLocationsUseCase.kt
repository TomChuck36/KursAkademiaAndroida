package com.atomczak.kursakademiaandroida.features.locations.domain

import android.location.Location
import com.atomczak.kursakademiaandroida.core.base.UseCase

class GetLocationsUseCase(
    private val locationRepository: LocationRepository
) : UseCase<List<Location>, Unit>() {
    override suspend fun action(params: Unit) = locationRepository.getLocations()
}