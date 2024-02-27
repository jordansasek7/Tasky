package com.example.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tasky.ui.theme.TaskyTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setContent {
                MyApp()
            }
        }
    }
}

@Composable
fun SplashScreen(onSplashComplete: () -> Unit) {
    LaunchedEffect(key1 = true) {
        delay(2000) // Delay for 2 seconds
        onSplashComplete() // Notify that splash is complete
    }

    // Splash screen UI
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Splash Screen", fontSize = 24.sp)
    }
}

@Composable
fun MainContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Main Content", fontSize = 24.sp)
    }
}

@Composable
fun MyApp() {
    var showSplashScreen by remember { mutableStateOf(true) }

    if (showSplashScreen) {
        SplashScreen(onSplashComplete = { showSplashScreen = false })
    } else {
        MainContent()
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {

}