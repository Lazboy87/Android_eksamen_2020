package no.lapp.noforeignland

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {

    private lateinit var image:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
image= findViewById(R.id.imageCompas)

        animateImage()


    }

    private fun animateImage() {
        val rotate = AnimationUtils.loadAnimation(this,R.anim.rotate)
        image.animation = rotate

        Handler().postDelayed({
            val intent = Intent(this,ListPlaces::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}
