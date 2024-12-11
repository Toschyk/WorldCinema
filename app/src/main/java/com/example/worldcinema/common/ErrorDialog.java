package com.example.worldcinema.common;

import android.app.AlertDialog;
import android.content.Context;

public class ErrorDialog {
    public static void show(Context context, String message) {
        new AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
