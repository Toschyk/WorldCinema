package com.example.worldcinema.common;

import android.util.Patterns;

public class Validator {
    public static boolean isValidEmail(String email) {
        return !Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
