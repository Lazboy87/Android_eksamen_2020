package no.lapp.noforeignland.Activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler


import android.view.animation.AnimationUtils
import android.widget.ImageView
import no.lapp.noforeignland.Api.OnAPIResultListener


import no.lapp.noforeignland.R
import no.lapp.noforeignland.classes.Feature
import no.lapp.noforeignland.classes.PlacesHolder
import no.lapp.noforeignland.database.DBHandler


class SplashScreen:AppCompatActivity(),OnAPIResultListener {

    private lateinit var image:ImageView
    private lateinit var dbHandler: DBHandler




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        dbHandler = DBHandler(this,null,null,1)


        image= findViewById(R.id.imageCompas)




        animateImage()


    }
    override fun onAPISuccess(placeList: MutableList<Feature>) {

        for (feature in placeList){


        val place= PlacesHolder()
        place.name = feature.properties.name
        place.id = feature.properties.id
        place.coordinates = feature.geometry.coordinates

            dbHandler.addPlaces(this,place)


        }


    }



    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(this,
            R.anim.rotate
        )
        image.animation = rotate

        Handler().postDelayed({
            val intent = Intent(this, ListPlaces::class.java)
            startActivity(intent)
            finish()
        }, 9000)


    }





}









