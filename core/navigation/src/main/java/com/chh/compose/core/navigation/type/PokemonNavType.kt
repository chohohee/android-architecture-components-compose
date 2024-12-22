package com.chh.compose.core.navigation.type

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.chh.compose.core.model.Pokemon
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object PokemonNavType : NavType<Pokemon>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Pokemon? {
        return bundle.getString(key)?.let<String, Pokemon>(Json::decodeFromString)
    }

    override fun parseValue(value: String): Pokemon {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: Pokemon): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: Pokemon) {
        bundle.putString(key, Json.encodeToString(value))
    }
}
