package com.iesam.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString("key_username", username)
        editor.commit()
    }

    fun deleteUserName(){
        val editor = sharedPref.edit()
        editor.remove("key_username")
        editor.commit()

        //Método habitual en Kotlin
        //Scope Function: apply
        //sharedPref.edit().apply{
        //    remove("key_username")
        //    commit()
        //}
    }
}