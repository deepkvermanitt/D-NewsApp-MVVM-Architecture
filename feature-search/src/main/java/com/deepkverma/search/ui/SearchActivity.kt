package com.deepkverma.search.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle

import androidx.activity.ComponentActivity

class SearchActivity : ComponentActivity() {
    companion object {
        fun launchSearch(context: Context) {
            val intent = Intent(context, SearchActivity::class.java)

            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}