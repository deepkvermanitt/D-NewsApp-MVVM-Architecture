package com.deepkverma.d_newsapp_mvvm_architecture.data.model

import com.deepkverma.d_newsapp_mvvm_architecture.utils.AppConstant
import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(
    @SerializedName("status")
    val status: String = AppConstant.EMPTY,
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles") val articles: List<Article> = ArrayList<Article>()
)
