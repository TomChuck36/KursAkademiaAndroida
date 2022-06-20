package com.atomczak.kursakademiaandroida.features.episodes.details.presentation

import android.os.Bundle
import android.view.View
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import com.atomczak.kursakademiaandroida.databinding.FragmentEpisodeDetailsBinding
import com.atomczak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    private var _binding: FragmentEpisodeDetailsBinding? = null
    private val binding get() = _binding!!
    private var episode: EpisodeDisplayable? = null

    companion object {
        const val EPISODE_DETAILS_KEY = "EPISODE_DETAILS_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            episode = getParcelable(EPISODE_DETAILS_KEY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentEpisodeDetailsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        initData(episode)
    }

    private fun initData(episode: EpisodeDisplayable?) {
        episode?.let {
            binding.tvName.text = it.name
            binding.tvAirDate.text = it.airDate
            binding.tvCode.text = it.code
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}