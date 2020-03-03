package com.gubb.cleana.datasource.remote.login

import com.gubb.cleana.core.api.BaseNetworkRequest
import com.gubb.cleana.datasource.entity.UserEntity
import io.reactivex.Single
import javax.inject.Inject

class LoginRequest @Inject constructor() : BaseNetworkRequest<LoginApi>(LoginApi::class.java) {

    fun getUserData(k : String): Single<UserEntity> {
        return makeRequest().getUser(k)
    }
}