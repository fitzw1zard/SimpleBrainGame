package com.example.simplebraingame.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.simplebraingame.R

import com.example.simplebraingame.databinding.FragmentGameFinishedBinding
import com.example.simplebraingame.domain.entity.GameResult


class GameFinishedFragment : Fragment() {

    private val args by navArgs<GameFinishedFragmentArgs>()

    private var _binding: FragmentGameFinishedBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException("FragmentGameFinishedBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonRetry.setOnClickListener { findNavController().popBackStack() }
            gameResult = args.gameResult
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
