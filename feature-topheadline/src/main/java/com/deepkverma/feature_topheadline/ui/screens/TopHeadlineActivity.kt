package com.deepkverma.feature_topheadline.ui.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import coil.ImageLoader
import com.deepkverma.core.data.repository.TopHeadlineRepository
import com.deepkverma.core.utils.AppGraph
import com.deepkverma.domain.usecase.GetTopHeadlinesUseCase
import com.deepkverma.feature_topheadline.di.component.DaggerActivityComponent
import com.deepkverma.feature_topheadline.di.module.ActivityModule
import com.deepkverma.feature_topheadline.ui.theme.DNewsAppMVVMArchitectureTheme
import com.deepkverma.feature_topheadline.ui.viewmodel.TopHeadlineViewModel
import com.deepkverma.core.viewmodel.UiState
import com.deepkverma.core.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class TopHeadlineActivity : ComponentActivity() {

    companion object {

        fun launchTopLineActivity(context: Context) {
            val intent = Intent(context, TopHeadlineActivity::class.java)
            context.startActivity(intent)
        }
    }
    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var getTopHeadlinesUseCase: GetTopHeadlinesUseCase

    private lateinit var viewModel: TopHeadlineViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appGraph by lazy { application as AppGraph }
        val activityComponent = DaggerActivityComponent.builder()
            .applicationComponent(appGraph.applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
        val factory = ViewModelProviderFactory(TopHeadlineViewModel::class) {
            TopHeadlineViewModel(getTopHeadlinesUseCase)
        }
        viewModel = ViewModelProvider(this, factory)[TopHeadlineViewModel::class.java]
//TopHeadlineListScreen((uiState as UiState.Success).data)
        enableEdgeToEdge()
        setContent {
            TopHeadlineScreen(viewModel,imageLoader)
        }
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