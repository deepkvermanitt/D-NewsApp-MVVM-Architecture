package com.deepkverma.core.mapper

import com.deepkverma.core.data.model.ArticleDto
import com.deepkverma.core.data.model.SourceDto
import com.deepkverma.domain.model.Article
import com.deepkverma.domain.model.Source

fun ArticleDto.toDomain(): Article {
    return Article(
        title = this.title.orEmpty(),
        description = this.description.orEmpty(),
        source = this.source.toDomain(),
        url = this.url.orEmpty(),
        urlToImage = this.urlToImage.orEmpty(),
    )
}

fun SourceDto.toDomain(): Source {
    return Source(
        name = this.name.orEmpty()
    )
}