package com.deepkverma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.deepkverma.feature_welcome.ui.WelcomScreen
import kotlinx.coroutines.delay

class SplashScreen(private val navHostController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppNavigation()

        }
    }


    @Composable
    fun SplashScreenContent() {
        val context = LocalContext.current

        val scaleAnimation = remember {
            Animatable(0.8f)

        }
        LaunchedEffect(true) {
            scaleAnimation.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = 1000,
                    easing = FastOutSlowInEasing
                )
            )
            delay(1000) // splash delay total ~2 seconds
            // WelcomScreen.launchWelCome(context)
            navHostController.navigate(NavRoutes.Welcome.route) {
                popUpTo(NavRoutes.Splash.route) { inclusive = true }
            }
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.Companion
                .fillMaxSize()
                .padding(32.dp)
        ) {
            Image(
                painter = painterResource(id = android.R.drawable.star_on), // replace with your logo
                contentDescription = "App Logo",
                modifier = Modifier.Companion
                    .size(128.dp)
                    .scale(scaleAnimation.value)
            )
        }
    }
}