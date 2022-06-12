package com.atomczak.kursakademiaandroida.features.characters.all.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DividerItemDecoration
import com.atomczak.kursakademiaandroida.R
import com.atomczak.kursakademiaandroida.core.base.BaseFragment
import com.atomczak.kursakademiaandroida.databinding.FragmentCharacterBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    private val divider: DividerItemDecoration by inject()
    private val characterAdapter: CharacterAdapter by inject()

    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentCharacterBinding.bind(view)
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
            characterAdapter.onClickItem = viewModel::onCharacterClick
            adapter = characterAdapter
        }
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        binding.progressBar.isVisible = false
    }

    override fun onPendingState() {
        super.onPendingState()
        binding.progressBar.isVisible = true
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            characterAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}