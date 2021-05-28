package com.decagon.android.sq007

import com.decagon.android.sq007.RegexValidator.checkIsEmailValid
import com.google.common.truth.Truth
import org.junit.Test

class  RegexValidatorTest{
    //Testing  the phone validator
    @Test
    fun validateCorrectNumber1(){
        val samplePhoneNumber = "08130675563"
        val validator = RegexValidator.mobileValidate(samplePhoneNumber)
        Truth.assertThat(validator).isTrue()
    }
    //Testing the method with correct phone number
    @Test
    fun validateCorrectNumber2(){
        val samplePhoneNumber2 = "2348130675563"
        val validator = RegexValidator.mobileValidate(samplePhoneNumber2)
        Truth.assertThat(validator).isTrue()
    }
    //Testing the method with correct phone number
    @Test
    fun validateCorrectNumber3(){
        val wrongNumber = "08030675563"
        val validator = RegexValidator.mobileValidate(wrongNumber)
        Truth.assertThat(validator).isEqualTo( true)
    }
    @Test
    fun validateCorrectNumber4(){
        val samplePhoneNumber2 = "08180675563"
        val validator = RegexValidator.mobileValidate(samplePhoneNumber2)
        Truth.assertThat(validator).isTrue()
    }
    //Testing the method with correct phone number
    @Test
    fun validatorWrongNumber1(){
        val wrongNumber = "23448130675563"
        val validator = RegexValidator.mobileValidate(wrongNumber)
        Truth.assertThat(validator).isEqualTo( false)
    }
    //Testing the method with correct phone number
    @Test
    fun validatorWrongNumber2(){
        val wrongNumber = "081306755639"
        val validator = RegexValidator.mobileValidate(wrongNumber)
        Truth.assertThat(validator).isFalse()
    }
    //Testing the method with correct email
    @Test
    fun validateEmailCaseOne(){
        val correctEmail = "femiogundipe01@gmail.com"
        val validator = checkIsEmailValid(correctEmail)
        Truth.assertThat(validator).isEqualTo( true)
    }
    //Testing the method with incorrect email
    @Test
    fun validateEmailCaseTwo(){
        val invalidEmail = "femiogundipe01@gmail."
        val validator = checkIsEmailValid(invalidEmail)
        Truth.assertThat(validator).isEqualTo( false)
    }
    //Testing the method with incorrect email
    @Test
    fun validateEmailCaseThree(){
        val invalidEmail1 = "femiogundipe01@gmailcom"
        val validator = checkIsEmailValid(invalidEmail1)
        Truth.assertThat(validator).isEqualTo( false)
    }
    //Testing the method with incorrect email
    @Test
    fun validateEmailCaseFour(){
        val invalidEmail2 = "femiogundipe01@gmailcom"
        val validator = checkIsEmailValid(invalidEmail2)
        Truth.assertThat(validator).isFalse()
    }
    //Testing the method with incorrect email
    @Test
    fun validateEmailCaseFive(){
        val invalidEmail3 = "femiogundipe01gmail.com"
        val validator = checkIsEmailValid(invalidEmail3)
        Truth.assertThat(validator).isFalse()
    }
    //Testing the method with incorrect email
    @Test
    fun validateEmailCaseSive(){
        val invalidEmail4 = "femiogundipe01gmail.com"
        val validator = checkIsEmailValid(invalidEmail4)
//        Truth.assertThat(validator).isEqualTo( false)
        Truth.assertThat(validator).isFalse()
    }
}