package com.example.e_comm_home_demo_app.util

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response

class HttpHandleIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().headers(getJsonHeader()).build()
        val response: Response?
        response = chain.proceed(request)
        return response
    }

    private fun getJsonHeader(): Headers {
        val builder = Headers.Builder()
        builder.add("apiAuthType", "sha256")
        builder.add("authKey", "bf53b36e65b1051cdffd549fd21d95e7510b73b6ab20ed71ab8ddc2cece0b281")
        builder.add("token", "fFezZY52TuW1A9CvFUG_cN:APA91bF0d9uY7Z4ZZu3iy5e6fDU6iocQ5fKejjzld1Civm0tVfkZsqlczZNNNHxeqmZ2lgW84ebYEaD9Bh9klknZWnUFIpnWCCiPFLjZybqq2VfTMD5WfLhL_X8aev4KDDuu1i4EsqUa")
        builder.add("cookie", "PHPSESSID=3eh434ojv5qia703p9c1h6r5jj; expires=Mon, 10-Jul-2023 08:15:28 GMT; Max-Age=3600; path=/; domain=unitedpharmacy.sa; secure; HttpOnly; SameSite=Lax")
        return builder.build()
    }
}