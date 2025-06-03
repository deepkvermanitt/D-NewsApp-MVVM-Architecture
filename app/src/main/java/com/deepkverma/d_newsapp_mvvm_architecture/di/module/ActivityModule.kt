package com.deepkverma.d_newsapp_mvvm_architecture.di.module

import androidx.activity.ComponentActivity
import com.deepkverma.d_newsapp_mvvm_architecture.ui.topheadline.TopHeadlineActivity
import com.deepkverma.core.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val context: TopHeadlineActivity) {

    @ActivityContext
    @Provides
    fun provideActivityContext(): ComponentActivity {
        return context
    }
}