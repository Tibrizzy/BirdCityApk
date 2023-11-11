package com.example.birdcity

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

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val registertext: TextView = findViewById(R.id.textView_login)
        registertext.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        val loginButton: Button = findViewById(R.id.button_logs)
        loginButton.setOnClickListener { performLogin() }
    }

    private fun performLogin() {
       //getting input from user
        val email:EditText = findViewById(R.id.editTextText_Email_register)
        val password:EditText = findViewById(R.id.editTextTextPassword_register)

        //null checks on input
                if(email.text.isEmpty()|| password.text.isEmpty()){
                    Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT)
                        .show()
                    return
                }
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.signInWithEmailAndPassword(inputEmail, inputPassword )
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
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
                Toast.makeText(
                    baseContext,
                    "Authentication failed.${it.localizedMessage}",
                    Toast.LENGTH_SHORT,
                ).show()
            }
    }
}