package com.deepkverma.core.di.module

import com.deepkverma.core.data.repository.NetworkRepository
import com.deepkverma.domain.repository.NewsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsRepository(
        impl: NetworkRepository
    ): NewsRepository
}