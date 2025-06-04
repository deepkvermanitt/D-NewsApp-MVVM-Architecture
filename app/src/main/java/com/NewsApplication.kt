package com

import android.app.Application
import com.deepkverma.core.di.component.ApplicationComponent
import com.deepkverma.core.di.component.DaggerApplicationComponent
import com.deepkverma.core.di.module.ApplicationModule
import com.deepkverma.core.utils.AppGraph

class NewsApplication : Application(), AppGraph {

    override val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {

        applicationComponent.inject(this)
    }
}