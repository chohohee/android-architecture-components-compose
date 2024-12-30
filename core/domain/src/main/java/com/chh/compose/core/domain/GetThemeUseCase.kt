package com.chh.compose.core.domain

import com.chh.compose.core.data.repository.ThemeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetThemeUseCase @Inject constructor(
    private val themeRepository: ThemeRepository
) {

    operator fun invoke(): Flow<Boolean> = themeRepository.isDarkTheme()

}
