package com.chh.compose.core.data.repository

import com.chh.compose.core.datastore.source.ThemePreferencesDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DefaultThemeRepository @Inject constructor(
    private val themePreferencesDataSource: ThemePreferencesDataSource,
) : ThemeRepository {

    override fun isDarkTheme(): Flow<Boolean> = themePreferencesDataSource.isDarkTheme

    override suspend fun updateDarkTheme(isDarkTheme: Boolean) {
        themePreferencesDataSource.updateDarkTheme(isDarkTheme)
    }
}
