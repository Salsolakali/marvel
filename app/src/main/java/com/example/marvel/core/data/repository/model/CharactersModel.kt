package com.example.marvel.core.data.repository.model

import com.example.marvel.features.home.domain.model.Character

data class CharacterApi(
    val id: Int,
    val name: String,
    val description: String?,
    val thumbnail: Image,
    val resourceURI: String?
) {
    fun toDomain(): Character {
        return Character(
            id = id,
            name = name,
            description = description ?: "No description available",
            image = "${thumbnail.path}.${thumbnail.extension}"
        )
    }
}

data class DataContainer<out T>(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<CharacterApi>
)

data class DataWrapper<out T>(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: DataContainer<T>
)

data class Image(
    val path: String,
    val extension: String
)


