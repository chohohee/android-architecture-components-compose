package com.chh.compose.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme by viewModel.isDarkThemeFlow.collectAsStateWithLifecycle(false)

            AACComposeTheme(darkTheme = isDarkTheme) {
                MainScreen(
                    onThemeUpdated = { viewModel.updateDarkTheme(it) }
                )
            }
        }
    }
}