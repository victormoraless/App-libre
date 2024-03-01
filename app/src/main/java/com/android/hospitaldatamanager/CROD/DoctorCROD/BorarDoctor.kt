package com.android.hospitaldatamanager.CROD.DoctorCROD
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.firebase.firestore.FirebaseFirestore


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorarDoctor(navController: NavHostController) {

    val db = FirebaseFirestore.getInstance()
    val coleccion = "Doctores"

    var mensajeConfirmacion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 140.dp)
    ) {
        Text(
            text = "Introduce tu Correo electrónico:",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )

        var email by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            label = { Text(text = "Correo electrónico") },
            leadingIcon = { Icon(Icons.Outlined.Delete, contentDescription = null) },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xCE2268DA),
                unfocusedBorderColor = Color.Black,
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(

            onClick = {
                if (email.isNotBlank()) {
                    db.collection(coleccion)
                        .document(email)
                        .delete()
                        .addOnSuccessListener {
                            mensajeConfirmacion = "Datos eliminados correctamente"

                            email = ""

                        }
                        .addOnFailureListener {
                            mensajeConfirmacion =
                                "No se han podido eliminar los datos. Intentelo de nuevo."

                            email = ""

                        }
                }
                navController.navigate("iniciar_sesion")
            },

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xff2268Da),
                contentColor = Color.White,
            ),
           modifier = Modifier.fillMaxWidth()
               .height(50.dp).padding(horizontal = 100.dp)
        )
        {

            Text(text = "Borrar")

        }

        Spacer(modifier = Modifier.size(5.dp))
        Text(text = mensajeConfirmacion)
    }
}