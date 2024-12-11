package com.example.worldcinema.common;

import com.example.worldcinema.R;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpScreen extends AppCompatActivity {

    private EditText emailField, passwordField, confirmPasswordField;
    private Button signUpButton, signInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_screen);

        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        signUpButton = findViewById(R.id.signUpButton);
        signInButton = findViewById(R.id.signInButton);

        signUpButton.setOnClickListener(v -> onSignUpClicked());
        signInButton.setOnClickListener(v -> startActivity(new Intent(SignUpScreen.this, SignInScreen.class)));
    }

    private void onSignUpClicked() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            ErrorDialog.show(this, "Все поля должны быть заполнены.");
            return;
        }

        if (Validator.isValidEmail(email)) {
            ErrorDialog.show(this, "Некорректный формат email.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            ErrorDialog.show(this, "Пароли не совпадают.");
            return;
        }

        // Логика регистрации пользователя
        // Если регистрация прошла успешно, переход на MainScreen
        startActivity(new Intent(SignUpScreen.this, MainScreen.class));
    }
}
