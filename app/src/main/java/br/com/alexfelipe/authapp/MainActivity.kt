package br.com.alexfelipe.authapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.alexfelipe.authapp.ui.screens.MainScreen
import br.com.alexfelipe.authapp.ui.screens.SignInScreen
import br.com.alexfelipe.authapp.ui.screens.SignUpScreen
import br.com.alexfelipe.authapp.ui.theme.AuthAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main/{user}") {
                        composable("main/{user}") { entry ->
                            entry.arguments?.getString("user")?.let { user ->
                                MainScreen(user = user)
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }
                        }
                        composable("signIn") {
                            SignInScreen(
                                onSignInClick = { user ->
                                    navController.navigate("main/${user.username}")
                                },
                                onSignUpClick = {
                                    navController.navigate("signUp")
                                }
                            )
                        }
                        composable("signUp") {
                            SignUpScreen(
                                onSignUpClick = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
