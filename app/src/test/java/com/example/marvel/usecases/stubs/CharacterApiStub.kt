package com.example.marvel.usecases.stubs

import com.example.marvel.features.home.domain.model.Character

object CharacterApiStub {
    val testServiceData: List<Character>
        get() = listOf(getCharacter())

    fun getCharacter(): Character {
        return Character(
            1,
            "3-D Man",
            "Sample description",
            "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg")
    }
}