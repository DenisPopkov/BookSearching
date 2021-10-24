package ru.popkov.data.net.retrofit

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor
import ru.popkov.data.BuildConfig

object LoggingInterceptorFactory {

    fun create(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor {
            if (BuildConfig.DEBUG) Log.i("OkHTTP", it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }
}