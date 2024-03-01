package com.android.hospitaldatamanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android.hospitaldatamanager.navigation.AppNavigation
import com.android.hospitaldatamanager.pantallas.pacientes.mainPaciente
import com.android.hospitaldatamanager.pantallas.pantallaPrincipal.Seleccion

import com.android.hospitaldatamanager.ui.theme.HospitalDataManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HospitalDataManagerTheme {

              AppNavigation()


            }
        }

    }
}