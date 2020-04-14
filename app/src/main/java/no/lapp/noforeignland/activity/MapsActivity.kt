package no.lapp.noforeignland.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import no.lapp.noforeignland.R

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val corX: Double = intent.getDoubleExtra("cordinatesX", 0.0)
        val corY: Double = intent.getDoubleExtra("cordinatesY", 0.0)

        var place = LatLng(corY, corX)
        var name = intent.getStringExtra("placename")

        val zoomLvl=CameraUpdateFactory.zoomTo(10.0f)


        mMap.addMarker(MarkerOptions().position(place).title(name))
        mMap.moveCamera(zoomLvl)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(place))


    }


}







