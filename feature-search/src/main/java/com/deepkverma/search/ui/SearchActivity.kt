package com.deepkverma.search.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.deepkverma.core.utils.AppGraph
import com.deepkverma.core.viewmodel.ViewModelProviderFactory
import com.deepkverma.domain.usecase.GetSearchNewsUseCase
import com.deepkverma.search.di.component.DaggerSearchComponent
import com.deepkverma.search.di.module.SearchModule
import com.deepkverma.search.viewmodel.SearchViewModel
import javax.inject.Inject

class SearchActivity : ComponentActivity() {
    companion object {
        fun launchSearch(context: Context) {
            val intent = Intent(context, SearchActivity::class.java)

            context.startActivity(intent)
        }
    }

    lateinit var searchViewModel: SearchViewModel

    @Inject
    lateinit var searchUseCase: GetSearchNewsUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appGraph by lazy { application as AppGraph }
        val searchApplicationComponent =
            DaggerSearchComponent.builder().applicationComponent(appGraph.applicationComponent)
                .searchModule(
                    SearchModule(this)
                ).build()
        searchApplicationComponent.inject(this)
        val viewModelFactory = ViewModelProviderFactory(SearchViewModel::class) {
            SearchViewModel(searchUseCase)
        }
        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class]
    }
}