package com.deepkverma.search.di.module

import androidx.activity.ComponentActivity
import com.deepkverma.core.di.ActivityContext
import com.deepkverma.search.ui.SearchActivity
import dagger.Module
import dagger.Provides

@Module
class SearchModule(val context: SearchActivity) {

    @ActivityContext
    @Provides
    fun provideActivityContext() = context
}