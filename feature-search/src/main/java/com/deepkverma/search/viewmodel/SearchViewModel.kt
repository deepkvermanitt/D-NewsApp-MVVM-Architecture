package com.deepkverma.search.viewmodel

import android.R
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepkverma.core.viewmodel.UiState
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.usecase.GetSearchNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchViewModel @Inject constructor(val searchUSerCase: GetSearchNewsUseCase) : ViewModel() {

    private val _UIState = MutableStateFlow<UiState<List<Article>>>(UiState.Loading)
    var uiState = _UIState

    val queryFlow = MutableStateFlow("")
    fun searchNews(query: String) {
        queryFlow.value = query
        viewModelScope.launch {
            queryFlow.debounce(300).filter { query ->
              println("query is $query")
                query.isNotEmpty() && query.length > 3
            }
                .flatMapLatest {
                    queryLatest ->
                    println("queryLatest is $queryLatest")
                    searchUSerCase(queryLatest) }.catch {
                    _UIState.value = UiState.Error(it.message.orEmpty())
                }.collect {
                    articles ->
                    _UIState.value = UiState.Success(data = articles) }

        }
    }

    fun updateQuery(query: String) {
        queryFlow.value = query
    }
}