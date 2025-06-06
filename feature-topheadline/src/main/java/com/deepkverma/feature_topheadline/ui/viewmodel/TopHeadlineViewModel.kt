package com.deepkverma.feature_topheadline.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepkverma.core.data.model.ArticleDto
import com.deepkverma.core.data.repository.TopHeadlineRepository
import com.deepkverma.core.utils.WelcomeOptions.COUNTRY
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.usecase.GetTopHeadlinesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class TopHeadlineViewModel @Inject constructor(
    private val getTopHeadlinesUseCase: GetTopHeadlinesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchTopHeadlines()
    }

    fun fetchTopHeadlines() {
        viewModelScope.launch {
            getTopHeadlinesUseCase("US") // country passed here
                .catch { _uiState.value = UiState.Error(it.message.orEmpty()) }
                .collect { articles -> _uiState.value = UiState.Success(articles) }
        }
    }
}
