package com.iesam.androidtraining2.features.login.data.local

import android.content.Context

class LoginXmlLocalDataSource (private val context: Context) {

    val sharedPref = context.getSharedPreferences("username.xml", Context.MODE_PRIVATE)

    private val keyUsername = "key_username"

    fun saveUsername(username: String){
        val editor = sharedPref.edit()
        editor.putString(keyUsername, username)
        editor.commit()
    }

    fun deleteUserName(){
        val editor = sharedPref.edit()
        editor.remove(keyUsername)
        editor.commit()

        //Método habitual en Kotlin
        //Scope Function: apply
        //sharedPref.edit().apply{
        //    remove("key_username")
        //    commit()
        //}
    }

    fun getUsername(): String? {
        return sharedPref.getString(keyUsername, null)
    }
}