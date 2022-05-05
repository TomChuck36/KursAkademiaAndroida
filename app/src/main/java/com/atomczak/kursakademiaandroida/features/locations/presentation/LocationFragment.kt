package com.atomczak.kursakademiaandroida.features.locations.presentation

import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            //code to show locations
        }
    }
}