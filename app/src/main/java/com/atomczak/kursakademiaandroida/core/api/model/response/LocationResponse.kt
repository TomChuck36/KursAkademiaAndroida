package com.atomczak.kursakademiaandroida.core.api.model.response

import com.atomczak.kursakademiaandroida.core.api.model.remote.LocationRemote
import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<LocationRemote>
) {
    companion object
}