package com.atomczak.kursakademiaandroida.features.episodes.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.atomczak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached

@Dao
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisodes(vararg episode: EpisodeCached)
}