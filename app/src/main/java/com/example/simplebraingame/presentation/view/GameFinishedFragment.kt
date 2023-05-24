package com.example.simplebraingame.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.simplebraingame.R

import com.example.simplebraingame.databinding.FragmentGameFinishedBinding
import com.example.simplebraingame.domain.entity.GameResult


class GameFinishedFragment : Fragment() {

    private var _binding: FragmentGameFinishedBinding? = null
    private lateinit var gameResult: GameResult
    private val binding
        get() = _binding ?: throw IllegalStateException("FragmentGameFinishedBinding is null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameFinishedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        bindView()

    }

    private fun bindView() {

        with(binding) {
            emojiResult.setImageResource(getSmileResId())
            with(gameResult) {
                tvRequiredAnswers.text = String.format(
                    getString(R.string.required_score),
                    gameSettings.minCountOfRightAnswers.toString()
                )
                tvScoreAnswers.text = String.format(
                    getString(R.string.score_answers),
                    countOfRightAnswers.toString()
                )
                tvRequiredPercentage.text = String.format(
                    getString(R.string.required_percentage),
                    gameSettings.minPercentOfRightAnswers.toString()
                )
                tvScorePercentage.text = String.format(
                    getString(R.string.score_percentage),
                    percentOfRightAnswers.toString()
                )

            }
        }

    }

    private fun getSmileResId(): Int {
        return if (gameResult.winner) {
            R.drawable.ic_smile
        } else {
            R.drawable.ic_sad
        }
    }

    private fun setClickListeners() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    retryGame()
                }
            },
        )
        binding.buttonRetry.setOnClickListener { retryGame() }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun retryGame() {
        requireActivity().supportFragmentManager.popBackStack(
            GameFragment.NAME,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
    }

    private fun parseArgs() {
        @Suppress("DEPRECATION")
        requireArguments().getParcelable<GameResult>(KEY_GAME_RESULT)?.let { gameResult = it }
    }

    companion object {

        private const val KEY_GAME_RESULT = "gameResult"


        fun newInstance(gameResult: GameResult): GameFinishedFragment {
            return GameFinishedFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_GAME_RESULT, gameResult)
                }
            }
        }
    }
}
