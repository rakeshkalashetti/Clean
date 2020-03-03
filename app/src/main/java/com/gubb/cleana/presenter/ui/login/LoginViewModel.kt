package com.gubb.cleana.presenter.ui.login

import android.text.TextUtils
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gubb.cleana.core.utilities.CommonUtils
import com.gubb.cleana.domain.usecase.LoginUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    val enableButton = ObservableBoolean()
    val isEmailValid = MutableLiveData<Boolean>()

    val loginSuccessful = MutableLiveData<Boolean>()

    var details: ObservableField<String> = ObservableField()

    var emailAddress: ObservableField<String> = ObservableField()

    fun validateEmail(text: CharSequence) {
        isEmailValid.value = CommonUtils.isFieldEmpty(text.toString())
        if (!TextUtils.isEmpty(text)) {
            enableButton.set(true)
        } else {
            enableButton.set(false)
        }
    }

    fun login() {
        getUserData()
    }

    private fun getUserData() = addCompositeDisposable(loginUseCase.get(emailAddress.get()!!)
            .doOnSubscribe { }
            .subscribeOn(Schedulers.io())
            .map {
                loginSuccessful.postValue(true)
                var stringBuilder = StringBuilder()
                stringBuilder.append("Login : ").append(it.login).append("\n")
                        .append("Profile Url : ").append(it.avatarUrl).append("\n")
                        .append("Public Repo: ").append(it.publicRepo)
                details.set(stringBuilder.toString())
            }
            .subscribe({
                Log.e("TextNS", "Success api response : ")
            }, {
                Log.e("TextNS", "Failure api response : " + it.message)
            })
    )

    private val compositeDisposable = CompositeDisposable()


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun addCompositeDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}