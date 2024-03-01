package com.android.hospitaldatamanager.Login

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData<Boolean>()

    fun signInWithEmailAndPassword(email: String, password: String, home: () -> Unit) =
        viewModelScope.launch {
            try {
                _loading.value = true // Set loading to true before starting the sign-in process

                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("HomeScreen", "signInWithEmailAndPassword logging in")
                        home.invoke()
                    } else {
                        Log.d(
                            "HomeScreen",
                            "signInWithEmailAndPassword: ${task.exception?.message}"
                        )
                    }

                    _loading.value = false // Set loading to false after sign-in attempt
                }
            } catch (ex: Exception) {
                Log.d("HomeScreen", "signInWithEmailAndPassword: ${ex.message}")
                _loading.value = false // Set loading to false if there is an error
            }
        }

    fun createUserWithEmailAndPassword(email: String, password: String, onResult: (Boolean, String?) -> Unit) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    onResult(true, null)
                } else {
                    val exception = task.exception
                    val errorMessage = exception?.message ?: "Error desconocido"
                    onResult(false, errorMessage)
                }
            }
    }

}

