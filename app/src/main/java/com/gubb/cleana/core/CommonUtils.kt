package com.gubb.cleana.core

import android.content.Context
import android.text.TextUtils
import android.util.Patterns
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * Created by Vishakha Gahukar on 2/12/19.
 * Email : vishakha.gahukar@neosofttech.com
 */
class CommonUtils(context: Context) {

    var context: Context? = null

    init {
        this.context = context
    }

    companion object {
        fun isEmailValid(email: String?): Boolean {
            return !TextUtils.isEmpty(email)
        }

        fun isPasswordValid(password: String?): Boolean {
            return password!!.length >= 3
        }

        fun isFieldEmpty(field: String): Boolean {
            return field.isNullOrEmpty()
        }
    }


    fun isEmailValidTest(email: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val EMAIL_PATTERN = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
//        val EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
        pattern = Pattern.compile(EMAIL_PATTERN)
        matcher = pattern.matcher(email)
        return matcher.matches()
//        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun dateToStringFormat(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm a")
        val currentDate = sdf.format(Date())
        return currentDate
    }

    private fun getFormattedDate(date: String): Date {
        val f: DateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm a")
        return f.parse(date)
    }
}