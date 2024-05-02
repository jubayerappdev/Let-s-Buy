package com.creativeitinstitute.letsbuy.data.models

import com.creativeitinstitute.letsbuy.views.register.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthSource {

    fun userRegistration(user: User) : Task<AuthResult>
    fun userLogin(user: User)
    fun userForgetPassword(email: String)

}