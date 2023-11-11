package com.example.birdcity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView3: TextView = findViewById(R.id.textView3_awl)
        textView3.setOnClickListener {

            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val textView4: TextView = findViewById(R.id.textView4_rccb)
        textView4.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val textView5: TextView = findViewById(R.id.textView5_srt)
        textView5.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }



        val textView6: TextView = findViewById(R.id.textView6_srb)
        textView6.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val textView7: TextView = findViewById(R.id.textView7_hi)
        textView7.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }


        val textView8: TextView = findViewById(R.id.textView8_cw)
        textView8.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        val textView9: TextView = findViewById(R.id.ss)
        textView8.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
















    }
}