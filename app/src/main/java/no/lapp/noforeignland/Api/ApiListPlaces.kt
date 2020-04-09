package no.lapp.noforeignland.Api





import com.google.gson.Gson
import no.lapp.noforeignland.classes.PlacesData
import okhttp3.*
import java.io.IOException

class ApiListPlaces(private var listener : OnAPIResultListener) {


    fun fetchJson() {
        val url = "https://www.noforeignland.com/home/api/v1/places/"
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }


            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
                val placesData = Gson().fromJson(body, PlacesData::class.java)
                listener.onAPISuccess(placesData.features)
            }


        })
    }

}

















