package com.chh.compose.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chh.compose.core.domain.GetThemeUseCase
import com.chh.compose.core.domain.SetThemeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getThemeUseCase: GetThemeUseCase,
    private val setThemeUseCase: SetThemeUseCase
) : ViewModel() {

    val isDarkThemeFlow: Flow<Boolean> = getThemeUseCase.invoke()

    fun updateDarkTheme(isDarkTheme: Boolean) {
        viewModelScope.launch {
            setThemeUseCase.invoke(isDarkTheme)
        }
    }
}