package com.deepkverma.d_newsapp_mvvm_architecture.di.component

import com.deepkverma.d_newsapp_mvvm_architecture.ui.topheadline.TopHeadlineActivity
import com.deepkverma.core.di.ActivityScope
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ActivityModule
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)
}