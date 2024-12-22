package com.chh.compose.feature.main.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.chh.compose.core.designsystem.theme.AACComposeTheme
import com.chh.compose.feature.main.MainTab

@Composable
internal fun MainBottomBar(
    visible: Boolean,
    tabs: Array<MainTab>,
    currentTab: MainTab?,
    modifier: Modifier = Modifier,
    navigateToRoute: (MainTab) -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) }
    ) {
        NavigationBar(
            modifier = modifier.height(70.dp)
        ) {
            tabs.forEach { tab ->
                val selected = tab == currentTab
                NavigationBarItem(
                    selected = selected,
                    onClick = { navigateToRoute(tab) },
                    icon = {
                        Icon(
                            imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                            contentDescription = tab.title
                        )
                    },
                    label = {
                        Text(tab.title)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    AACComposeTheme {
        MainBottomBar(
            true,
            tabs = MainTab.entries.toTypedArray(),
            currentTab = MainTab.POKEMON,
            navigateToRoute = {}
        )
    }
}
