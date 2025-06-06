package com.deepkverma.feature_welcome.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class WelcomScreen: ComponentActivity() {

    companion object{
        fun launchWelCome(context: Context){
            context.startActivity(Intent(context, WelcomScreen::class.java))
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WelcomeCompose()
        }
    }
}