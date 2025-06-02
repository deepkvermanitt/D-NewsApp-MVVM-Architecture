package com.deepkverma.d_newsapp_mvvm_architecture.di.module

import android.app.Application
import com.NewsApplication
import com.deepkverma.core.data.api.NetworkService
import com.deepkverma.core.utils.WelcomeOptions.BASE_URL
import com.deepkverma.d_newsapp_mvvm_architecture.di.ApplicationContext
import com.deepkverma.d_newsapp_mvvm_architecture.di.BaseUrl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: NewsApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): NewsApplication {
        return application
    }

    @BaseUrl
    @Provides
    fun provideBaseUrl(): String = BASE_URL

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

}