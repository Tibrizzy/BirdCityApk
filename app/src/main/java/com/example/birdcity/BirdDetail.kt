package com.example.birdcity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.birdcity.model.BirdItem

class BirdDetail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird_detail)

        val selectedBird = intent.getSerializableExtra("selected_bird") as BirdItem

        val birdName= findViewById<TextView>(R.id.bird_title)
        val birdDescription = findViewById<TextView>(R.id.description)
        val birdImage = findViewById<ImageView>(R.id.bird_image_detail)
        val map = findViewById<Button>(R.id.view_on_map)

        val vid = findViewById<Button>(R.id.videbtn)
        val ima = findViewById<Button>(R.id.button2)

        birdName.text = selectedBird.name
        birdDescription.text = selectedBird.description
        map.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
        }

        if (!selectedBird.pictureUrl.isNullOrEmpty()) {
            // Load and display the image using the provided URL
            Glide.with(this)
                .load(selectedBird.pictureUrl)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(29)))
                .into(birdImage)
        } else {
            birdImage.setImageResource(R.drawable.ic_launcher_foreground)
        }

        vid.setOnClickListener {
            val intent = Intent(this, videoss::class.java)
            startActivity(intent)
        }

        ima.setOnClickListener {
            val intent = Intent(this, Camerass::class.java)
            startActivity(intent)
        }
    }
}