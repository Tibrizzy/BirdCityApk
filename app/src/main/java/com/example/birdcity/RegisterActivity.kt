package com.example.birdcity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val logintext: TextView = findViewById(R.id.textView_login)
        logintext.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val registerButton: Button = findViewById(R.id.button_logs)
        registerButton.setOnClickListener { performSignUp() }


    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.editTextText_Email_register)
        val password = findViewById<EditText>(R.id.editTextTextPassword_register)

        if(email.text.isEmpty()||password.text.isEmpty()){
            Toast.makeText(this,"Please fill all fields",Toast.LENGTH_SHORT)
                .show()
            return
        }

        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Moving in to the home page

                    val intent = Intent(this,BirdList::class.java)
                    startActivity(intent)
                    Toast.makeText(
                        baseContext,
                        "Success.",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this,"error occurred ${it.localizedMessage}",Toast.LENGTH_SHORT)
                    .show()
            }
    }
}