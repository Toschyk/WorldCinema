package com.example.worldcinema.common;

import com.example.worldcinema.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignInScreen extends AppCompatActivity {

    private EditText emailField, passwordField;
    private Button signInButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_screen);

        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        signInButton = findViewById(R.id.signInButton);
        signUpButton = findViewById(R.id.signUpButton);

        signInButton.setOnClickListener(v -> onSignInClicked());
        signUpButton.setOnClickListener(v -> startActivity(new Intent(SignInScreen.this, SignUpScreen.class)));
    }

    private void onSignInClicked() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            ErrorDialog.show(this, "Все поля должны быть заполнены.");
            return;
        }

        if (Validator.isValidEmail(email)) {
            ErrorDialog.show(this, "Некорректный формат email.");
            return;
        }

        // Логика авторизации пользователя
        // Если авторизация успешна, переход на MainScreen
        startActivity(new Intent(SignInScreen.this, MainScreen.class));
    }
}
