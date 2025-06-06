package com.deepkverma.domain.model


data class Article(
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val source: Source,

    ){

}

