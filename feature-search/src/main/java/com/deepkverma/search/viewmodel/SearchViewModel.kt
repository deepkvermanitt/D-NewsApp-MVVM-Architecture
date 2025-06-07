package com.deepkverma.search.viewmodel

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepkverma.core.viewmodel.UiState
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.usecase.GetSearchNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val searchUSerCase: GetSearchNewsUseCase) : ViewModel() {

    private val _UIState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    var uiState = _UIState


    fun searchNews(query: String) {

        viewModelScope.launch {
            searchUSerCase(query).catch {
                _UIState.value = UiState.Error(it.message.orEmpty())
            }.collect { articles ->
                _UIState.value = UiState.Success(data = articles)

            }
        }
    }
}