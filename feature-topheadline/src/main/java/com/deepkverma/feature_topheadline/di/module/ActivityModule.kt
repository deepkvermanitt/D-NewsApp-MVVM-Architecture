package com.deepkverma.feature_topheadline.di.module

import androidx.activity.ComponentActivity
import com.deepkverma.core.di.ActivityContext
import com.deepkverma.feature_topheadline.ui.TopHeadlineActivity
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