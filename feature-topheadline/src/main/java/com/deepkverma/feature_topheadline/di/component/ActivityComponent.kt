package com.deepkverma.feature_topheadline.di.component

import com.deepkverma.core.di.ActivityScope
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.feature_topheadline.di.module.ActivityModule
import com.deepkverma.feature_topheadline.ui.screens.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(modules = [ActivityModule::class], dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)
}