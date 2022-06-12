package com.atomczak.kursakademiaandroida.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {

    fun navigateTo(
        @IdRes destinationID: Int,
        fragmentTransition: FragmentTransition? = null
    )

    fun <T> navigateTo(
        @IdRes destinationID: Int,
        param: Pair<String, T>? = null,
        fragmentTransition: FragmentTransition? = null
    )

    fun goBack(@IdRes destinationID: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}