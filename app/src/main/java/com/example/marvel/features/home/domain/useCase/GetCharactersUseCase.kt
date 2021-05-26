package com.example.marvel.features.home.domain.useCase

import com.example.marvel.core.data.repository.DataRepository
import javax.inject.Inject

class GetCharactersUseCase
@Inject constructor(private val repository: DataRepository) {
    fun execute() = repository.getCharacters()
}