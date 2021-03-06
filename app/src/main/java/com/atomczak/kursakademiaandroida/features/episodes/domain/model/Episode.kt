package com.atomczak.kursakademiaandroida.features.episodes.domain.model

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characterUrls: List<String>,
    val url: String
) {
    companion object
}