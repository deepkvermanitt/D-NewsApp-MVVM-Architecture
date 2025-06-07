package com.deepkverma.domain.usecase

import com.deepkverma.domain.repository.NewsRepository
import javax.inject.Inject

class GetSearchNewsUseCase @Inject constructor(val repository: NewsRepository) {
    operator fun invoke(queryString: String) = repository.searchNews(queryString)
}