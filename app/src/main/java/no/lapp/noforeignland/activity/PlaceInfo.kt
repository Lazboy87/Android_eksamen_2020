package no.lapp.noforeignland.activity


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.place_info.*

import no.lapp.noforeignland.R
import no.lapp.noforeignland.classes.infoAPI.PlacesDescriptionData
import okhttp3.*
import java.io.IOException


class PlaceInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_info)






        val id =intent.getLongExtra("id",0).toString()
        println(id)


        val url = "https://www.noforeignland.com/home/api/v1/place?id="+id+""
        println(url)
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }


            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
                val placesDescriptionData = Gson().fromJson(body, PlacesDescriptionData::class.java)
                println(placesDescriptionData)

                runOnUiThread {
                    Placename.text = placesDescriptionData.place.name

                    description.text = placesDescriptionData.place.comments.removePrefix("<p>").removeSuffix("</p>")




                }




            }

        })




}








}




