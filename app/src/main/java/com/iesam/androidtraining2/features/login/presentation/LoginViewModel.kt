package com.iesam.androidtraining2.features.login.presentation

import androidx.lifecycle.ViewModel
import com.iesam.androidtraining2.features.login.domain.SignInUseCase

class LoginViewModel(private val signInUseCase: SignInUseCase) : ViewModel() {

    fun validateClicked(userName: String, password: String): Boolean{
        return signInUseCase.invoke(userName, password)
    }
}