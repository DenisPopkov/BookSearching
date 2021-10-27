package ru.popkov.data.net.retrofit

import android.content.Context
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class RetrofitFactory {

    companion object {
        private const val SOCKET_TIMEOUT_EXCEPTION_IN_SECONDS: Long = 60
        private const val DISK_CACHE_SIZE_IN_BYTES: Long = 50 * 1024 * 1024
        private const val CACHE_CHILD_PATH_NAME = "https"

        fun create(context: Context, baseUrl: String, vararg interceptors: Interceptor): Retrofit {
            val okHttpClient = createOkHttpClient(context, *interceptors)
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun createOkHttpClient(context: Context, vararg interceptors: Interceptor): OkHttpClient {
            val file = File(context.cacheDir, CACHE_CHILD_PATH_NAME)
            val cache = Cache(file, DISK_CACHE_SIZE_IN_BYTES)
            return OkHttpClient.Builder()
                .connectTimeout(SOCKET_TIMEOUT_EXCEPTION_IN_SECONDS, TimeUnit.SECONDS)
                .readTimeout(SOCKET_TIMEOUT_EXCEPTION_IN_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(SOCKET_TIMEOUT_EXCEPTION_IN_SECONDS, TimeUnit.SECONDS)
                .cache(cache)
                .apply { interceptors.forEach { addInterceptor(it) } }
                .build()
        }
    }
}