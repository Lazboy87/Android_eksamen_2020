package no.lapp.noforeignland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import okhttp3.*
import java.io.IOException


class SplashScreen : AppCompatActivity() {

    private lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        image= findViewById(R.id.imageCompas)

        fetchJson()
        newPlacetoDB()
        animateImage()



    }




    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate)
        image.animation = rotate

        Handler().postDelayed({
            val intent = Intent(this,ListPlaces::class.java)
            startActivity(intent)
            finish()
        }, 6000)
    }

 fun newPlacetoDB() {
        val dbHandler = DBHandler(this, null, null, 1)

       val id = 1247533475347
        val placeName = "fawefawfoo"
        val description = "cursoefwefr.getString(2)"
        val imageUrl = "cursor.getString(3)"
        val cordinatesX = 23141235125
        val cordinatesY = 42341234532

        val place = Places(
            id.toInt(),
            placeName,
            description,
            imageUrl,
            cordinatesX.toInt(),
            cordinatesY.toInt()
        )

        dbHandler.addPLaces(place)

       Toast.makeText(this, "Conection Success", Toast.LENGTH_SHORT).show()


    }



}

