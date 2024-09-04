package com.iesam.androidtraining2.features.login

import android.content.Context
import com.iesam.androidtraining2.features.login.data.LoginDataRepository
import com.iesam.androidtraining2.features.login.data.local.LoginXmlLocalDataSource
import com.iesam.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesam.androidtraining2.features.login.domain.LoginRepository
import com.iesam.androidtraining2.features.login.domain.SaveUsernameUseCase
import com.iesam.androidtraining2.features.login.domain.SignInUseCase
import com.iesam.androidtraining2.features.login.presentation.LoginViewModel

class LoginFactory(private val context: Context) {

    // Atributos de clase
    private val loginMockRemoteDataSource: LoginMockRemoteDataSource =
        LoginMockRemoteDataSource()

    private val loginXmlLocalDataSource: LoginXmlLocalDataSource =
        provideLoginXmlLocalDataSource()

    private val loginRepository: LoginRepository = provideLoginDataRepository()

    private val signInUseCase: SignInUseCase = provideSignInUseCase()

    private val saveUsernameUseCase: SaveUsernameUseCase = provideSaveUsernameUseCase()

    // Métodos de Clase
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase, saveUsernameUseCase)
    }

    private fun provideLoginMockRemoteDataSource(): LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }

    private fun provideLoginDataRepository(): LoginDataRepository {
        return LoginDataRepository(loginXmlLocalDataSource, loginMockRemoteDataSource)
    }

    private fun provideLoginXmlLocalDataSource(): LoginXmlLocalDataSource {
        return LoginXmlLocalDataSource(context)
    }

    private fun provideSignInUseCase(): SignInUseCase {
        return SignInUseCase(loginRepository)
    }

    private fun provideSaveUsernameUseCase(): SaveUsernameUseCase {
        return SaveUsernameUseCase(loginRepository)
    }
}