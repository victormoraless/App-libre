package com.androuid.jetpackcomposeinstagram

import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.hospitaldatamanager.Login.LoginScreenViewModel
import com.android.hospitaldatamanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun iniciar_sesion(
    navigationController: NavHostController,
    viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column {
        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color(0xFF000000),
                modifier = Modifier.clickable { navigationController.navigate("main_App") }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.pngwing_com),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(300.dp)
        )
        Text(
            text = "Bienvenido  de  nuevo !",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 30.dp, top = 20.dp)
        )

        Column(modifier = Modifier.padding(20.dp)) {


            TextField(
                value = email, onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text(text = "Correo electronico") },
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF000000),
                    containerColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )

            )
            var passwordVisibility by remember {
                mutableStateOf(false)
            }
            Spacer(modifier = Modifier.size(15.dp))

            TextField(
                value = password, onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text(text = "Contraseña") },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color(0xFF000000),
                    containerColor = Color(0xFFFFFFFF),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val imagen = if (passwordVisibility) {
                        Icons.Filled.Lock
                    } else {
                        Icons.Filled.Lock
                    }
                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(imageVector = imagen, contentDescription = "show Password")
                    }
                },
                visualTransformation = if (passwordVisibility) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                }
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "Has olvidado tu contraseña ?",
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9),
                modifier = Modifier.align(Alignment.End)
            )
            Spacer(modifier = Modifier.size(15.dp))

            Button(
                onClick = {
                    viewModel.signInWithEmailAndPassword(email,password){
                        navigationController.navigate("mainPaciente")
                    }
                },
                enabled = Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff4ea8e9),
                    disabledContainerColor = Color(0xFFD5D5D5),
                    contentColor = Color.Black,
                    disabledContentColor = Color.White

                )
            ) {
                Text(text = "Iniciar sesión")
            }
            Spacer(modifier = Modifier.size(25.dp))


            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

                Divider(
                    Modifier
                        .background(Color(0xFFF9FF9))
                        .height(1.dp)
                        .weight(1f)
                )

                Text(
                    text = "O",
                    modifier = Modifier.padding(horizontal = 6.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFB5B5B5)
                )
                Divider(
                    Modifier
                        .background(Color(0xFFF9FF9))
                        .height(1.dp)
                        .weight(1f)
                )
            }
            Spacer(modifier = Modifier.size(80.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿ No tienes una cuenta ?", fontSize = 12.sp,
                    color = Color(0xFFB5B5B5)
                )
                Text(
                    text = "Registrar.",
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { navigationController.navigate("Seleccion") },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4EA8E9)
                )


            }


        }

    }
}
