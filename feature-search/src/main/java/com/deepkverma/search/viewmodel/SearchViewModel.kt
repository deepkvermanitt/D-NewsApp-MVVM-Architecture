package com.deepkverma.search.viewmodel

import androidx.lifecycle.ViewModel
import com.deepkverma.domain.usecase.GetSearchNewsUseCase
import javax.inject.Inject

class SearchViewModel @Inject constructor(searchUSerCase: GetSearchNewsUseCase) : ViewModel() {
    
}