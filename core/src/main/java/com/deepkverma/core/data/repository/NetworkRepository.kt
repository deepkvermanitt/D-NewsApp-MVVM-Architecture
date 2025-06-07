package com.deepkverma.core.data.repository

import com.deepkverma.core.data.api.NetworkService
import com.deepkverma.core.mapper.toDomain
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class NetworkRepository @Inject constructor(private val networkService: NetworkService) :
    NewsRepository {

    override fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map { response ->
            response.articles.map { it.toDomain() }
        }

    }

    override fun searchNews(query: String): Flow<List<Article>> {
        return flow {
            emit(networkService.searchNews(query))
        }.map { response ->
            response.articles.map { article ->
                article.toDomain()
            }
        }
    }

}