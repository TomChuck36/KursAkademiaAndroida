package com.atomczak.kursakademiaandroida.features.locations.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.atomczak.kursakademiaandroida.features.locations.data.local.model.LocationCached

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocations(vararg location: LocationCached)

    @Query("SELECT * FROM LocationCached")
    suspend fun getLocations(): List<LocationCached>
}