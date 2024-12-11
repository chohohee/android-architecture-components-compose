package com.chh.compose.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object PokemonColorTokens {
    val normal = Normal
    val fire = Fire
    val water = Water
    val electric = Electric
    val grass = Grass
    val ice = Ice
    val fighting = Fighting
    val poison = Poison
    val ground = Ground
    val flying = Flying
    val psychic = Psychic
    val bug = Bug
    val rock = Rock
    val ghost = Ghost
    val dragon = Dragon
    val dark = Dark
    val steel = Steel
    val fairy = Fairy
    val etc = Etc
}

class PokemonColorScheme(
    val normal: Color,
    val fire: Color,
    val water: Color,
    val electric: Color,
    val grass: Color,
    val ice: Color,
    val fighting: Color,
    val poison: Color,
    val ground: Color,
    val flying: Color,
    val psychic: Color,
    val bug: Color,
    val rock: Color,
    val ghost: Color,
    val dragon: Color,
    val dark: Color,
    val steel: Color,
    val fairy: Color,
    val etc: Color,
)

fun pokemonColorScheme() =
    PokemonColorScheme(
        normal = PokemonColorTokens.normal,
        fire = PokemonColorTokens.fire,
        water = PokemonColorTokens.water,
        electric = PokemonColorTokens.electric,
        grass = PokemonColorTokens.grass,
        ice = PokemonColorTokens.ice,
        fighting = PokemonColorTokens.fighting,
        poison = PokemonColorTokens.poison,
        ground = PokemonColorTokens.ground,
        flying = PokemonColorTokens.flying,
        psychic = PokemonColorTokens.psychic,
        bug = PokemonColorTokens.bug,
        rock = PokemonColorTokens.rock,
        ghost = PokemonColorTokens.ghost,
        dragon = PokemonColorTokens.dragon,
        dark = PokemonColorTokens.dark,
        steel = PokemonColorTokens.steel,
        fairy = PokemonColorTokens.fairy,
        etc = PokemonColorTokens.etc
    )

object PokemonMaterialTheme {
    val colorScheme: PokemonColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalPokemonColorScheme.current
}