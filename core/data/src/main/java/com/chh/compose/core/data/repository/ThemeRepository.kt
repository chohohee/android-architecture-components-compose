package com.chh.compose.core.data.repository

import kotlinx.coroutines.flow.Flow

interface ThemeRepository {

    fun isDarkTheme(): Flow<Boolean>

    suspend fun updateDarkTheme(isDarkTheme: Boolean)

}
