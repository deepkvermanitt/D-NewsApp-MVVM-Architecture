package com.deepkverma.search.di.component

import com.deepkverma.core.di.ActivityScope
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.search.di.module.SearchModule
import com.deepkverma.search.ui.SearchActivity
import dagger.Component

@ActivityScope
@Component(modules = [SearchModule::class], dependencies = [ApplicationComponent::class])
interface SearchComponent {
    fun inject(activity: SearchActivity)
}