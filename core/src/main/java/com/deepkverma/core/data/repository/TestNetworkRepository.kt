package com.deepkverma.core.data.repository

import com.deepkverma.core.mapper.toDomain
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.model.Source
import com.deepkverma.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TestNetworkRepository() : NewsRepository {

    override fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(
                listOf<Article>(
                    Article(
                        title = "Top HeadLine",
                        urlToImage = "https://i0.wp.com/9to5mac.com/wp-content/uploads/sites/6/2025/05/apple-glasses-light.jpg?resize=1200%2C628&quality=82&strip=all&ssl=1",
                        description = "Desciption",
                        url = "https://9to5mac.com/2025/06/08/apple-rumored-ai-smart-glasses-vs-meta-ray-bans/",
                        source = Source(id = "", name = "9to5Mac")
                    ),
                )
            )
        }

    }

    override fun searchNews(query: String): Flow<List<Article>> {
        return flow {
            emit(emptyList())
        }
    }

}