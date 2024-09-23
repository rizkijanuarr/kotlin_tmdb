package udemy.lazday.kotlintmdb.data.api

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {

    private val API_KEY = "f61943f5b6b20d337b4f340724cc35ee"

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalUrl = chain.request().url

        val newUrl = originalUrl.newBuilder()
            .addQueryParameter("api_key", API_KEY)
            .build()

        val request = chain.request().newBuilder()
            .url(newUrl)
            .build()

        return chain.proceed(request)
    }
}
