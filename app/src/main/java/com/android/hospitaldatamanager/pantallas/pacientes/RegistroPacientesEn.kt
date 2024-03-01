package com.android.hospitaldatamanager.pantallas.pacientes

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.hospitaldatamanager.Login.LoginScreenViewModel
import com.android.hospitaldatamanager.R
import com.google.firebase.firestore.FirebaseFirestore

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroPasientesEn(navigationController: NavHostController,viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var NombreCompleto by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var FechaDeNacimiento by remember { mutableStateOf("") }
    var GeneroDeElPaciente by remember { mutableStateOf("") }
    var fotoPaciente by remember { mutableStateOf<Uri?>(null) }
    var direccion by remember { mutableStateOf("") }
    var numeroDeTelefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var Diagnosticomedico by remember { mutableStateOf("") }
    var Nombredeltratante by remember { mutableStateOf("") }
    var Numeromedico by remember { mutableStateOf("") }
    var MedicamentosActuales by remember { mutableStateOf("") }

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

        TopAppBar(
            { },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF000000),
                        modifier = Modifier.clickable { navigationController.navigate("SeleccionEn") }
                    )
                }
            },
        )
        Box() {
            Column {
                Text(
                    text = "Data Form",
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "Personal information",
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = 16.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize()
        ) {
            Column {


                //--- Nombre de el paciente ---
                OutlinedTextField(
                    value = NombreCompleto,
                    onValueChange = { NombreCompleto = it },
                    label = { Text("Full name", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Dni __
                OutlinedTextField(
                    value = dni, onValueChange = { dni = it },
                    label = {
                        Text(
                            "DNI - NIE",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.dni),
                            contentDescription = "DNI - NIE",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA), unfocusedBorderColor = Color.Black,
                    )
                )
                //--- fecha de nacimientode el paciente ---
                OutlinedTextField(
                    value = FechaDeNacimiento,
                    onValueChange = { FechaDeNacimiento = it },
                    label = { Text("Birthdate", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.DateRange, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Género de el paciente ---
                OutlinedTextField(
                    value = GeneroDeElPaciente, onValueChange = { GeneroDeElPaciente = it },
                    label = { Text("Gender", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.gender_fluid),
                            contentDescription = "Gender",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp), maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA), unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Foto de  el paciente ---
                val context = LocalContext.current
                val bitmap = remember { mutableStateOf<Bitmap?>(null) }

                val launcher =
                    rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                        fotoPaciente = uri
                    }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp)
                        .padding(top = 6.dp, start = 10.dp, end = 10.dp)
                        .background(Color.White),
                    shape = RoundedCornerShape(5.dp),
                    border = BorderStroke(1.dp, Color.Black),

                    ) {
                    Row(
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxSize()
                            .clip(RoundedCornerShape(percent = 1))
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .padding(5.dp)
                        ) {
                            fotoPaciente?.let {
                                if (Build.VERSION.SDK_INT < 30) {
                                    bitmap.value = MediaStore.Images
                                        .Media.getBitmap(context.contentResolver, it)
                                } else {
                                    val source =
                                        ImageDecoder.createSource(context.contentResolver, it)
                                    bitmap.value = ImageDecoder.decodeBitmap(source)
                                }
                                bitmap.value?.let { btm ->
                                    Image(
                                        bitmap = btm.asImageBitmap(),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(percent = 10))
                                    )
                                }
                            }
                        }
                        Text(
                            text = "Submit your photo",
                            modifier = Modifier.padding(22.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.ExtraBold
                        )

                        Button(
                            onClick = { launcher.launch("image/*") },
                            modifier = Modifier
                                .padding(start = 40.dp, bottom = 10.dp, top = 10.dp, end = 6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xff2268Da),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Text(
                                text = "Select",
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
                //--- Direccíon de  el paciente ---
                OutlinedTextField(
                    value = direccion,
                    onValueChange = { direccion = it },
                    label = { Text("Address", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.LocationOn, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Número de telfono de  el paciente ---
                OutlinedTextField(
                    value = numeroDeTelefono,
                    onValueChange = { numeroDeTelefono = it },
                    label = { Text("Phone number", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Call, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Correro electronico de  el paciente ---
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Contraseña ---
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Información Médical ---

                Text(
                    text = "Medical Information",
                    modifier = Modifier.padding(start = 10.dp, top = 14.dp),
                    fontSize = 16.sp
                )

                //--- Información Médical ---

                //--- Diagnóstico médico ---
                OutlinedTextField(
                    value = Diagnosticomedico, onValueChange = { Diagnosticomedico = it },
                    label = { Text("Medical diagnostic", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.stethoscope),
                            contentDescription = "Medical diagnostic",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp), maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA), unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Nombre del  tratante ---
                OutlinedTextField(
                    value = Nombredeltratante, onValueChange = { Nombredeltratante = it },
                    label = {
                        Text(
                            "Name of the treating doctor",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.doctor),
                            contentDescription = "Doctor's Name",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp), maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA), unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Número de teléfono del médico tratante ---
                OutlinedTextField(
                    value = Numeromedico,
                    onValueChange = { Numeromedico = it },
                    label = {
                        Text(
                            "Tel number of the treating doctor",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = { Icon(Icons.Outlined.Call, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Medicamentos actuales (nombre, dosis, frecuencia): ---
                OutlinedTextField(
                    value = MedicamentosActuales, onValueChange = { MedicamentosActuales = it },
                    label = { Text("Current medications", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.pill),
                            contentDescription = "Current medications",
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA), unfocusedBorderColor = Color.Black,
                    )
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    val db = FirebaseFirestore.getInstance()
                    val coleccion = "Pacientes"
                    val dato = hashMapOf(

                        "NombreCompleto" to NombreCompleto.toString(),
                        "dni" to dni.toString(),
                        "FechaDeNacimiento" to FechaDeNacimiento.toString(),
                        "GeneroDeElPaciente" to GeneroDeElPaciente.toString(),

                        "fotoPaciente" to fotoPaciente.toString(),

                        "direccion" to direccion.toString(),
                        "numeroDeTelefono" to numeroDeTelefono.toString(),
                        "email" to email.toString(),
                        "password" to password.toString(),
                        "Diagnosticomedico" to Diagnosticomedico.toString(),
                        "Nombredeltratante" to Nombredeltratante.toString(),
                        "Numeromedico" to Numeromedico.toString(),
                        "MedicamentosActuales" to MedicamentosActuales.toString(),

                        )

                    var mensajeConfirmacion by remember { mutableStateOf("") }





                    Button(
                        onClick = {
                            viewModel.createUserWithEmailAndPassword(email, password) { success, errorMessage ->
                                if (success) {
                                    navigationController.navigate("iniciar_sesion")
                                    db.collection(coleccion)
                                        .document(email)
                                        .set(dato)
                                        .addOnSuccessListener {
                                            mensajeConfirmacion = "Datos guardados correctamente"

                                            NombreCompleto = ""
                                            dni = ""
                                            // fotoPaciente = ""
                                            FechaDeNacimiento = ""
                                            GeneroDeElPaciente = ""
                                            direccion = ""
                                            numeroDeTelefono = ""
                                            email = ""
                                            password = ""
                                            Diagnosticomedico = ""
                                            Nombredeltratante = ""
                                            Numeromedico = ""
                                            MedicamentosActuales = ""


                                        }
                                        .addOnFailureListener {
                                            mensajeConfirmacion =
                                                "No se han podido guardar los datos. Intentelo de nuevo."
                                            NombreCompleto = ""
                                            dni = ""
                                            //   fotoPaciente = ""
                                            FechaDeNacimiento = ""
                                            GeneroDeElPaciente = ""
                                            direccion = ""
                                            numeroDeTelefono = ""
                                            email = ""
                                            password = ""
                                            Diagnosticomedico = ""
                                            Nombredeltratante = ""
                                            Numeromedico = ""
                                            MedicamentosActuales = ""


                                        }
                                } else {
                                    // Error al crear el usuario
                                    // Muestra un mensaje de error al usuario
                                    println("Error al crear usuario: $errorMessage")
                                }
                            }
                        },

                        modifier = Modifier
                            .width(180.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xff2268Da),
                            contentColor = Color.White,
                        ),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = "Register", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }


        }


    }
}