package com.example.marvel.core.domain

open class ResultOf<out T> {
    data class Success<out R>(val value: R) : ResultOf<R>()
    data class Failure(val requestFailure: RequestFailure) : ResultOf<Nothing>()
    object InProgress : ResultOf<Nothing>()
}