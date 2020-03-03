package com.gubb.cleana.presenter.ui.login

import com.gubb.cleana.data.datasource.ILoginDataSource
import com.gubb.cleana.data.repository.LoginRepositoryImpl
import com.gubb.cleana.datasource.remote.LoginRemoteDataSourceImpl
import com.gubb.cleana.domain.repository.ILoginRepository
import dagger.Binds
import dagger.Module

@Module
abstract class LoginModule {

    @Binds
    abstract fun provideLoginDataSource(remote: LoginRemoteDataSourceImpl): ILoginDataSource

    @Binds
    abstract fun provideLoginRepository(source: LoginRepositoryImpl): ILoginRepository
}