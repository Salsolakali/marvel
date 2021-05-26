package com.example.marvel.features.home.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.features.home.domain.model.Character
import com.example.marvel.features.home.domain.useCase.GetCharactersUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel
@Inject constructor(private val getCharactersUseCase: GetCharactersUseCase) : ViewModel() {

    private lateinit var jobGetCharacters: Job

    var charactersFetched: MutableLiveData<List<Character>> = MutableLiveData()

    fun fetchCharacters() {
        jobGetCharacters = viewModelScope.launch {
            //TODO execute use case & collect results
        }
    }
}