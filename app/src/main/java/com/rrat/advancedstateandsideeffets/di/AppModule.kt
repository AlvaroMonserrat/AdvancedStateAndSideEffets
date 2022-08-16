package com.rrat.advancedstateandsideeffets.di

import com.rrat.advancedstateandsideeffets.data.Repository
import com.rrat.advancedstateandsideeffets.data.RepositoryFake
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun repository():Repository{
        return RepositoryFake()
    }
}