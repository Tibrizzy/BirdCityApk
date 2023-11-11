package com.example.birdcity.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.birdcity.LoginActivity
import com.example.birdcity.R
import com.example.birdcity.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class ForgetPassword : AppCompatActivity() {
    private val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)


        val logintext: TextView = findViewById(R.id.back_log)
        logintext.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


        val emailEditText = findViewById<EditText>(R.id.reset_email)
        val button =findViewById<Button>(R.id.reset_btn)



        button.setOnClickListener{
            val email = emailEditText.text.toString().trim()
            if(email.isNotEmpty()){
                sendEmail(email)
            }else{
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
            }
        }

    }
    private fun sendEmail(email : String){

        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Password reset email sent successfully
                    Toast.makeText(this, "Password reset email sent", Toast.LENGTH_SHORT).show()
                    // Navigate back to login page
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Password reset email send failed
                    Toast.makeText(this, "Failed to send password reset email", Toast.LENGTH_SHORT).show()
                }
            }


    }
}