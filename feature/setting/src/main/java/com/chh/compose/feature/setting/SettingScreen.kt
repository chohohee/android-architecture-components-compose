package com.chh.compose.feature.setting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chh.compose.core.designsystem.theme.LocalDarkTheme
import com.chh.compose.feature.setting.component.ThemeSwitch

@Composable
internal fun SettingScreen(
    onThemeUpdated: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    SettingContent(
        onThemeUpdated = onThemeUpdated,
        modifier = modifier
    )
}

@Composable
fun SettingContent(
    onThemeUpdated: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = LocalDarkTheme.current
) {
    Box(modifier = Modifier.fillMaxSize()) {
        ThemeSwitch(
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,
            modifier = modifier
        )
    }
}