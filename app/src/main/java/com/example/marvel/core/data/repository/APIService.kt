package com.example.marvel.core.data.repository

import com.example.marvel.features.home.data.response.CharacterApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val HASH = "hash"
const val TIMESTAMP = "ts"

interface APIService {
    @GET("characters")
    suspend fun getCharacters(
        @Query(HASH) md5Digest: String,
        @Query(TIMESTAMP) timestamp: Long
    ): Response<List<CharacterApi>>
}