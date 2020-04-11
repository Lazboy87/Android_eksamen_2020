package no.lapp.noforeignland.activity


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.place_info.*
import no.lapp.noforeignland.R
import no.lapp.noforeignland.classes.infoAPI.PlacesDescriptionData
import okhttp3.*
import java.io.IOException


class PlaceInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.place_info)


        val id = intent.getStringExtra("id")
        val corX: Double = intent.getDoubleExtra("cordinatesX", 0.0)
        val corY: Double = intent.getDoubleExtra("cordinatesY", 0.0)
        var name = intent.getStringExtra("placename")



        Placename.text = name


        val url = "https://www.noforeignland.com/home/api/v1/place?id=" + id + ""
        println(url)
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()


        // running callback async method to fetch json
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }


            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
                val placesDescriptionData =
                    Gson().fromJson(body, PlacesDescriptionData::class.java)

                val images = placesDescriptionData.place.images.ifEmpty { null }

                val imageurlrandom = images?.random()
                // Desided to not use banner since many of the Api places does not have banner url but have image urls in array in Places
                val imgUrl: String? = imageurlrandom?.servingUrl

                println(imgUrl)






                runOnUiThread {

                    val comments = placesDescriptionData.place.comments.removePrefix("<p>")
                        .removeSuffix("</p>")

                    description.text = comments

                    Picasso.get().load(imgUrl).into(imagePlace)
                }


            }

        })



        imageButtonMAP.setOnClickListener {


            val PLACENAME = "placename"
            val CORDINATES_X = "cordinatesX"
            val CORDINATES_Y = "cordinatesY"


            val intent = Intent(this, MapsActivity::class.java)

            intent.putExtra(CORDINATES_X, corX)
            intent.putExtra(CORDINATES_Y, corY)
            intent.putExtra(PLACENAME, name)

            startActivity(intent)


        }


    }


}




















