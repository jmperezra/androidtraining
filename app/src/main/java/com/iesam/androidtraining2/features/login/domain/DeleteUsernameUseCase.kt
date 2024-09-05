package com.iesam.androidtraining2.features.login.domain

class DeleteUsernameUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(){
        loginRepository.deleteUsername()
    }

}