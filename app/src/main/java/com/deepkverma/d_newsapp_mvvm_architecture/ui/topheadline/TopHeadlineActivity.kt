package com.deepkverma.d_newsapp_mvvm_architecture.ui.topheadline

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.NewsApplication
import com.deepkverma.d_newsapp_mvvm_architecture.data.repository.TopHeadlineRepository
import com.deepkverma.d_newsapp_mvvm_architecture.di.component.DaggerActivityComponent
import com.deepkverma.d_newsapp_mvvm_architecture.di.component.DaggerApplicationComponent
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ActivityModule
import com.deepkverma.d_newsapp_mvvm_architecture.di.module.ApplicationModule
import com.deepkverma.d_newsapp_mvvm_architecture.ui.UiState
import com.deepkverma.d_newsapp_mvvm_architecture.ui.ViewModelProviderFactory
import com.deepkverma.d_newsapp_mvvm_architecture.ui.theme.DNewsAppMVVMArchitectureTheme
import javax.inject.Inject

class TopHeadlineActivity : ComponentActivity() {

    @Inject
    lateinit var repository: TopHeadlineRepository

    private lateinit var viewModel: TopHeadlineViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityComponent = DaggerActivityComponent.builder()
            .applicationComponent((applicationContext as NewsApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
        val factory = ViewModelProviderFactory(TopHeadlineViewModel::class) {
            TopHeadlineViewModel(repository)
        }
        viewModel = ViewModelProvider(this, factory)[TopHeadlineViewModel::class.java]
//TopHeadlineListScreen((uiState as UiState.Success).data)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsState()

            DNewsAppMVVMArchitectureTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    when (uiState) {
                        is UiState.Loading -> CircularProgressIndicator()
                        is UiState.Success -> Text(
                            "Success: ${
                                (uiState as UiState.Success).data.get(
                                    0
                                )
                            }"
                        )

                        is UiState.Error -> Text("Error: ${(uiState as UiState.Error).message}")
                    }
                }
            }
        }
    }

    fun getDependency() {

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DNewsAppMVVMArchitectureTheme {
        Greeting("Android")
    }
}