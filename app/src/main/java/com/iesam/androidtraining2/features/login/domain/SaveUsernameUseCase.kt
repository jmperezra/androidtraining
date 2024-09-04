package com.iesam.androidtraining2.features.login.domain

class SaveUsernameUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(userName: String){
        loginRepository.saveUsername(userName)
    }

}