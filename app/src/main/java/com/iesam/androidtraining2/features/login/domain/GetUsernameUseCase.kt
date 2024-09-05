package com.iesam.androidtraining2.features.login.domain

class GetUsernameUseCase (private val loginRepository: LoginRepository) {

    operator fun invoke(): String? {
        return loginRepository.getUsername()
    }

}