package com.gubb.cleana.data.datasource

import com.gubb.cleana.datasource.entity.UserEntity
import com.gubb.cleana.domain.model.User
import io.reactivex.Single

interface ILoginDataSource {

    fun get(k: String): Single<User>

}