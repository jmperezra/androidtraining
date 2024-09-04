package com.iesam.androidtraining2.features.login.data.remote

class LoginMockRemoteDataSource {

    private val username = "android"
    private val password = "12345"

    fun validate(userName: String, password: String): Boolean {
        return ((this.username == userName)
                && (this.password == password))
    }
}