package com.chh.compose.feature.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.chh.compose.feature.main.component.MainBottomBar
import com.chh.compose.feature.main.component.MainNaviHost

@Composable
internal fun MainScreen(
    modifier: Modifier = Modifier,
    navigator: MainNavigator = rememberMainNavigator()
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            MainBottomBar(
                visible = navigator.shouldShowBottomBar(),
                tabs = navigator.mainTabs,
                currentTab = navigator.currentTab,
                navigateToRoute = navigator::navigate
            )
        },
        content = { padding ->
            MainNaviHost(
                navigator = navigator,
                padding = padding,
                modifier = modifier
            )
        }
    )
}