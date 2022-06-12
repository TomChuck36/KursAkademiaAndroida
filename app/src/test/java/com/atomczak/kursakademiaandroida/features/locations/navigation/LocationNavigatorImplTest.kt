package com.atomczak.kursakademiaandroida.features.locations.navigation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import com.atomczak.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationNavigatorImplTest {

    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke navigateTo method of FragmentNavigator with appropriate action and location model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //than
        verify {
            fragmentNavigator.navigateTo(
                destinationID = R.id.action_navigate_from_locations_to_location_details_screen,
                param = capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN goBack is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        locationNavigator.goBack()

        //than
        verify {
            fragmentNavigator.goBack()
        }
    }
}