package com.decagon.android.sq007

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //data collection
        collectData()
        //make opeation toast
        val myToast = Toast.makeText(applicationContext,"Welcome to your dashboard", Toast.LENGTH_SHORT)
        myToast.show()
    }
    //Recieve and asign the messages
    fun collectData(){
        var intent = intent
        val name =intent.getStringExtra("Name")
        val email =intent.getStringExtra("Email")
        val phoneNumber =intent.getStringExtra("PhoneNumber")
        val gender =intent.getStringExtra("Gender")
        //To find the ids
        var getName = findViewById<TextView>(R.id.getName)
        val getEmail = findViewById<TextView>(R.id.getEmail)
        val getPhoneNumber = findViewById<TextView>(R.id.getPhoneNumber)
        val getGender = findViewById<TextView>(R.id.getGender)
        //To assign the text to the text field
        getName.text = "Name: $name"
        getEmail.text = "Email: $email"
        getPhoneNumber.text = "Contact: $phoneNumber"
        getGender.text = "Gender: $gender"

    }
}