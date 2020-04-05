package no.lapp.noforeignland.api


import com.google.gson.GsonBuilder
import no.lapp.noforeignland.classes.PlacesData
import okhttp3.*
import java.io.IOException

 interface ApiListPlaces{


     fun fetchJson() {
    val url = "https://www.noforeignland.com/home/api/v1/places/"
    val request = Request.Builder().url(url).build()
    val client = OkHttpClient()


    client.newCall(request).enqueue(object: Callback {
        override fun onFailure(call: Call, e: IOException) {
            TODO("Not yet implemented")
        }


        override fun onResponse(call: Call, response: Response) {
            val body = response?.body()?.string()
            println(body)

            val gson = GsonBuilder().create()

            val placList = gson.fromJson(body,PlacesData::class.java)



            println(placList)



        }

    })
}
}

















