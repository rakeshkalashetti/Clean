package com.gubb.cleana.domain.repository

import com.gubb.cleana.domain.model.User
import io.reactivex.Single

interface ILoginRepository {

    fun getUser(k : String): Single<User>

    fun getRepository(name: String)
}