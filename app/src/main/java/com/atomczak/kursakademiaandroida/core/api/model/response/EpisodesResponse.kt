package com.atomczak.kursakademiaandroida.core.api.model.response

import com.atomczak.kursakademiaandroida.core.api.model.remote.EpisodeRemote
import com.google.gson.annotations.SerializedName

data class EpisodesResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<EpisodeRemote>
) {
    companion object
}
