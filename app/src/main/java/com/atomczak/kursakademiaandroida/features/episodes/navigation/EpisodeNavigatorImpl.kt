package com.atomczak.kursakademiaandroida.features.episodes.navigation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator

class EpisodeNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen() {
        fragmentNavigator.navigateTo(R.id.action_navigate_from_episodes_to_episode_details_screen)
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}