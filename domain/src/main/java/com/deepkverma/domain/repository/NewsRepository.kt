package com.deepkverma.domain.repository

import com.deepkverma.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getTopHeadlines(country: String): Flow<List<Article>>
}