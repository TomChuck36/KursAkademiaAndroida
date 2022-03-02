package com.atomczak.kursakademiaandroida.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atomczak.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.atomczak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.atomczak.kursakademiaandroida.features.locations.data.local.LocationDao
import com.atomczak.kursakademiaandroida.features.locations.data.local.model.LocationCached

@Database(
    entities = [
        EpisodeCached::class,
        LocationCached::class,
        CharacterCached::class
    ], version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
    abstract fun locationDao(): LocationDao
    abstract fun characterDao(): CharacterDao
}