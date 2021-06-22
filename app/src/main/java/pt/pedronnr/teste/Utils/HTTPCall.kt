package pt.pedronnr.teste.Utils

import android.os.AsyncTask
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray

class HTTPCall : AsyncTask<String?, Void?, String>() {

    override fun doInBackground(vararg url: String?): String? {
        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts")
            .build()
        client.newCall(request).execute().use { response ->
            return response.body?.string()
        }
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        var postList = JSONArray(result)
        for (i in 0 until postList.length()) {

            var post = Post().ImportJson(postList.getJSONObject(i))
            println(post.title)
        }
    }
}