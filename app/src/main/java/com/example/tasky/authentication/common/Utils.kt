package com.example.tasky.authentication.common

class Utils {
    companion object {
        fun isValidEmail(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isValidPassword(password: String): Boolean {
            val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{9,}$"
            return password.matches(passwordPattern.toRegex())
        }

        fun isValidFullName(fullName: String): Boolean {
            return fullName.length in 4..50
        }
    }
}