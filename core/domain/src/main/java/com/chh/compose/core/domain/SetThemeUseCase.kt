package com.chh.compose.core.domain

import com.chh.compose.core.data.repository.ThemeRepository
import javax.inject.Inject

class SetThemeUseCase @Inject constructor(
    private val themeRepository: ThemeRepository
) {

    suspend operator fun invoke(isDark: Boolean) {
        themeRepository.updateDarkTheme(isDark)
    }
}
