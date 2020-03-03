package com.gubb.cleana.core.api
import retrofit2.Retrofit


abstract class BaseNetworkRequest<T>(private val baseUrl: String, private var clazz: Class<T>) {

    constructor(clazz: Class<T>) : this("https://api.github.com/", clazz)

    protected fun makeRequest(): T {
        return makeRetrofitService(baseUrl).create(this.clazz)
    }

    private fun makeRetrofitService(baseUrl: String): Retrofit {
        return RetrofitManager.getInstance().makeRetrofit(baseUrl)
    }

}