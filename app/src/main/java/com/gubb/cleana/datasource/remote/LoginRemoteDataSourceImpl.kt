package com.gubb.cleana.datasource.remote

import com.gubb.cleana.data.datasource.ILoginDataSource
import com.gubb.cleana.datasource.entity.mapToDomain
import com.gubb.cleana.datasource.remote.login.LoginRequest
import com.gubb.cleana.domain.model.User
import io.reactivex.Single
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(private val loginRequest: LoginRequest) : ILoginDataSource {

    override fun get(k: String): Single<User> {
        return loginRequest.getUserData(k).map { it.mapToDomain() }
    }
}