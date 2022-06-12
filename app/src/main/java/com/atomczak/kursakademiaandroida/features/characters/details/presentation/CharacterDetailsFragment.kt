package com.atomczak.kursakademiaandroida.features.characters.details.presentation

import android.os.Bundle
import android.view.View
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import com.atomczak.kursakademiaandroida.databinding.FragmentCharacterDetailsBinding
import com.atomczak.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_character_details) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding get() = _binding!!
    private var character: CharacterDisplayable? = null

    companion object {
        const val CHARACTER_DETAILS_KEY = "CHARACTER_DETAILS_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.apply {
            character = getParcelable(CHARACTER_DETAILS_KEY)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCharacterDetailsBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initViews() {
        super.initViews()
        initData(character)
    }

    private fun initData(character: CharacterDisplayable?) {
        character?.let {
            binding.tvName.text = it.name
            binding.tvAdditionalInfo.text = StringBuilder().apply {
                checkAndAppend(getString(R.string.character_details_status), it.status)
                checkAndAppend(getString(R.string.character_details_species), it.species)
                checkAndAppend(getString(R.string.character_details_type), it.type)
                checkAndAppend(getString(R.string.character_details_gender), it.gender)
                checkAndAppend(
                    getString(R.string.character_details_origin_location),
                    it.originLocation.name
                )
                checkAndAppend(
                    getString(R.string.character_details_last_location),
                    it.lastLocation.name
                )
            }
        }
    }

    private fun StringBuilder.checkAndAppend(title: String, info: String) {
        if (info.isNotBlank()) append(title).append(info).append("\n")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}