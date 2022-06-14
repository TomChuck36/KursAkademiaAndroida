package com.atomczak.kursakademiaandroida.core.di

import com.atomczak.kursakademiaandroida.features.characters.di.characterModule
import com.atomczak.kursakademiaandroida.features.episodes.di.episodeModule
import com.atomczak.kursakademiaandroida.features.locations.di.locationModule

val featureModules = listOf(episodeModule, locationModule, characterModule)