package no.lapp.noforeignland

import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException

public fun fetchJson() {
    val url = "https://www.noforeignland.com/home/api/v1/places/"
    val request = Request.Builder().url(url).build()
    val client = OkHttpClient()
    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            println("Failed to execute")
        }

        override fun onResponse(call: Call, response: Response) {
            val body = response?.body()?.string()
            println(body)

            val gson = GsonBuilder().create()

            val feedPlaceList = gson.fromJson(body, ListFeed::class.java)
        }

    })
}



