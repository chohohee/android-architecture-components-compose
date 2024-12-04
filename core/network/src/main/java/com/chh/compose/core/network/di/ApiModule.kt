package com.chh.compose.core.network.di

import com.chh.compose.core.network.api.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(
        json: Json,
    ): Converter.Factory = json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun providePokemonApi(
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
    ): PokemonApi = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(converterFactory)
        .client(okHttpClient).build()
        .create(PokemonApi::class.java)

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}
