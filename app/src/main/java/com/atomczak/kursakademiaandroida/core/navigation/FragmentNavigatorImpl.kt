package com.atomczak.kursakademiaandroida.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.atomczak.kursakademiaandroida.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostFragmentRes)
        ?.findNavController()

    override fun navigateTo(destinationID: Int, bundle: Bundle?) {
        getNavController()?.navigate(destinationID, bundle)
    }

    override fun goBack(destinationID: Int?, inclusive: Boolean) {
        if (destinationID == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationID, inclusive)
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}