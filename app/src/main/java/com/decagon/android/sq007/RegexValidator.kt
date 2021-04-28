package com.decagon.android.sq007

import java.util.regex.Matcher
import java.util.regex.Pattern

//object of the regex
object RegexValidator {
    //Phone number validator
    fun mobileValidate(text: String?): Boolean {
        var regexPattern: Pattern = Pattern.compile("^(0|234)((70)|([89][01]))[0-9]{8}\$")
        var regexMatcher: Matcher = regexPattern.matcher(text)
        return regexMatcher.matches()
    }
    //Email validator
    fun checkIsEmailValid(email: String): Boolean =
        email.isNotEmpty() && Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,25}" +
                    ")+"
        ).matcher(email).matches()
}