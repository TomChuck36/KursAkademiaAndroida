package com.atomczak.kursakademiaandroida.core.api

import com.atomczak.kursakademiaandroida.core.api.model.EpisodesResponse
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("episode")
    suspend fun getEpisodes(): EpisodesResponse
}