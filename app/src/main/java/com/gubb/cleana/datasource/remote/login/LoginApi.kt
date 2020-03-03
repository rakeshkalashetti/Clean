package com.gubb.cleana.datasource.remote.login

import com.gubb.cleana.datasource.entity.UserEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface LoginApi {

    @GET("users/{login}")
    fun getUser(@Path("login") login: String): Single<UserEntity>
}