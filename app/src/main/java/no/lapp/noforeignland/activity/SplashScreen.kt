package no.lapp.noforeignland.activity



import android.content.Intent
import android.os.AsyncTask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


import android.view.animation.AnimationUtils
import android.widget.ImageView



import no.lapp.noforeignland.R
import no.lapp.noforeignland.api.ApiListPlaces
import no.lapp.noforeignland.api.OnAPIResultListener
import no.lapp.noforeignland.classes.Feature
import no.lapp.noforeignland.classes.PlacesHolder
import no.lapp.noforeignland.database.DBHandler



class SplashScreen:AppCompatActivity(), OnAPIResultListener {

    private lateinit var image:ImageView
    private lateinit var dbHandler: DBHandler




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        dbHandler = DBHandler(this,null,null,1)


        image= findViewById(R.id.imageCompas)

        ApiListPlaces(this).fetchJson()


        animateImage()




    }






    override fun onAPISuccess(placeList: MutableList<Feature>) {


        doAsync {

                for (feature in placeList) {


                    val place = PlacesHolder()
                    place.name = feature.properties.name
                    place.id = feature.properties.id
                    val corValue = feature.geometry.coordinates

                    place.coordinatesX = corValue[0]
                    place.coordinatesY = corValue[1]

                    dbHandler.addPlaces(this, place)
                    println(place.name)

                }
            dbHandler.close()

            runOnUiThread {


            Handler().postDelayed({
                val intent = Intent(this, ListPlaces::class.java)
                startActivity(intent)
                finish()
            }, 2500)
        }}.execute()
    }





    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(this,
            R.anim.rotate
        )

        image.animation = rotate


    }


    class doAsync(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg params: Void?): Void? {
            handler()
            return null
        }
    }
}






















