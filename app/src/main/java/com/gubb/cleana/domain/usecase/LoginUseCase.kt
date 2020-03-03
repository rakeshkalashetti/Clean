package com.gubb.cleana.domain.usecase

import com.gubb.cleana.domain.model.User
import com.gubb.cleana.domain.repository.ILoginRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val iLoginRepository: ILoginRepository) {

    fun get(k : String): Single<User> = iLoginRepository.getUser(k)
}