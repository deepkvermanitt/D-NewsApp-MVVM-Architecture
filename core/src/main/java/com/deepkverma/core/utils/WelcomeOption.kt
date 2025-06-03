package com.deepkverma.core.utils

sealed class WelcomeOption( val label: String) {
    object TopHeadLine : WelcomeOption("Top Headlines")
    object NewsSources : WelcomeOption("News Sources")
    object Countries : WelcomeOption("Countries")
    object Languages : WelcomeOption("Languages")
    object Search : WelcomeOption("Search")
    companion object {
        val OPTIONS = listOf<WelcomeOption>(TopHeadLine, NewsSources, Countries, Languages, Search)
    }
}