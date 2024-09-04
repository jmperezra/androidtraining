package com.iesam.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString("key_username", username)
        editor.commit()
    }
}