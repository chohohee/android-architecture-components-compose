package com.chh.compose.core.designsystem.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.chh.compose.core.designsystem.R

@Composable
fun getPokemonPainter(type: String): Painter {
    return when (type) {
        "normal" -> painterResource(id = R.drawable.ic_type_normal)
        "fire" -> painterResource(id = R.drawable.ic_type_fire)
        "water" -> painterResource(id = R.drawable.ic_type_water)
        "electric" -> painterResource(id = R.drawable.ic_type_electric)
        "grass" -> painterResource(id = R.drawable.ic_type_grass)
        "ice" -> painterResource(id = R.drawable.ic_type_ice)
        "fighting" -> painterResource(id = R.drawable.ic_type_fighting)
        "poison" -> painterResource(id = R.drawable.ic_type_poison)
        "ground" -> painterResource(id = R.drawable.ic_type_ground)
        "flying" -> painterResource(id = R.drawable.ic_type_flying)
        "psychic" -> painterResource(id = R.drawable.ic_type_psychic)
        "bug" -> painterResource(id = R.drawable.ic_type_bug)
        "rock" -> painterResource(id = R.drawable.ic_type_rock)
        "ghost" -> painterResource(id = R.drawable.ic_type_ghost)
        "dragon" -> painterResource(id = R.drawable.ic_type_dragon)
        "dark" -> painterResource(id = R.drawable.ic_type_dark)
        "steel" -> painterResource(id = R.drawable.ic_type_steel)
        "fairy" -> painterResource(id = R.drawable.ic_type_fairy)
        else -> painterResource(id = R.drawable.ic_type_normal)
    }
}