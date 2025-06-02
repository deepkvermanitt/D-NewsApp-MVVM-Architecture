package com.deepkverma.core.data.model

import com.deepkverma.core.utils.WelcomeOptions.EMPTY
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("title") private val title: String = EMPTY,
    @SerializedName("description") private val description: String = EMPTY,
    @SerializedName("url") private val url: String = EMPTY,
    @SerializedName("urlToImage") private val urlToImage: String = EMPTY,
    @SerializedName("source") private val source: Source,

    )
