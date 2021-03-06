package com.atomczak.kursakademiaandroida.core.navigation

import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.atomczak.kursakademiaandroida.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int,
    private val defaultNavOptions: NavOptions
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostFragmentRes)
        ?.findNavController()

    override fun navigateTo(destinationID: Int, fragmentTransition: FragmentTransition?) {
        navigateTo<Unit>(destinationID, null, fragmentTransition)
    }

    override fun <T> navigateTo(
        destinationID: Int,
        param: Pair<String, T>?,
        fragmentTransition: FragmentTransition?
    ) {
        val bundle = param?.let { bundleOf(it) }
        val navOptions = fragmentTransition?.let {
            navOptions {
                anim { enter = it.enterAnim }
                anim { exit = it.exitAnim }
                anim { popEnter = it.popEnterAnim }
                anim { popExit = it.popExitAnim }
            }
        } ?: defaultNavOptions

        getNavController()?.navigate(destinationID, bundle, navOptions)
    }

    override fun goBack(destinationID: Int?, inclusive: Boolean) {
        if (destinationID == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationID, inclusive)
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}