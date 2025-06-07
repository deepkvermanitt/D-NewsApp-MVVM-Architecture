package com.deepkverma.search.ui

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.ImageLoader
import com.deepkverma.core.viewmodel.UiState
import com.deepkverma.search.viewmodel.SearchViewModel
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deepkverma.domain.model.Article
import kotlinx.coroutines.delay

@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    imageLoader: ImageLoader

) {
    val context: Context = LocalContext.current
    var query by remember { mutableStateOf("India") }

    LaunchedEffect(key1 = query) {
        searchViewModel.searchNews(query)

    }


    val composeState = searchViewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(

            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Search News Article") },
            singleLine = true

        )

        when (composeState.value) {
            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }

            }

            is UiState.Error -> {
                CircularProgressIndicator()
            }

            is UiState.Success -> {

                val articles = (composeState.value as UiState.Success<List<Article>>).data
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(articles.size) { index ->
                        val article = articles.get(index = index)
                        AsyncImage(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clickable {
                                    article.url.let {
                                        openInCustomTab(
                                            context = context,
                                            it
                                        )
                                    }
                                },
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(article.urlToImage).build(),
                            imageLoader = imageLoader,
                            contentScale = ContentScale.Crop,
                            contentDescription = article.description
                        )
                        Spacer(Modifier.height(2.dp))
                        Text(text = article.description)

                    }
                }
            }

        }
    }


}

fun openInCustomTab(context: Context, url: String) {
    val customTabsIntent = CustomTabsIntent.Builder().build()
    customTabsIntent.launchUrl(context, Uri.parse(url))
}