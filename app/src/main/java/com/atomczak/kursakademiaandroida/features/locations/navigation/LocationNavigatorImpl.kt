package com.atomczak.kursakademiaandroida.features.locations.navigation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.atomczak.kursakademiaandroida.features.locations.details.presentation.LocationDetailsFragment

class LocationNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : LocationNavigator {

    override fun openLocationDetailsScreen(location: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            destinationID = R.id.action_navigate_from_locations_to_location_details_screen,
            param = LocationDetailsFragment.LOCATION_DETAILS_KEY to location
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}