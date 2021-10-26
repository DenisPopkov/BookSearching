package ru.popkov.data.net.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import ru.popkov.data.exceptions.*

class ServerErrorInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        if (response.isSuccessful.not()) {
            when (response.code) {
                400 -> {
                    throw ServerErrorException()
                }
                404 -> {
                    throw NotFoundException()
                }
                409 -> {
                    throw ServerConflictErrorException()
                }
                422 -> {
                    throw InvalidFieldsException()
                }
                429 -> {
                    throw TooManyRequests()
                }
            }
        }
        return response
    }
}