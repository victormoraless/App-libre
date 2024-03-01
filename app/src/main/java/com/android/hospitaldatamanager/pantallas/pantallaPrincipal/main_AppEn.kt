package com.android.hospitaldatamanager.pantallas.pantallaPrincipal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.hospitaldatamanager.R

@Composable
fun main_AppEn(navigationController: NavHostController) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xff2268da))
                .height(550.dp),


            ) {
            Column(modifier = Modifier.padding(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.es),
                    contentDescription = "Horarios De Disponibilidad",
                    modifier = Modifier
                        .size(50.dp)
                        .clickable { navigationController.navigate("main_App") }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.en),
                    contentDescription = "Horarios De Disponibilidad",
                    modifier = Modifier
                        .size(46.dp)
                        .clickable { navigationController.navigate("main_AppEn") }
                )
            }
            Image(
                painterResource(id = R.drawable.doctor_foto),
                contentDescription = "foto de el docotor inicsio", modifier = Modifier
                    .size(800.dp)
                    .padding(top = 150.dp)
            )
        }
        Row {
            Column(modifier = Modifier.padding(top = 50.dp, start = 30.dp)) {
                Text(text = "Easy access", fontSize = 32.sp)
                Text(text = "and fast ", fontSize = 32.sp)
                Text(text = "to your health", fontSize = 32.sp)

            }
            Box(
                modifier = Modifier
                    .padding(start = 82.dp, top = 82.dp)
                    .size(73.dp)
            ) {
                Column {
                    Button(
                        onClick = { navigationController.navigate("iniciar_sesionEn") },
                        modifier = Modifier
                            .height(70.dp)
                            .padding(3.dp)
                            .width(70.dp)
                            .clickable { },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff2268Da),
                            contentColor = Color.White
                        ),
                    ) {
                        Icon(
                            Icons.Default.ArrowForward,
                            contentDescription = "",
                            Modifier.fillMaxSize()
                        )
                    }
                }
            }


        }


    }


}

