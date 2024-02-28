package com.example.tasky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tasky.authentication.presentation.ui.RegistrationScreen

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                viewModel.isLoading.value
            }
        }
        setContent {
            setContent {
                MyApp()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registration") {
        composable("registration") {
            RegistrationScreen {
                navController.navigate("mainContent") {
                    popUpTo("registration") {
                        inclusive = true
                    }
                }
            }
        }
    }
}
// TODO Define other composable screens and navigation routes

//            LoginScreen(onLoginSuccess = {
//                // Navigate to another screen upon successful login
//                navController.navigate("mainContent") {
//                    popUpTo("login") { inclusive = true }
//                }
//            })


@Composable
fun MyApp() {
    AppNavigation()
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
}