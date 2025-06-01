package com.deepkverma.d_newsapp_mvvm_architecture.data.model

import com.deepkverma.d_newsapp_mvvm_architecture.utils.AppConstant
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title") private val title: String = AppConstant.EMPTY,
    @SerializedName("description") private val description: String = AppConstant.EMPTY,
    @SerializedName("url") private val url: String = AppConstant.EMPTY,
    @SerializedName("urlToImage") private val urlToImage: String = AppConstant.EMPTY,
    @SerializedName("source") private val source: Source,

    )
