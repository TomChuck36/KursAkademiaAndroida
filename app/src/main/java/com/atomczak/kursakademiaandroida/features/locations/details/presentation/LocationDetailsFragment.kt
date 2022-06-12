package com.atomczak.kursakademiaandroida.features.locations.details.presentation

import android.os.Bundle
import android.view.View
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import com.atomczak.kursakademiaandroida.databinding.FragmentLocationDetailsBinding
import com.atomczak.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationDetailsFragment :
    BaseFragment<LocationDetailsViewModel>(R.layout.fragment_location_details) {

    override val viewModel: LocationDetailsViewModel by viewModel()

    private var _binding: FragmentLocationDetailsBinding? = null
    private val binding get() = _binding!!
    private var location: LocationDisplayable? = null

    companion object {
        const val LOCATION_DETAILS_KEY = "LOCATION_DETAILS_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            location = getParcelable(LOCATION_DETAILS_KEY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentLocationDetailsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        initData(location)
    }

    private fun initData(location: LocationDisplayable?) {
        location?.let {
            binding.tvName.text = it.name
            binding.tvType.text = String.format(
                getString(R.string.location_details_type_s), it.type
            )
            binding.tvDimension.text = String.format(
                getString(R.string.location_details_dimension_s), it.dimension
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}