package com.example.marvel.core.di

import com.example.marvel.core.data.repository.APIService
import com.example.marvel.core.data.repository.DataRepository
import com.example.marvel.core.hashGenerator.HashGenerator
import com.example.marvel.features.home.data.DataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesRepository(apiService: APIService, hashGenerator: HashGenerator): DataRepository {
        return DataRepositoryImpl(apiService, hashGenerator)
    }
}