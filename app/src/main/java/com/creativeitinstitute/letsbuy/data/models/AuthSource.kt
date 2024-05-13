package com.creativeitinstitute.letsbuy.data.models


import com.creativeitinstitute.letsbuy.views.login.UserLogin
import com.creativeitinstitute.letsbuy.views.register.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {

    fun userRegistration(user: UserRegister) : Task<AuthResult>
    fun userLogin(user: UserLogin) : Task<AuthResult>
    fun createUser(user: UserRegister) :Task<Void>

}