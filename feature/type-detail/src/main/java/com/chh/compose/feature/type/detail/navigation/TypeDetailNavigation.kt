package com.chh.compose.feature.type.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.chh.compose.core.model.Type
import com.chh.compose.core.navigation.Route
import com.chh.compose.core.navigation.type.TypeNavType
import com.chh.compose.feature.type.detail.TypeDetailScreen
import kotlin.reflect.typeOf

fun NavController.navigateTypeDetail(type: Type) {
    navigate(Route.TypeDetail(type))
}

fun NavGraphBuilder.typeDetailNavGraph(onUpClick: () -> Unit) {
    composable<Route.TypeDetail>(
        typeMap = mapOf(typeOf<Type>() to TypeNavType)
    ) {
        TypeDetailScreen(
            onUpClick = onUpClick
        )
    }
}
