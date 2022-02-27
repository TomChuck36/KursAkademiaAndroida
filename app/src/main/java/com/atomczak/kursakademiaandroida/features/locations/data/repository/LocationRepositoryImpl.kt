package com.atomczak.kursakademiaandroida.features.locations.data.repository

import com.atomczak.kursakademiaandroida.core.api.RickAndMortyApi
import com.atomczak.kursakademiaandroida.core.network.NetworkStateProvider
import com.atomczak.kursakademiaandroida.features.locations.data.local.LocationDao
import com.atomczak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.atomczak.kursakademiaandroida.features.locations.domain.LocationRepository
import com.atomczak.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val locationsDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote().also {
                saveLocationsToLocal(it)
            }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return rickAndMortyApi.getLocations().results.map {
            it.toLocation()
        }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map {
            LocationCached(it)
        }.toTypedArray().let {
            locationsDao.saveLocations(*it)    // * służy do mapowania TypedArray na vararg
        }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationsDao.getLocations().map {
            it.toLocation()
        }
    }
}