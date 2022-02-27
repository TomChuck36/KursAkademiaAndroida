package com.atomczak.kursakademiaandroida.core.db

import androidx.room.TypeConverter
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterLastLocationCached
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CharacterLastLocationConverter {
    companion object {

        @TypeConverter
        @JvmStatic
        fun toJson(data: CharacterLastLocationCached): String {
            return Gson().toJson(data)
        }

        @TypeConverter
        @JvmStatic
        fun fromJson(json: String): CharacterLastLocationCached {
            return Gson().fromJson(
                json, object : TypeToken<CharacterLastLocationCached>() {}.type
            )
        }
    }
}