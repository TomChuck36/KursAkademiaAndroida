package com.atomczak.kursakademiaandroida.features.locations.all.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import com.atomczak.kursakademiaandroida.databinding.FragmentLocationBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    private val divider: DividerItemDecoration by inject()
    private val locationAdapter: LocationAdapter by inject()

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLocationBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    private fun initRecycler() {
        with(binding.recyclerView) {
            addItemDecoration(divider)
            setHasFixedSize(true)
            locationAdapter.onClickItem = viewModel::onLocationClick
            adapter = locationAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.isVisible = false
    }

    override fun onPendingState() {
        super.onPendingState()
        binding.progressBar.isVisible = true
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            locationAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}