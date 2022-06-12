package com.atomczak.kursakademiaandroida.features.episodes.navigation

import androidx.core.os.bundleOf
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.navigation.FragmentNavigator
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.atomczak.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment

class EpisodeNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            destinationID = R.id.action_navigate_from_episodes_to_episode_details_screen,
            bundle = bundleOf(EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode)
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}