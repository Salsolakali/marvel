package com.example.marvel.features.home.domain.model

import java.io.Serializable

data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val image: String
): Serializable {}