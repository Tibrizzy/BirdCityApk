package com.example.birdcity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.birdcity.adapter.BirdListAdapter

class BirdList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird_list)

        val recyclerView = findViewById<RecyclerView>(R.id.birds_recyclerview)
        val settings = findViewById<ImageView>(R.id.settings_icon)

        settings.setOnClickListener{
            startActivity(Intent(this,Settings::class.java))
        }

        val adapter = BirdListAdapter(this) { birdItem ->
            // Handle item click here
            val intent = Intent(this, BirdDetail::class.java)
            intent.putExtra("selected_bird", birdItem)
            startActivity(intent)
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
}
