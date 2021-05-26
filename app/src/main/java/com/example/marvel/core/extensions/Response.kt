package com.example.marvel.core.extensions

import com.example.marvel.core.data.repository.FailureFactory
import com.example.marvel.core.domain.ResultOf
import retrofit2.Response

fun <T, R> Response<T>.safeCall(
    transform: (T) -> R,
    errorFactory: FailureFactory = FailureFactory()
): ResultOf<R> {
    val body = body()
    return when {
        isSuccessful && body != null -> ResultOf.Success(transform(body))
        else -> errorFactory.handleCode(code = code(), errorBody = errorBody())
    }
}