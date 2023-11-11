package com.example.birdcity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.MediaController
import android.widget.VideoView

class videoss : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private var ourRequestCode: Int=123 //any number

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videoss)
        videoView = findViewById(R.id.videoView)
        // now set up media contoller for the play pause next

        val mediaCollection = MediaController(this)
        mediaCollection.setAnchorView(videoView)
        videoView.setMediaController(mediaCollection)
    }

    fun startVideo(view: View) {
        //starting intent to capture video
        val intent = Intent(MediaStore.ACTION_VIDEO_CAPTURE)
        if(intent.resolveActivity(packageManager)!=null){
            startActivityForResult(intent,ourRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ourRequestCode && resultCode== RESULT_OK){
            //get data from uri
            val videoUri = data?.data
            videoView.setVideoURI(videoUri)
            videoView.start()
        }
    }
}