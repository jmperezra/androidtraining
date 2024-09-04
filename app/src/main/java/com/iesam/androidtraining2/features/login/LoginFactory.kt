package com.iesam.androidtraining2.features.login

import com.iesam.androidtraining2.features.login.data.LoginDataRepository
import com.iesam.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesam.androidtraining2.features.login.domain.LoginRepository
import com.iesam.androidtraining2.features.login.domain.SignInUseCase
import com.iesam.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory {

    // Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        LoginMockRemoteDataSource()

    private val loginRepository : LoginRepository = provideLoginDataRepository()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()


    // Métodos de Clase
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository() : LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }
}