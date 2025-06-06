package com.deepkverma.core.data.model

import com.deepkverma.core.utils.WelcomeOptions.EMPTY
import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(
    @SerializedName("status")
    val status: String = EMPTY,
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles") val articles: List<ArticleDto> = ArrayList<ArticleDto>()
)
