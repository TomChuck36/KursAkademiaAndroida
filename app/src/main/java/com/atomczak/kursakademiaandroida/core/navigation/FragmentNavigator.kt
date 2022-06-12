package com.atomczak.kursakademiaandroida.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {
    fun navigateTo(@IdRes destinationID: Int)
    fun goBack(@IdRes destinationID: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}