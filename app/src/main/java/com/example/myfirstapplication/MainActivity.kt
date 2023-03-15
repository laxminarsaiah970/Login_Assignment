package com.example.myfirstapplication

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email=findViewById<TextInputEditText>(R.id.emailEditText)
        val password:TextInputEditText=findViewById(R.id.passwordEditText)
        val signInBtn=findViewById<Button>(R.id.submitButton)

                 signInBtn.setOnClickListener()
                 {
                     var msg:String
                      if(!isEmailValid(email.text.toString()) && !isPasswordValid(password.text.toString()))
                      {
                          msg="Enter Correct Email and Password"
                      }
                     else if(!isEmailValid(email.text.toString()) && isPasswordValid(password.text.toString()))
                          {
                             msg="Enter Correct Email "
                          }
                      else if(isEmailValid(email.text.toString()) && !isPasswordValid(password.text.toString()))
                      {
                          msg="Enter Correct Password"
                      }
                      else{
                          msg="user Successfully Login"
                      }
                     Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
                 }


         }
        fun isEmailValid(email: String):Boolean
        {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(password:String):Boolean
        {


           val passwordPattern :String = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"

           return Pattern.compile(passwordPattern).matcher(password).matches()

        }


    }
