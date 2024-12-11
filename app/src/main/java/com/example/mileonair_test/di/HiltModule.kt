package com.example.mileonair_test.di

import com.example.mileonair_test.data.impl.RegistrationRepositoryImpl
import com.example.mileonair_test.domain.api.RegistrationRepository
import dagger.Component
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
    fun provideRegistrationRepository(): RegistrationRepository {
        return RegistrationRepositoryImpl()
    }
}
