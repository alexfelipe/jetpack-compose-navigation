package br.com.alexfelipe.authapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
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
//                    SignInScreen(
//                        onSignInClick = {},
//                        onSignUpClick = {}
//                    )
//                    SignUpScreen(
//                        onSignUpClick = {}
//                    )
//                    MainScreen(user = "")
                }
            }
        }
    }
}
