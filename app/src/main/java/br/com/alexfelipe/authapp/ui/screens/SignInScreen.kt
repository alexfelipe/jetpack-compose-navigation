package br.com.alexfelipe.authapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexfelipe.authapp.models.User
import br.com.alexfelipe.authapp.ui.theme.AuthAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    onSignInClick: (User) -> Unit,
    onSignUpClick: () -> Unit
) {
    Column {
        var username by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        TextField(
            value = username,
            onValueChange = { newValue ->
                username = newValue
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Usuário")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "pessoa que representa usuário"
                )
            }
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = {
                Text("Senha")
            },
            visualTransformation = PasswordVisualTransformation(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Password,
                    contentDescription = "representação de senha"
                )
            }
        )
        Button(
            onClick = {
                onSignInClick(
                    User(
                        username,
                        password
                    )
                )
            },
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            Text(text = "Entrar")
        }
        TextButton(
            onClick = { onSignUpClick() },
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Cadastrar")
        }
    }
}


@Preview
@Composable
fun SignInScreenPreview() {
    AuthAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignInScreen(
                onSignInClick = {},
                onSignUpClick = {}
            )
        }
    }
}