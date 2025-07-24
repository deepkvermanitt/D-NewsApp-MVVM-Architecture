package com.deepkverma

sealed class NavRoutes (val route:String){
    object Splash: NavRoutes("Splash.route")
    object Welcome: NavRoutes("Welcome.route")
    object TopHeadline: NavRoutes("TopHeadline.route")
    object Search: NavRoutes("Search.route")

}