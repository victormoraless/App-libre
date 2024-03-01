package com.android.hospitaldatamanager.CROD

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.hospitaldatamanager.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrencipal(navigationController: NavHostController) {
    TopAppBar(
        { },
        navigationIcon = {
            IconButton(onClick = {navigationController.navigate("MenuPrencipal")}) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color(0xFF000000),
                    modifier = Modifier.clickable { navigationController.navigate("mainPaciente") }

                )
            }
        },
    )
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
        }

        Spacer(modifier = Modifier.height(300.dp))

        Button(
            onClick = { navigationController.navigate("MenuPaciente") },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .width(300.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff2268Da),
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(text = "Paciente", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { navigationController.navigate("MenuDoctor") },
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .width(300.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff2268Da),
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(10.dp),
        ) {
            Text(text = "Médico", fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }

}