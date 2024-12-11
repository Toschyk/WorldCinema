package com.example.worldcinema.common;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.worldcinema.R;



public class LaunchScreen extends AppCompatActivity {
    private static final String PREFS_NAME = "MyPrefs";
    private static final String FIRST_LAUNCH_KEY = "firstLaunch";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);

        // Задержка для показа логотипа
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Переход на экран после задержки
                Intent intent = new Intent(LaunchScreen.this, SignUpScreen.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

        // Проверяем, был ли первый запуск
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isFirstLaunch = prefs.getBoolean(FIRST_LAUNCH_KEY, true);

        if (isFirstLaunch) {
            // Устанавливаем флаг, что приложение уже запускалось
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(FIRST_LAUNCH_KEY, false);
            editor.apply();

            // Задержка для показа LaunchScreen, затем переходим на SignUpScreen
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Переход на экран SignUpScreen
                    Intent intent = new Intent(LaunchScreen.this, SignUpScreen.class);
                    startActivity(intent);
                    finish(); // Закрыть текущую активность
                }
            }, 3000); // Задержка 3 секунды (для показа логотипа)
        } else {
            // Если это не первый запуск, переходим сразу на экран SignInScreen
            Intent intent = new Intent(LaunchScreen.this, SignInScreen.class);
            startActivity(intent);
            finish(); // Закрыть текущую активность
        }
    }
}
