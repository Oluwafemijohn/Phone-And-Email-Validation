package com.decagon.android.sq007

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    companion  object {
        private const val NAME = "Oluwafemi"
        private const val EMAIL = "femiogundipe01@gmail.com"
        private const val PHONENUMBER = "08030675563"
        private const val GENDER = "Male"

        private const val GETNAME = "Name: Oluwafemi"
        private const val GETEMAIL = "Email: femiogundipe01@gmail.com"
        private const val GETPHONENUMBER = "Contact: 08030675563"
        private const val GETGENDER = "Gender: Male"
    }

    @get:Rule val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    //Test activity view visibility
    @Test
    fun test_isActivityInView() {
        onView( withId(R.id.first_activity)).check(matches(isDisplayed()))
    }
    //Test name EditText visibility
    @Test
    fun test_visibility_name_editText() {
        onView(withId(R.id.login_name)).check(matches(isDisplayed()))
    }
    //Test email EditText visibility
    @Test
    fun test_visibility_email_editText() {
        onView(withId(R.id.email)).check(matches((isDisplayed())))
    }
    //Test phone number EditText visibility
    @Test
    fun test_visibility_phoneNumber_editText() {
        onView(withId(R.id.phone_number)).check(matches(isDisplayed()))
    }
    //Test spinner view visibility
    @Test
    fun test_visibility_spinner_downDrop() {
        onView(withId(R.id.gender)).check(matches(isDisplayed()))
    }
    //Test button visibility
    @Test
    fun test_button_visibility() {
        onView(withId(R.id.register_button)).check(matches(isDisplayed()))
    }

    // To test registration
    @Test
    fun test_login_process() {
        //Test if the name, email and phone number EditText fields are there
        onView(withId(R.id.login_name)).perform(replaceText(NAME))
        onView(withId(R.id.email)).perform(replaceText(EMAIL))
        onView(withId(R.id.phone_number)).perform(replaceText(PHONENUMBER))

        //To select an item from the spinner
        onView(withId(R.id.gender)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        onView(withId(R.id.gender)).check(matches(withSpinnerText(containsString(GENDER))))

        //CLick the register button
        onView(withId(R.id.register_button)).perform(click())

        //Test the view of the second activity
        onView(withId(R.id.getName)).check(matches(isDisplayed()))
        onView(withId(R.id.getEmail)).check(matches(isDisplayed()))
        onView(withId(R.id.getPhoneNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.getGender)).check(matches(isDisplayed()))

        //Test the content of the text field of the second activity
        onView(withId(R.id.getName)).check(matches(withText(GETNAME)))
        onView(withId(R.id.getEmail)).check(matches(withText(GETEMAIL)))
        onView(withId(R.id.getPhoneNumber)).check(matches(withText(GETPHONENUMBER)))
        onView(withId(R.id.getGender)).check(matches(withText(GETGENDER)))
    }
}