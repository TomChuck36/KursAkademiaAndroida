package com.atomczak.kursakademiaandroida.core.db

import androidx.room.TypeConverter
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterOriginLocationCached
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CharacterOriginLocationConverter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: CharacterOriginLocationCached): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): CharacterOriginLocationCached {
            return Gson().fromJson(
                json, object : TypeToken<CharacterOriginLocationCached>() {}.type
            )
        }
    }
}