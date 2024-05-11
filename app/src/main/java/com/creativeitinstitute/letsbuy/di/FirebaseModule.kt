package com.creativeitinstitute.letsbuy.di

import com.creativeitinstitute.letsbuy.data.models.AuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {

    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth{


        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesFirebase(jAuth: FirebaseAuth): AuthService{
        return AuthService(jAuth)
    }


}