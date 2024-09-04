package com.iesam.androidtraining2.features.login.data

import com.iesam.androidtraining2.features.login.data.remote.LoginMockRemoteDataSource
import com.iesam.androidtraining2.features.login.domain.LoginRepository

class LoginDataRepository(private val remoteDataSource: LoginMockRemoteDataSource) :
    LoginRepository {

    override fun isValid(userName: String, password: String): Boolean {
        return remoteDataSource.validate(userName, password)
    }
}