package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var EditText: EditText
    private lateinit var EditText2: EditText
    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EditText = findViewById(R.id.EditText)
        EditText2 = findViewById(R.id.EditText2)
        Button = findViewById(R.id.Button)



        Button.setOnClickListener {
            val email = EditText.text.toString()
            val password = EditText2.text.toString()



            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "E-mail or Password is Empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {task ->
                    if(task.isSuccessful){
                        FirebaseAuth.getInstance().currentUser?.sendEmailVerification()?.addOnSuccessListener {
                             }
                            finish()

                        } else {
                            Toast.makeText(this, "E-mail or Password is Empty", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
            }
        }
    }





