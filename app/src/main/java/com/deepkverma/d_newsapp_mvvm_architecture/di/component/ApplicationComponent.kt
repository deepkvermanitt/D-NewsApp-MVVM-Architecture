package com.deepkverma.d_newsapp_mvvm_architecture.di.component

import com.NewsApplication
import com.deepkverma.d_newsapp_mvvm_architecture.data.repository.TopHeadlineRepository
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: NewsApplication)
    fun getRepository(): TopHeadlineRepository


}