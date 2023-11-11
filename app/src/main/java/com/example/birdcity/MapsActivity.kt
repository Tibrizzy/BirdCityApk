package com.example.birdcity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.birdcity.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val joburg = LatLng(-26.05578591886719, 28.003713499659874)
        mMap.addMarker(MarkerOptions().position(joburg).title("Marker in joburg"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(joburg))

        val city = LatLng(-26.02336948204293, 28.01082053828617)
        mMap.addMarker(MarkerOptions().position(city).title("Marker in joburg"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(city))

        val cit = LatLng(-25.884553605427865, 28.30354628095756)
        mMap.addMarker(MarkerOptions().position(cit).title("Marker in joburg"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cit))

        val citty = LatLng(-26.188310867902263, 28.297369480981303)
        mMap.addMarker(MarkerOptions().position(citty).title("Marker in joburg"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(citty))


    }
}