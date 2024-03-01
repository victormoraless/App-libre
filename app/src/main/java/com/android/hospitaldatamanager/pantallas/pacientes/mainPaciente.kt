package com.android.hospitaldatamanager.pantallas.pacientes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.hospitaldatamanager.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun mainPaciente(navigationController: NavHostController) {


    Scaffold(

        content = {
            var textInput by remember { mutableStateOf("") }
//--- Header ---
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                Box() {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xCE2268DA))
                            .height(150.dp)
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back",
                                tint = Color(0xFF000000),
                                modifier = Modifier.clickable { navigationController.navigate("iniciar_sesion") }
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.padding(
                            top = 30.dp,
                            start = 30.dp,
                            end = 70.dp,
                            bottom = 30.dp
                        )
                    ) {
                        Row {
                            Box(
                                modifier = Modifier
                                    .size(65.dp)

                            ) {
                                /*    Image(
                                        painterResource(id = R.drawable.abuelo),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(percent = 60))
                                    )

                                 */
                            }
                            Box(
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .fillMaxSize()

                            ) {
                                Text(
                                    text = "Bienvendo a tu cuenta",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 22.sp
                                )
                            }
                        }
                    }
                    OutlinedTextField(
                        value = textInput,
                        onValueChange = { textInput = it },
                        placeholder = { Text("Buscar médico , medicina") },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Search,
                                contentDescription = null
                            )
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, end = 30.dp, top = 120.dp),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            focusedBorderColor = Color(0xCE2268DA),

                            )
                    )

                }
                //--Content --
                Box(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 30.dp, end = 30.dp)
                        .fillMaxWidth()
                        .height(60.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .size(65.dp)

                        ) {
                            Image(
                                painterResource(id = R.drawable.medical_examination),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)

                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(50.dp)

                        ) {
                            Image(
                                painterResource(id = R.drawable.online_pharmacy_2),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(65.dp)

                        ) {
                            Image(
                                painterResource(id = R.drawable.ambulance),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                            )


                        }
                        Box(
                            modifier = Modifier
                                .size(65.dp)

                        ) {
                            Image(
                                painterResource(id = R.drawable.application),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }


                    }

                }
                //-- El nuevo --
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
                        .height(230.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                    )
                    Row {
                        Text(text = "Mis Latidos", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(200.dp))
                        Text(
                            text = "Ver más",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xCE2268DA)
                        )
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 30.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0x2F435066)
                        )
                    ) {
                       Column {
                           Box(modifier = Modifier.padding(10.dp)){
                               Row {

                                       Image(
                                           painterResource(id = R.drawable.heart_attack),
                                           contentDescription = null,
                                           contentScale = ContentScale.Crop,
                                           modifier = Modifier
                                               .size(40.dp)
                                       )
                                       Spacer(modifier = Modifier.width(250.dp))
                                       Text(text = "61  RPM",fontSize = 14.sp,
                                           fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 10.dp))



                               }
                           }
                           Row (modifier = Modifier
                               .fillMaxWidth()
                               .height(200.dp)
                               .padding(start = 20.dp, end = 40.dp),
                               horizontalArrangement = Arrangement.SpaceBetween) {
                               Box(modifier =Modifier )
                               Column {
                                   Box(modifier = Modifier){
                                       Image(
                                           painterResource(id = R.drawable.upward_arrow),
                                           contentDescription = null,
                                           contentScale = ContentScale.Crop,
                                           modifier = Modifier
                                               .size(30.dp)
                                       )
                                   }
                                   Spacer(modifier = Modifier)
                                   Text(text = "120  RPM",fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 10.dp), color = Color(
                                           0xFF49A04C
                                       )
                                   )

                               }



                               Column {
                                   Box(modifier = Modifier){
                                       Image(
                                           painterResource(id = R.drawable.down_arrow),
                                           contentDescription = null,
                                           contentScale = ContentScale.Crop,
                                           modifier = Modifier
                                               .size(30.dp)
                                       )
                                   }
                                   Spacer(modifier = Modifier)
                                   Text(text = "60  RPM",fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 10.dp), color = Color.Red)

                               }

                               Column {
                                   Box(modifier = Modifier){
                                       Image(
                                           painterResource(id = R.drawable.heart_beat),
                                           contentDescription = null,
                                           contentScale = ContentScale.Crop,
                                           modifier = Modifier
                                               .size(30.dp)
                                       )
                                   }
                                   Spacer(modifier = Modifier)
                                   Text(text = "61  RPM",fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 10.dp))

                               }


                               Column {
                                   Box(modifier = Modifier){
                                       Image(
                                           painterResource(id = R.drawable.sleep),
                                           contentDescription = null,
                                           contentScale = ContentScale.Crop,
                                           modifier = Modifier
                                               .size(30.dp)
                                       )
                                   }
                                   Spacer(modifier = Modifier)
                                   Text(text = "8 h 30 min",fontSize = 12.sp,
                                       fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 15.dp, bottom = 10.dp))

                               }
                           }
                       }





                    }


                }


                //--- Mis citas
                Text(
                    text = "Mis citas",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                ) {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0x2F435066)
                            )
                        ) {
                            Row(Modifier.fillMaxSize()) {
                                //--Box Image --
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(top = 10.dp, end = 10.dp, start = 10.dp)

                                ) {
                                    Image(
                                        painterResource(id = R.drawable.doc),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(16.dp))


                                    )
                                }

                                //-- box De Datos --
                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 15.dp)
                                        .width(200.dp)
                                        .height(90.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "Dr . Ignaz Semmelwels",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Dantista",
                                            color = Color(0xFF504F4F),
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(top = 3.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            text = "cita : 13 / 05 / 2023 A 10:00",
                                            fontSize = 12.sp,
                                            color = Color(0xFF504F4F),
                                            modifier = Modifier.padding(top = 16.dp)
                                        )
                                    }
                                }
                                //-- box De Boton --

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(40.dp)
                                        .height(90.dp)

                                ) {
                                    var state by rememberSaveable { mutableStateOf(false) }

                                    Checkbox(
                                        checked = state,
                                        onCheckedChange = { state = !state },
                                        modifier = Modifier.padding(
                                            top = 30.dp,
                                            bottom = 30.dp,
                                            start = 10.dp
                                        ),
                                        enabled = true,
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xCE4284F0),
                                            uncheckedColor = Color.Black,
                                            checkmarkColor = Color.Black
                                        )
                                    )
                                }


                            }

                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0x2F435066)
                            )
                        ) {
                            Row(Modifier.fillMaxSize()) {
                                //--Box Image --
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(top = 10.dp, end = 10.dp, start = 10.dp)

                                ) {
                                    Image(
                                        painterResource(id = R.drawable.docotor2),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(16.dp))


                                    )
                                }

                                //-- box De Datos --
                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 15.dp)
                                        .width(200.dp)
                                        .height(90.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "Dr. Javier Pérez",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Dermatología",
                                            color = Color(0xFF504F4F),
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(top = 3.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            text = "cita : 18 / 06 / 2023 A 10:00",
                                            fontSize = 12.sp,
                                            color = Color(0xFF504F4F),
                                            modifier = Modifier.padding(top = 16.dp)
                                        )
                                    }
                                }
                                //-- box De Boton --

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(40.dp)
                                        .height(90.dp)

                                ) {
                                    var state by rememberSaveable { mutableStateOf(false) }

                                    Checkbox(
                                        checked = state,
                                        onCheckedChange = { state = !state },
                                        modifier = Modifier.padding(
                                            top = 30.dp,
                                            bottom = 30.dp,
                                            start = 10.dp
                                        ),
                                        enabled = true,
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xCE4284F0),
                                            uncheckedColor = Color.Black,
                                            checkmarkColor = Color.Black
                                        )
                                    )
                                }


                            }

                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0x2F435066)
                            )
                        ) {
                            Row(Modifier.fillMaxSize()) {
                                //--Box Image --
                                Box(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .padding(top = 10.dp, end = 10.dp, start = 10.dp)

                                ) {
                                    Image(
                                        painterResource(id = R.drawable.doctora),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .clip(RoundedCornerShape(16.dp))


                                    )
                                }

                                //-- box De Datos --
                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 15.dp)
                                        .width(200.dp)
                                        .height(90.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "Dra. María Sánchez",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Neurología",
                                            color = Color(0xFF504F4F),
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(top = 3.dp, bottom = 5.dp)
                                        )
                                        Text(
                                            text = "cita : 14 / 11 / 2023 A 09:30",
                                            fontSize = 12.sp,
                                            color = Color(0xFF504F4F),
                                            modifier = Modifier.padding(top = 16.dp)
                                        )
                                    }
                                }
                                //-- box De Boton --

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(40.dp)
                                        .height(90.dp)

                                ) {
                                    var state by rememberSaveable { mutableStateOf(false) }

                                    Checkbox(
                                        checked = state,
                                        onCheckedChange = { state = !state },
                                        modifier = Modifier.padding(
                                            top = 30.dp,
                                            bottom = 30.dp,
                                            start = 10.dp
                                        ),
                                        enabled = true,
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xCE4284F0),
                                            uncheckedColor = Color.Black,
                                            checkmarkColor = Color.Black
                                        )
                                    )
                                }


                            }

                        }

                    }
                }

                Text(
                    text = "Mis Medicamentos",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    )
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Column(modifier = Modifier.padding(bottom = 100.dp)) {


                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0x2F435066)
                            )
                        ) {
                            Row(Modifier.fillMaxSize()) {
                                //--Box Image --
                                Box(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(top = 13.dp, end = 10.dp, start = 10.dp)

                                ) {
                                    Image(
                                        painterResource(id = R.drawable.drugs),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(RoundedCornerShape(5.dp))


                                    )
                                }

                                //-- box De Datos --
                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 15.dp)
                                        .width(200.dp)
                                        .height(90.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "Paracetamol",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Hoy , 13:00",
                                            color = Color(0xFF504F4F),
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(top = 3.dp, bottom = 5.dp)
                                        )

                                    }
                                }
                                //-- box De Boton --

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(40.dp)
                                        .height(90.dp)

                                ) {
                                    var state by rememberSaveable { mutableStateOf(false) }

                                    Checkbox(
                                        checked = state,
                                        onCheckedChange = { state = !state },
                                        modifier = Modifier.padding(
                                            top = 15.dp,
                                            bottom = 20.dp,
                                            start = 50.dp
                                        ),
                                        enabled = true,
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xCE4284F0),
                                            uncheckedColor = Color.Black,
                                            checkmarkColor = Color.Black
                                        )
                                    )
                                }


                            }


                        }
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0x2F435066)
                            )
                        ) {
                            Row(Modifier.fillMaxSize()) {
                                //--Box Image --
                                Box(
                                    modifier = Modifier
                                        .size(70.dp)
                                        .padding(top = 13.dp, end = 10.dp, start = 10.dp)

                                ) {
                                    Image(
                                        painterResource(id = R.drawable.drugs),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier
                                            .size(50.dp)
                                            .clip(RoundedCornerShape(5.dp))


                                    )
                                }

                                //-- box De Datos --
                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 15.dp)
                                        .width(200.dp)
                                        .height(90.dp)
                                ) {
                                    Column {
                                        Text(
                                            text = "Amoxicillin",
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "Hoy , 12:00",
                                            color = Color(0xFF504F4F),
                                            fontSize = 14.sp,
                                            modifier = Modifier.padding(top = 3.dp, bottom = 5.dp)
                                        )

                                    }
                                }
                                //-- box De Boton --

                                Box(
                                    modifier = Modifier
                                        .padding(top = 10.dp)
                                        .width(40.dp)
                                        .height(90.dp)

                                ) {
                                    var state by rememberSaveable { mutableStateOf(false) }

                                    Checkbox(
                                        checked = state,
                                        onCheckedChange = { state = !state },
                                        modifier = Modifier.padding(
                                            top = 15.dp,
                                            bottom = 20.dp,
                                            start = 50.dp
                                        ),
                                        enabled = true,
                                        colors = CheckboxDefaults.colors(
                                            checkedColor = Color(0xCE4284F0),
                                            uncheckedColor = Color.Black,
                                            checkmarkColor = Color.Black
                                        )
                                    )
                                }


                            }


                        }


                    }


                }
                //-----Bottom bar --


            }
        },
        bottomBar = {
            BottomAppBar(containerColor = Color(0xCE2268DA)) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.Home,
                            contentDescription = "Icono",
                            tint = Color.Black,
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.Email,
                            contentDescription = "Icono",
                            tint = Color.Black,
                            modifier = Modifier.size(48.dp)
                        )
                    }


                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.DateRange,
                            contentDescription = "Icono",
                            tint = Color.Black,
                            modifier = Modifier.size(48.dp)
                        )
                    }


                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Rounded.Person,
                            contentDescription = "Icono",
                            tint = Color.Black,
                            modifier = Modifier
                                .size(48.dp)
                                .clickable { navigationController.navigate("MenuPrencipal") }
                        )
                    }

                }
            }


        }

    )


}











