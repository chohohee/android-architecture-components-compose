package com.chh.compose.core.designsystem.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.chh.compose.core.designsystem.theme.PokemonMaterialTheme

@Composable
fun getPokemonColor(type: String): Color {
    return when (type) {
        "normal" -> PokemonMaterialTheme.colorScheme.normal
        "fire" -> PokemonMaterialTheme.colorScheme.fire
        "water" -> PokemonMaterialTheme.colorScheme.water
        "electric" -> PokemonMaterialTheme.colorScheme.electric
        "grass" -> PokemonMaterialTheme.colorScheme.grass
        "ice" -> PokemonMaterialTheme.colorScheme.ice
        "fighting" -> PokemonMaterialTheme.colorScheme.fighting
        "poison" -> PokemonMaterialTheme.colorScheme.poison
        "ground" -> PokemonMaterialTheme.colorScheme.ground
        "flying" -> PokemonMaterialTheme.colorScheme.flying
        "psychic" -> PokemonMaterialTheme.colorScheme.psychic
        "bug" -> PokemonMaterialTheme.colorScheme.bug
        "rock" -> PokemonMaterialTheme.colorScheme.rock
        "ghost" -> PokemonMaterialTheme.colorScheme.ghost
        "dragon" -> PokemonMaterialTheme.colorScheme.dragon
        "dark" -> PokemonMaterialTheme.colorScheme.dark
        "steel" -> PokemonMaterialTheme.colorScheme.steel
        "fairy" -> PokemonMaterialTheme.colorScheme.fairy
        else -> PokemonMaterialTheme.colorScheme.etc
    }
}