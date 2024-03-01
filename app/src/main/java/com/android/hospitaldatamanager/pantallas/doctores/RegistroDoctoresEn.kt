package com.android.hospitaldatamanager.pantallas.doctores

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
import androidx.compose.material.icons.outlined.Email
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
fun RegistroDoctoresEn(navigationController: NavHostController ,viewModel: LoginScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    var nombreCompleto by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var fotoDoctor by remember { mutableStateOf<Uri?>(null) }
    var numeroDeIdentificacion by remember { mutableStateOf("") }
    var especialidadMédica by remember { mutableStateOf("") }
    var anosDeExperiencia by remember { mutableStateOf("") }
    var horariosDeDisponibilidad by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var numeroDeTelefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var idiomas by remember { mutableStateOf("") }

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


                //--- Nombre de el Doctor ---
                OutlinedTextField(
                    value = nombreCompleto,
                    onValueChange = { nombreCompleto = it },
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
                            contentDescription = "Dni-Nie",
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

                //--- Foto de  el Doctor ---
                val context = LocalContext.current
                val bitmap = remember { mutableStateOf<Bitmap?>(null) }

                val launcher =
                    rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
                        fotoDoctor = uri
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
                            fotoDoctor?.let {
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

                //--- Número de Identificación Médica ---
                OutlinedTextField(
                    value = numeroDeIdentificacion, onValueChange = { numeroDeIdentificacion = it },
                    label = {
                        Text(
                            "Medical Identification Number",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.id_card),
                            contentDescription = "Medical Identification Number",
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
                //--- Especialidad médica ---
                OutlinedTextField(
                    value = especialidadMédica, onValueChange = { especialidadMédica = it },
                    label = { Text("Medical speciality", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.caduceus),
                            contentDescription = "Medical speciality",
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

                //--- Anos De Experiencia ---
                OutlinedTextField(
                    value = anosDeExperiencia, onValueChange = { anosDeExperiencia = it },
                    label = { Text("Years of experience", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.experience),
                            contentDescription = "Years of experience",
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

                //--- Idiomas ---

                OutlinedTextField(
                    value = idiomas, onValueChange = { idiomas = it },
                    label = { Text("Languages", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.language),
                            contentDescription = "Languages",
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
                //--- Horarios De Disponibilidad ---
                OutlinedTextField(
                    value = horariosDeDisponibilidad,
                    onValueChange = { horariosDeDisponibilidad = it },
                    label = {
                        Text(
                            "Availability Hours",
                            color = Color.Black,
                            fontSize = 14.sp
                        )
                    },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.clock),
                            contentDescription = "Availability Hours",
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

                OutlinedTextField(
                    value = direccion,
                    onValueChange = { direccion = it },
                    label = { Text("Address", color = Color.Black, fontSize = 14.sp) },
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

                //--- Número de teléfono ---
                OutlinedTextField(
                    value = numeroDeTelefono,
                    onValueChange = { numeroDeTelefono = it },
                    label = { Text("Phone number", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Call, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- Correo electrónico ---
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Email, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )
                //--- contraseña ---
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password", color = Color.Black, fontSize = 14.sp) },
                    leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color(0xCE2268DA),
                        unfocusedBorderColor = Color.Black,
                    )
                )


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp),
                    horizontalArrangement = Arrangement.Center
                ) {

                    val db = FirebaseFirestore.getInstance()
                    val coleccion = "Doctores"
                    val dato = hashMapOf(

                        "nombreCompleto" to nombreCompleto.toString(),
                        "dni" to dni.toString(),
                        "fotoDoctor" to fotoDoctor.toString(),
                        "numeroDeIdentificacion" to numeroDeIdentificacion.toString(),
                        "especialidadMédica" to especialidadMédica.toString(),
                        "anosDeExperiencia" to anosDeExperiencia.toString(),


                        "horariosDeDisponibilidad" to horariosDeDisponibilidad.toString(),
                        "direccion" to direccion.toString(),

                        "numeroDeTelefono" to numeroDeTelefono.toString(),
                        "email" to email.toString(),
                        "password" to password.toString(),
                        "idiomas" to idiomas.toString(),


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
                                            nombreCompleto = ""
                                            dni = ""
                                            //   fotoDoctor = ""
                                            numeroDeIdentificacion = ""
                                            especialidadMédica = ""
                                            anosDeExperiencia = ""
                                            horariosDeDisponibilidad = ""
                                            direccion = ""
                                            numeroDeTelefono = ""
                                            email = ""
                                            password = ""
                                            idiomas = ""


                                        }
                                        .addOnFailureListener {
                                            mensajeConfirmacion =
                                                "No se han podido guardar los datos. Intentelo de nuevo."
                                            nombreCompleto = ""
                                            dni = ""
                                            //   fotoDoctor = ""
                                            numeroDeIdentificacion = ""
                                            especialidadMédica = ""
                                            anosDeExperiencia = ""
                                            horariosDeDisponibilidad = ""
                                            direccion = ""
                                            numeroDeTelefono = ""
                                            email = ""
                                            password = ""
                                            idiomas = ""
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