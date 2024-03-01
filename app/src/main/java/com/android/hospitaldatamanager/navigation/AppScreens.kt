package com.android.hospitaldatamanager.navigation

sealed class AppScreens(val ruta: String) {

    object RegistroDoctores : AppScreens("RegistroDoctores")
    object RegistroDoctoresEn : AppScreens("RegistroDoctoresEn")
    object RegistroPacientes : AppScreens("RegistroPacientes")
    object RegistroPacientesEn : AppScreens("RegistroPacientesEn")
    object iniciar_sesion : AppScreens("iniciar_sesion")
    object iniciar_sesionEn : AppScreens("iniciar_sesionEn")
    object SeleccionEn : AppScreens("SeleccionEn")
    object Seleccion : AppScreens("Seleccion")
    object main_App : AppScreens("main_App")
    object main_AppEn : AppScreens("main_AppEn")
    object mainPaciente : AppScreens("mainPaciente")
    object MenuPrencipal : AppScreens("MenuPrencipal")
    object MenuDoctor : AppScreens("MenuDoctor")
    object ModificarDoctor : AppScreens("ModificarDoctor")
    object BorarDoctor : AppScreens("BorarDoctor")
    object MenuPaciente : AppScreens("MenuPaciente")
    object  BorarPaciente : AppScreens("BorarPaciente")
    object  ModificarPaciente : AppScreens("ModificarPaciente")





}