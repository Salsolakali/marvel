package com.example.marvel.usecases

import app.cash.turbine.test
import com.example.marvel.core.data.repository.DataRepository
import com.example.marvel.core.domain.ResultOf
import com.example.marvel.features.home.domain.useCase.GetCharactersUseCase
import com.example.marvel.usecases.stubs.CharacterApiStub
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseTest {

    private lateinit var sut: GetCharactersUseCase

    @Mock
    lateinit var dataRespository: DataRepository

    @Before
    fun setup() {
        initInteractor()
    }

    private fun initInteractor() {
        sut = GetCharactersUseCase(dataRespository)
    }

    @Test
    @Throws(Exception::class)
    fun `request repository only once`() {
        sut.execute()
        verify(dataRespository, times(1)).get()
    }

    @Test
    fun `on execute return flow with result`() {
        val remoteObject = CharacterApiStub.testServiceData
        val flowResult = flowOf(ResultOf.Success(remoteObject))
        whenever(dataRespository.getCharacters()).thenReturn(flowResult)

        val result = sut.execute()
        assertEquals(flowResult, result)
    }

    @Test
    fun `on execute return flow with correct object`() {
        val remoteObject = CharacterApiStub.testServiceData
        val flowResult = flowOf(ResultOf.Success(remoteObject))
        whenever(dataRespository.getCharacters()).thenReturn(flowResult)

        runBlocking {
            sut.execute().test {
                assertEquals(ResultOf.Success(remoteObject), expectItem())
                expectComplete()
            }
        }
    }
}