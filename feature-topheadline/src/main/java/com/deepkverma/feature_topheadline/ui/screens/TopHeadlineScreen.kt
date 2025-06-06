package com.deepkverma.feature_topheadline.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deepkverma.domain.model.Article
import com.deepkverma.feature_topheadline.ui.viewmodel.TopHeadlineViewModel
import com.deepkverma.feature_topheadline.ui.viewmodel.UiState
import com.deepkverma.feature_topheadline.R

@Composable
fun TopHeadlineScreen(viewModel: TopHeadlineViewModel) {
    fun retry() {
        viewModel.fetchTopHeadlines()
    }

    val uiState by viewModel.uiState.collectAsState()
    when (uiState) {
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is UiState.Error -> {
            val errorMessage = (uiState as UiState.Error).message
            Column(modifier = Modifier.fillMaxSize()) {
                Text(text = "Error: $errorMessage")
                Spacer(modifier = Modifier.height(12.dp))
                Button(onClick = { retry() }) {
                    Text(text = "Retry..")
                }

            }
        }

        is UiState.Success -> {
            val articles = (uiState as UiState.Success<List<Article>>).data
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(articles.size) { index ->

                    val article = articles.get(index)
                    GetArticleCard(article)
                    HorizontalDivider(
                        modifier = Modifier.height(2.dp),
                        thickness = DividerDefaults.Thickness,
                        color = DividerDefaults.color
                    )

                }
            }
        }
    }

}

@Composable
fun GetArticleCard(article: Article) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current).data(article.urlToImage)
            .placeholder(
                R.mipmap.placeholder
            ).build(),
        contentDescription = article.title,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        contentScale = ContentScale.Crop,

        )

    Text(
        text = article.title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )

}