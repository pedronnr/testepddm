package pt.pedronnr.teste.Webservices

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitExample {

    fun getPosts() {
        val BASE_URL = "http://jsonplaceholder.typicode.com"
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PostService::class.java)
        val call = service.getAllPosts()

        call.enqueue(object : Callback<List<RetroPost>> {
            override fun onResponse(
                call: Call<List<RetroPost>>,
                response: Response<List<RetroPost>>
            ) {
                if (response.code() == 200) {
                    val retroFit2 = response.body()
                    print("123")
                }
            }

            override fun onFailure(calll: Call<List<RetroPost>>, t: Throwable) {
                print("error")
            }
        })
    }
}