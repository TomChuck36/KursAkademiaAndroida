package com.atomczak.kursakademiaandroida.features.locations.navigation

import com.atomczak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {
    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}