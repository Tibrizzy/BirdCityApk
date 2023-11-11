package com.example.birdcity

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView


class Camerass : AppCompatActivity() {

 private var our_request_code : Int=123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camerass)
    }


    fun takePhoto(view: View) {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if(intent.resolveActivity(packageManager)!=null){
            startActivityForResult(intent,our_request_code)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == our_request_code && resultCode == RESULT_OK){
            //if the result is ok and the request is equal to request code
            val imageView : ImageView = findViewById(R.id.image)
            //start bitmap
            val bitmap = data?.extras?.get("data") as Bitmap
            //set image bitmap
            imageView.setImageBitmap(bitmap)
        }
    }
}