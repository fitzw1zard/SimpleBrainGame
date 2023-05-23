package com.example.simplebraingame.domain.repository

import com.example.simplebraingame.domain.entity.GameSettings
import com.example.simplebraingame.domain.entity.Level
import com.example.simplebraingame.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue: Int,
        countOfOptions: Int,
    ): Question

    fun getGameSettings(level: Level): GameSettings
}