package com.atomczak.kursakademiaandroida.core.api.model.response

import com.atomczak.kursakademiaandroida.core.api.model.remote.CharacterRemote
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}
