package com.atomczak.kursakademiaandroida.core.api

import com.atomczak.kursakademiaandroida.core.api.model.response.CharacterResponse
import com.atomczak.kursakademiaandroida.core.api.model.response.EpisodesResponse
import com.atomczak.kursakademiaandroida.core.api.model.response.LocationResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse

    @GET("character")
    suspend fun getCharacters(): CharacterResponse

    @GET("location")
    suspend fun getLocations(): LocationResponse
}