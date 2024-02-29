package com.example.tasky.authentication.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasky.R
import com.example.tasky.authentication.presentation.util.AuthenticationUtil.isValidEmail
import com.example.tasky.authentication.presentation.util.AuthenticationUtil.isValidFullName
import com.example.tasky.authentication.presentation.util.AuthenticationUtil.isValidPassword

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(onRegistrationComplete: () -> Unit) {
    // You might want to manage these with ViewModel
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Text above the pseudo-bottom sheet
        Text(
            text = "Create your account",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 64.dp), // Adjust the padding as needed
            color = Color.White,
            fontSize = 28.sp
        )
        // The pseudo-bottom sheet
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.80f) // Adjust this value as needed
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                )
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp, top = 40.dp),
                value = fullName,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { fullName = it },
                label = { Text("Full Name") },
                trailingIcon = {
                    if (isValidFullName(fullName)) {
                        Icon(
                            painterResource(id = R.drawable.ic_check_mark),
                            contentDescription = "Valid"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),
                value = email,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { email = it },
                placeholder = { Text("Email Address") }, // Placeholder text shown when the field is empty
                label = { Text("Email Address") },
                trailingIcon = {
                    if (isValidEmail(email)) {
                        Icon(
                            painterResource(id = R.drawable.ic_check_mark),
                            contentDescription = "Valid"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),
                value = password,
                shape = RoundedCornerShape(10.dp),
                onValueChange = { password = it },
                label = { Text("Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            if (passwordVisible) painterResource(id = R.drawable.ic_hide_password) else painterResource(
                                id = R.drawable.ic_show_password
                            ),
                            contentDescription = "Toggle Password Visibility"
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp),
                onClick = {
                    // Handle registration logic here, such as calling your backend API
                    onRegistrationComplete()
                },
                enabled = isValidFullName(fullName) && isValidEmail(email) && isValidPassword(
                    password
                )
            ) {
                Text("Get Started")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationFormField(
    hint: String,
    backgroundColor: Color,
    isPassword: Boolean = false
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = hint) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth(1.0f)
            .background(backgroundColor, RectangleShape)
            .padding(8.dp), // Adjust padding as needed
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}


