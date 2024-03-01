package com.android.hospitaldatamanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.hospitaldatamanager.CROD.DoctorCROD.BorarDoctor
import com.android.hospitaldatamanager.CROD.DoctorCROD.MenuDoctor
import com.android.hospitaldatamanager.CROD.MenuPrencipal
import com.android.hospitaldatamanager.CROD.PacienteCROD.BorarPaciente
import com.android.hospitaldatamanager.CROD.PacienteCROD.MenuPaciente
import com.android.hospitaldatamanager.CROD.PacienteCROD.ModificarPaciente
import com.android.hospitaldatamanager.pantallas.doctores.ModificarDoctor
import com.android.hospitaldatamanager.pantallas.doctores.RegistroDoctores
import com.android.hospitaldatamanager.pantallas.doctores.RegistroDoctoresEn
import com.android.hospitaldatamanager.pantallas.pacientes.RegistroPasientes
import com.android.hospitaldatamanager.pantallas.pacientes.RegistroPasientesEn
import com.android.hospitaldatamanager.pantallas.pacientes.mainPaciente
import com.android.hospitaldatamanager.pantallas.pantallaPrincipal.Seleccion
import com.android.hospitaldatamanager.pantallas.pantallaPrincipal.SeleccionEn
import com.android.hospitaldatamanager.pantallas.pantallaPrincipal.main_App
import com.android.hospitaldatamanager.pantallas.pantallaPrincipal.main_AppEn
import com.androuid.jetpackcomposeinstagram.iniciar_sesion
import com.androuid.jetpackcomposeinstagram.iniciar_sesionEn

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.main_App.ruta)
    {
        composable(AppScreens.main_App.ruta) { main_App(navigationController) }
        composable(AppScreens.main_AppEn.ruta) { main_AppEn(navigationController) }
        composable(AppScreens.iniciar_sesionEn.ruta) { iniciar_sesionEn(navigationController) }
        composable(AppScreens.iniciar_sesion.ruta) { iniciar_sesion(navigationController) }
        composable(AppScreens.RegistroDoctores.ruta) { RegistroDoctores(navigationController) }
        composable(AppScreens.RegistroDoctoresEn.ruta) { RegistroDoctoresEn(navigationController) }
        composable(AppScreens.RegistroPacientes.ruta) { RegistroPasientes(navigationController) }
        composable(AppScreens.RegistroPacientesEn.ruta) { RegistroPasientesEn(navigationController) }
        composable(AppScreens.SeleccionEn.ruta) { SeleccionEn(navigationController) }
        composable(AppScreens.Seleccion.ruta) { Seleccion(navigationController) }
        composable(AppScreens.mainPaciente.ruta) { mainPaciente(navigationController) }
        composable(AppScreens.MenuPrencipal.ruta) { MenuPrencipal(navigationController) }
        composable(AppScreens.MenuDoctor.ruta) { MenuDoctor(navigationController) }
        composable(AppScreens.BorarDoctor.ruta) { BorarDoctor(navigationController) }
        composable(AppScreens.MenuPaciente.ruta) { MenuPaciente(navigationController) }
        composable(AppScreens.BorarDoctor.ruta) { BorarDoctor(navigationController) }
        composable(AppScreens.ModificarDoctor.ruta) { ModificarDoctor(navigationController) }
        composable(AppScreens.BorarPaciente.ruta) { BorarPaciente(navigationController) }
        composable(AppScreens.ModificarPaciente.ruta) { ModificarPaciente(navigationController) }



    }
}