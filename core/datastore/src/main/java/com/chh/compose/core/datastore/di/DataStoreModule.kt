package com.chh.compose.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

val Context.themeDataStore: DataStore<Preferences> by preferencesDataStore(
    name = "com.chh.compose.theme_preferences"
)

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    @Named("theme")
    fun provideThemeDataStore(
        @ApplicationContext context: Context,
    ): DataStore<Preferences> = context.themeDataStore
}
