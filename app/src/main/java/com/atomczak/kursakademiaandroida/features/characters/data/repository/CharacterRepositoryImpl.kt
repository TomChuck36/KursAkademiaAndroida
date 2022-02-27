package com.atomczak.kursakademiaandroida.features.characters.data.repository

import com.atomczak.kursakademiaandroida.core.api.RickAndMortyApi
import com.atomczak.kursakademiaandroida.core.network.NetworkStateProvider
import com.atomczak.kursakademiaandroida.features.characters.data.local.CharacterDao
import com.atomczak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.atomczak.kursakademiaandroida.features.characters.domain.CharacterRepository
import com.atomczak.kursakademiaandroida.features.characters.domain.model.Character

class CharacterRepositoryImpl(
    private val rickAndMortyApi: RickAndMortyApi,
    private val characterDao: CharacterDao,
    private val networkStateProvider: NetworkStateProvider
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getCharactersFromRemote().also {
                saveCharactersToLocal(it)
            }
        } else {
            getCharactersFromLocal()
        }
    }

    private suspend fun getCharactersFromRemote(): List<Character> {
        return rickAndMortyApi.getCharacters().results.map {
            it.toCharacter()
        }
    }

    private suspend fun saveCharactersToLocal(characters: List<Character>) {
        characters.map {
            CharacterCached(it)
        }.toTypedArray().let {
            characterDao.saveCharacters(*it)    // * służy do mapowania TypedArray na vararg
        }
    }

    private suspend fun getCharactersFromLocal(): List<Character> {
        return characterDao.getCharacters().map {
            it.toCharacter()
        }
    }
}