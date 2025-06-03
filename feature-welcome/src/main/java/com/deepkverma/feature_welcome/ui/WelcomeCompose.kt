package com.deepkverma.feature_welcome.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.deepkverma.core.utils.WelcomeOption

@Composable
fun WelcomeCompose() {
    val context = LocalContext.current
    val buttonModifier =
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFF0B2C66)) // Dark navy blue
            .padding(horizontal = 32.dp)

    val textStyle = TextStyle(
        color = Color.White, fontSize = 16.sp
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE0E0E0)), // light gray background
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WelcomeOption.OPTIONS.forEach { option ->
                Button(
                    onClick = {
                        when (option) {
                            WelcomeOption.Countries -> navigateToCountries(context)
                            WelcomeOption.Languages -> navigateToLanguage(context)
                            WelcomeOption.NewsSources -> navigateToNewsSources(context)
                            WelcomeOption.Search -> navigateToSearch(context)
                            WelcomeOption.TopHeadLine -> navigateToTopHeadline(context)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF0B2C66), // Navy Blue
                        contentColor = Color.White
                    )
                ) {
                    Text(text = option.label, style = textStyle)
                }
            }
        }
    }
}


fun navigateToLanguage(context: Context) {
    Toast.makeText(context, "navigateToLanguage", Toast.LENGTH_SHORT).show()
}

fun navigateToNewsSources(context: Context) {
    Toast.makeText(context, "navigateToNewsSources", Toast.LENGTH_SHORT).show()
}

fun navigateToSearch(context: Context) {
    Toast.makeText(context, "navigateToSearch", Toast.LENGTH_SHORT).show()
}

fun navigateToCountries(context: Context) {
    Toast.makeText(context, "navigateToCountries", Toast.LENGTH_SHORT).show()
}

fun navigateToTopHeadline(context: Context) {
    Toast.makeText(context, "navigateToTopHeadline", Toast.LENGTH_SHORT).show()
}


