package com.gubb.cleana.data.repository

import com.gubb.cleana.data.datasource.ILoginDataSource
import com.gubb.cleana.domain.model.User
import com.gubb.cleana.domain.repository.ILoginRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginDataSource: ILoginDataSource) : ILoginRepository {

    override fun getUser(k: String): Single<User> {
        return loginDataSource.get(k)
    }

    override fun getRepository(name: String) {

    }
}