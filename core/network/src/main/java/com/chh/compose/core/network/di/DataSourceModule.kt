package com.chh.compose.core.network.di

import com.chh.compose.core.network.source.DefaultPokemonNetworkDataSource
import com.chh.compose.core.network.source.PokemonNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindPokemonNetworkDataSource(
        network: DefaultPokemonNetworkDataSource
    ): PokemonNetworkDataSource

}
