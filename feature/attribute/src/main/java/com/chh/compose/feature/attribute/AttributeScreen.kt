package com.chh.compose.feature.attribute

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chh.compose.core.designsystem.component.CircularProgress
import com.chh.compose.core.designsystem.component.ErrorView
import com.chh.compose.core.model.Type
import com.chh.compose.core.model.UiState
import com.chh.compose.feature.attribute.component.AttributeItem

@Composable
internal fun AttributeScreen(
    viewModel: AttributeViewModel = hiltViewModel()
) {
    val attributeUiState by viewModel.attributeUiState.collectAsStateWithLifecycle()

    when (val uiState = attributeUiState) {
        is UiState.Loading -> {
            CircularProgress()
        }

        is UiState.Success -> {
            AttributeList(uiState.data)
        }

        is UiState.Error -> {
            ErrorView(
                message = uiState.exception.message,
                modifier = Modifier.fillMaxSize(),
                refresh = viewModel.attributeUiState::restart
            )
        }
    }
}

@Composable
internal fun AttributeList(
    items: List<Type>
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 74.dp)
    ) {
        items(items.size) { index ->
            AttributeItem(items[index])
        }
    }
}