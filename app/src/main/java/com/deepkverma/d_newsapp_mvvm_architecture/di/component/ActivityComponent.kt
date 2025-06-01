package com.deepkverma.d_newsapp_mvvm_architecture.di.component

import com.deepkverma.d_newsapp_mvvm_architecture.MainActivity
import com.deepkverma.d_newsapp_mvvm_architecture.di.ActivityScope
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ActivityModule
import dagger.Component
import javax.inject.Singleton

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}