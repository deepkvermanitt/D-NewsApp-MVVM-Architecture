package com

import android.app.Application
import com.deepkverma.d_newsapp_mvvm_architecture.di.component.ApplicationComponent
import com.deepkverma.d_newsapp_mvvm_architecture.di.component.DaggerApplicationComponent
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ApplicationModule

class NewsApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()
        applicationComponent.inject(this)
    }
}