package com.deepkverma.core.di.component

import android.app.Application
import com.deepkverma.core.data.repository.TopHeadlineRepository
import com.deepkverma.core.di.module.ApplicationModule
import com.deepkverma.core.di.module.RepositoryModule
import com.deepkverma.domain.repository.NewsRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun getRepository(): NewsRepository


}