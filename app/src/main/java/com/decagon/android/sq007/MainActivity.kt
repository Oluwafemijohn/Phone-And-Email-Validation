package com.decagon.android.sq007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.decagon.android.sq007.RegexValidator.mobileValidate

class MainActivity : AppCompatActivity() {
    //Initialising the id's used
    lateinit var name:EditText
    lateinit var email:EditText
    lateinit var gender:Spinner
    lateinit var phoneNumber:EditText
    private lateinit var errorMessage:TextView
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Assigning value the the id
        name = findViewById(R.id.login_name)
        email = findViewById(R.id.email)
        phoneNumber = findViewById(R.id.phone_number)
        gender = findViewById(R.id.gender)
        errorMessage = findViewById(R.id.error_Message)
        registerButton= findViewById(R.id.register_button)


        // Drop down adapter
        attachSpinner()
        // Start the second Activity
        startSecondActivity()
        //validating the phone numbers
        phoneNumberValidation()
    }


    //Drop adapter function
    private fun attachSpinner(){
        val spinner: Spinner = findViewById(R.id.gender)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                //The array
                R.array.gender_array,
                //item layout design
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter

        }
    }

    //Validating the inputs and starting the next activity
    private fun startSecondActivity(){
        registerButton.setOnClickListener{

            try {
                val nameSend = name.text.toString()
                val emailSend = email.text.toString()
                val phoneNumberSend = phoneNumber.text.toString()
                val genderSend = gender.selectedItem.toString()
                //Checking if the name is empty
                if(TextUtils.isEmpty(nameSend)){
                    name.error = "Enter a name"
                    return@setOnClickListener
                }
                //Checking if the gender is selected
                if(genderSend == "Gender"){
                    errorMessage.visibility = View.VISIBLE
                    return@setOnClickListener
                } else {
                    errorMessage.visibility = View.GONE
                }
                //Validating the email f
                if (!(RegexValidator.checkIsEmailValid(emailSend))){
                    email.error = "Enter a valid email"
                    return@setOnClickListener
                }
                //creating the intent
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra( "Name", nameSend)
                intent.putExtra( "Email", emailSend)
                intent.putExtra( "PhoneNumber", phoneNumberSend)
                intent.putExtra( "Gender", genderSend)
                //Starting the next activity
                startActivity(intent)
            }catch (e: ArithmeticException){
                println(e)
            }
        }
    }
    //phone number validation function
    private fun phoneNumberValidation(){
        val phoneNumberValidation: EditText = findViewById(R.id.phone_number)
        phoneNumberValidation.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (mobileValidate(phoneNumberValidation.text.toString())){
                    registerButton.isEnabled = true
                } else{
                    registerButton.isEnabled = false
                    phoneNumberValidation.error = "Invalid phone number"
                }
            }
        })
    }
}