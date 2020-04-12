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

        ApiListPlaces(this).fetchJson()
        image= findViewById(R.id.imageCompas)
        animateImage()

        dbHandler = DBHandler(this,null,null,1)

    }

    override fun onAPISuccess(placeList: MutableList<Feature>) {

           val PlacesList = dbHandler.getPlaces(this)

        doAsync {
            if (PlacesList.isEmpty()){
                dbHandler.addPlaces(this, placeList)
                println("Places added")
            }



            runOnUiThread {


            Handler().postDelayed({
                val intent = Intent(this, ListPlaces::class.java)
                startActivity(intent)
                finish()
            }, 1000)
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






















