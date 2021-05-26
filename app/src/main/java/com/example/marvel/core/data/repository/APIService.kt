package com.example.marvel.core.data.repository


import com.example.marvel.core.data.repository.model.DataWrapper
import com.example.marvel.features.home.data.response.CharacterApi
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


const val APIKEY = "apikey"
const val HASH = "hash"
const val TIMESTAMP = "ts"

interface APIService {
    @GET("characters")
    suspend fun getCharacters(
        @Query(APIKEY) apikey: String,
        @Query(HASH) hash: String,
        @Query(TIMESTAMP) ts: Long
    ): Response<DataWrapper<List<CharacterApi>>>
}