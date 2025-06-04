package com.deepkverma.feature_topheadline.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepkverma.core.data.model.Article
import com.deepkverma.core.data.repository.TopHeadlineRepository
import com.deepkverma.core.utils.WelcomeOptions.COUNTRY
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class TopHeadlineViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>> = _uiState

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        viewModelScope.launch {
            topHeadlineRepository.getTopHeadlines(COUNTRY).catch {

                _uiState.value = UiState.Error(it.message.toString())
            }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }

    }
}