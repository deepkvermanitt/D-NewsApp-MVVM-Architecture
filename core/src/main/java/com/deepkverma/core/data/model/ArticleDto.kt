package com.deepkverma.core.data.model

data class ArticleDto( private val title: String,
                       private val description: String,
                       private val url: String,
                       private val urlToImage: String,
                       private val source: SourceDto,)
