package pt.pedronnr.teste.Webservices

import okhttp3.OkHttpClient
import okhttp3.Request

class OkHttpExample {

    fun testHttpClient() {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .build()

        client.newCall(request).execute().use { response -> response.body?.string() }
    }
}