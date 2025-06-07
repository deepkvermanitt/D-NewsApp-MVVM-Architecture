package com.deepkverma.search.di.component

import com.deepkverma.search.di.module.SearchModule
import dagger.Component

@Component(modules = [SearchModule::class])
interface SearchComponent {
}