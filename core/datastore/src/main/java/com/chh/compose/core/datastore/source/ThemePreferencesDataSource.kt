package com.chh.compose.core.datastore.source

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import javax.inject.Inject
import javax.inject.Named
import kotlinx.coroutines.flow.map

class ThemePreferencesDataSource @Inject constructor(
    @Named("theme") private val dataStore: DataStore<Preferences>,
) {

    val isDarkTheme = dataStore.data.map { it[IS_DARK_THEME] ?: false }

    suspend fun updateDarkTheme(isDarkTheme: Boolean) {
        dataStore.edit { it[IS_DARK_THEME] = isDarkTheme }
    }

    companion object {
        val IS_DARK_THEME = booleanPreferencesKey("IS_DARK_THEME")
    }

}
