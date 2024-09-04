package com.iesam.androidtraining2.features.login

import com.iesam.androidtraining2.features.login.domain.SignInUseCase
import com.iesam.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory {

    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }

    fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase()
    }
}