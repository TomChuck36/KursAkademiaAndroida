package com.atomczak.kursakademiaandroida.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atomczak.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
}