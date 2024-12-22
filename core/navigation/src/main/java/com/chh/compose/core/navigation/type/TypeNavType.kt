package com.chh.compose.core.navigation.type

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.chh.compose.core.model.Type
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object TypeNavType : NavType<Type>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Type? {
        return bundle.getString(key)?.let<String, Type>(Json::decodeFromString)
    }

    override fun parseValue(value: String): Type {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun serializeAsValue(value: Type): String {
        return Uri.encode(Json.encodeToString(value))
    }

    override fun put(bundle: Bundle, key: String, value: Type) {
        bundle.putString(key, Json.encodeToString(value))
    }
}
