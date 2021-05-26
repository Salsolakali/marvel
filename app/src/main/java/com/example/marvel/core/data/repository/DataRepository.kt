package com.example.marvel.core.data.repository

import com.example.marvel.core.domain.ResultOf
import com.example.marvel.features.home.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface DataRepository {
    fun getCharacters(): Flow<ResultOf<List<Character>>>
}