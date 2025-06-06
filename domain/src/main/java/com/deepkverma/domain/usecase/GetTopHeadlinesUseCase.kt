package com.deepkverma.domain.usecase

import com.deepkverma.domain.repository.NewsRepository
import javax.inject.Inject

class GetTopHeadlinesUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    operator fun invoke(country: String) = newsRepository.getTopHeadlines(country)
}