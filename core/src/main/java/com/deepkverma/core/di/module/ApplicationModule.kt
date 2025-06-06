package com.deepkverma.core.di.module

import android.app.Application
import com.deepkverma.core.data.api.NetworkService
import com.deepkverma.core.di.ApplicationContext
import com.deepkverma.core.di.BaseUrl
import com.deepkverma.core.utils.WelcomeOptions
import com.deepkverma.domain.repository.NewsRepository
import com.deepkverma.domain.usecase.GetTopHeadlinesUseCase
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: Application) {

    @ApplicationContext
    @Provides
    fun provideContext(): Application {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = WelcomeOptions.BASE_URL

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Singleton
    @Provides
    fun provideNetworkService(
        @BaseUrl baseUrl: String, gsonConverterFactory: GsonConverterFactory
    ): NetworkService {
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(gsonConverterFactory).build()
            .create(
                NetworkService::class.java
            )
    }

    @Provides
    fun provideGetTopHeadlinesUseCase(repository: NewsRepository): GetTopHeadlinesUseCase {
        return GetTopHeadlinesUseCase(repository)
    }
}