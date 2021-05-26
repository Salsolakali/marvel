package com.example.marvel.features.home.data

import com.example.marvel.BuildConfig
import com.example.marvel.core.data.repository.APIService
import com.example.marvel.core.data.repository.DataRepository
import com.example.marvel.core.data.repository.FailureFactory
import com.example.marvel.core.data.repository.model.CharacterApi
import com.example.marvel.core.domain.ResultOf
import com.example.marvel.core.extensions.safeCall
import com.example.marvel.core.hashGenerator.HashGenerator
import com.example.marvel.features.home.domain.model.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class DataRepositoryImpl(
    private val apiService: APIService,
    private val hashGenerator: HashGenerator
) : DataRepository {
    override fun getCharacters(): Flow<ResultOf<List<Character>>> = flow {
        val timestamp = System.currentTimeMillis()
        val hash = "$timestamp${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}"
        emit(
            apiService.getCharacters(
                apikey = BuildConfig.PUBLIC_KEY,
                hash = hashGenerator.buildMD5Digest(hash),
                ts = timestamp

            ).safeCall({
                    response -> response.data.results.map { it.toDomain() }
            })
        )
    }.catch {
        emit(FailureFactory().handleException(it))
    }

}