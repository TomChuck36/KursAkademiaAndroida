package com.atomczak.kursakademiaandroida.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

interface FragmentNavigator {
    fun navigateTo(@IdRes destinationID: Int, bundle: Bundle? = null)
    fun goBack(@IdRes destinationID: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}