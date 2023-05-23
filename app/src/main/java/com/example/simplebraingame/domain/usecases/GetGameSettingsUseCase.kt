package com.example.simplebraingame.domain.usecases

import com.example.simplebraingame.domain.entity.GameSettings
import com.example.simplebraingame.domain.entity.Level
import com.example.simplebraingame.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }
}