package com.deepkverma.d_newsapp_mvvm_architecture.di.module

import androidx.activity.ComponentActivity
import androidx.core.app.AppComponentFactory
import com.deepkverma.d_newsapp_mvvm_architecture.MainActivity
import com.deepkverma.d_newsapp_mvvm_architecture.di.ActivityContext
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val context: MainActivity) {

    @ActivityContext
    @Provides
    fun provideActivityContext(): ComponentActivity {
        return context
    }
}