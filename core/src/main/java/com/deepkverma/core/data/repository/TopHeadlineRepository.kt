package com.deepkverma.core.data.repository

import com.deepkverma.core.data.api.NetworkService
import com.deepkverma.core.data.model.ArticleDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TopHeadlineRepository @Inject constructor(private val networkService: NetworkService) {
    fun getTopHeadlines(country: String): Flow<List<ArticleDto>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map { it.articles }

    }
}