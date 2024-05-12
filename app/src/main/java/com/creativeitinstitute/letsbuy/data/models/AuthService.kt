package com.creativeitinstitute.letsbuy.data.models

import com.creativeitinstitute.letsbuy.views.login.UserLogin
import com.creativeitinstitute.letsbuy.views.register.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthService @Inject constructor(private val jAuth: FirebaseAuth) : AuthSource {
    override fun userRegistration(user: User) : Task<AuthResult> {


      return  jAuth.createUserWithEmailAndPassword(user.email, user.password)


    }

    override fun userLogin(user: UserLogin) : Task<AuthResult> {
       return jAuth.signInWithEmailAndPassword(user.email, user.password)
    }


    override fun userForgetPassword(email: String) {

    }
}