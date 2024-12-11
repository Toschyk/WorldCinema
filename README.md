# Задания

Сессия 1 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%201.md

Сессия 2 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%202.md

Сессия 3 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%203.md

Сессия 4 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%204.md

Сессия 5 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%205.md

Сессия 6 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A1%D0%B5%D1%81%D1%81%D0%B8%D1%8F%206.md

# Решения

Сессия 1 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%201.md

Сессия 2 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%202.md

Сессия 3 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%203.md

Сессия 4 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%204.md

Сессия 5 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%205.md

Сессия 6 https://github.com/Toschyk/WorldCinema/blob/master/%D0%A0%D0%B5%D1%88%D0%B5%D0%BD%D0%B8%D0%B5%20%D0%BA%20%D1%81%D0%B5%D1%81%D1%81%D0%B8%D0%B8%206.md









Для реализации этого функционала на Java, с использованием **Android SDK**, можно разделить задачу на несколько частей. Я объясню, как создать проект, настроить интерфейсы, реализовать экраны и логику валидации данных, а также взаимодействие с сервером.

### Шаги реализации:

### 1. **Создание проекта и настройка иконки приложения**

1. **Создание проекта в Android Studio:**
   - Откройте Android Studio, создайте новый проект с шаблоном **Empty Activity**.
   - Укажите имя приложения, выберите язык **Java** и минимальную версию SDK.

2. **Настройка иконки приложения:**
   - Перейдите в папку `res/mipmap`, где находятся папки для разных разрешений иконок (например, `mipmap-hdpi`, `mipmap-mdpi`, `mipmap-xhdpi` и т.д.).
   - Перетащите иконки с нужными размерами в соответствующие папки.
   - Также, иконка должна быть настроена в `AndroidManifest.xml`:

   ```xml
   <application
       android:icon="@mipmap/ic_launcher"
       android:label="Your App Name">
       ...
   </application>
   ```

### 2. **Создание Launch Screen (Экран запуска)**

Для реализации экрана запуска в Android можно использовать **Splash Activity**.

1. **Создайте новую активность `SplashActivity`:**

   - В файле `SplashActivity.java` разместите код для отображения логотипа и текста.

   ```java
   public class SplashActivity extends AppCompatActivity {

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_splash);

           // Задержка перед переходом на следующий экран (например, 2 секунды)
           new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   // Проверка, показывать ли экран регистрации или входа
                   SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                   boolean isFirstLaunch = prefs.getBoolean("isFirstLaunch", true);

                   if (isFirstLaunch) {
                       startActivity(new Intent(SplashActivity.this, SignUpActivity.class));
                       prefs.edit().putBoolean("isFirstLaunch", false).apply();
                   } else {
                       startActivity(new Intent(SplashActivity.this, SignInActivity.class));
                   }

                   finish();
               }
           }, 2000); // 2 секунды
       }
   }
   ```

2. **Создайте разметку `activity_splash.xml`:**
   - Добавьте логотип и текст, используя `ImageView` для логотипа и `TextView` для текста.

   ```xml
   <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent">
       
       <ImageView
           android:id="@+id/logo"
           android:layout_centerInParent="true"
           android:layout_width="200dp"
           android:layout_height="200dp"
           android:src="@drawable/logo" />
       
       <TextView
           android:id="@+id/app_name"
           android:layout_below="@id/logo"
           android:layout_centerHorizontal="true"
           android:text="Your App"
           android:textSize="24sp"
           android:layout_marginTop="20dp"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"/>
   </RelativeLayout>
   ```

### 3. **Создание SignUp Screen (Экран регистрации)**

1. **Создайте активность `SignUpActivity`:**
   - В этой активности будет форма для ввода email, пароля и подтверждения пароля.
   - Добавьте кнопки "Зарегистрироваться" и "У меня уже есть аккаунт".

   ```java
   public class SignUpActivity extends AppCompatActivity {

       private EditText emailEditText, passwordEditText, confirmPasswordEditText;
       private Button signUpButton, signInButton;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_sign_up);

           emailEditText = findViewById(R.id.emailEditText);
           passwordEditText = findViewById(R.id.passwordEditText);
           confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
           signUpButton = findViewById(R.id.signUpButton);
           signInButton = findViewById(R.id.signInButton);

           signUpButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String email = emailEditText.getText().toString().trim();
                   String password = passwordEditText.getText().toString().trim();
                   String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                   if (validateSignUpForm(email, password, confirmPassword)) {
                       // Отправка запроса на сервер для регистрации
                       registerUser(email, password);
                   }
               }
           });

           signInButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
               }
           });
       }

       private boolean validateSignUpForm(String email, String password, String confirmPassword) {
           if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
               showError("Все поля должны быть заполнены.");
               return false;
           }

           if (!isValidEmail(email)) {
               showError("Некорректный email.");
               return false;
           }

           if (!password.equals(confirmPassword)) {
               showError("Пароли не совпадают.");
               return false;
           }

           return true;
       }

       private boolean isValidEmail(String email) {
           String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
           return email.matches(emailPattern);
       }

       private void showError(String message) {
           new AlertDialog.Builder(SignUpActivity.this)
               .setMessage(message)
               .setPositiveButton("OK", null)
               .show();
       }

       private void registerUser(String email, String password) {
           // Реализация запроса на сервер для регистрации
           // Если регистрация успешна, осуществить авторизацию и перейти на MainScreen
       }
   }
   ```

2. **Создайте разметку `activity_sign_up.xml`:**
   - Используйте `EditText` для полей ввода и `Button` для кнопок.

   ```xml
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:padding="16dp">
       
       <EditText
           android:id="@+id/emailEditText"
           android:hint="Email"
           android:inputType="textEmailAddress"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <EditText
           android:id="@+id/passwordEditText"
           android:hint="Пароль"
           android:inputType="textPassword"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <EditText
           android:id="@+id/confirmPasswordEditText"
           android:hint="Подтвердите пароль"
           android:inputType="textPassword"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <Button
           android:id="@+id/signUpButton"
           android:text="Зарегистрироваться"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <Button
           android:id="@+id/signInButton"
           android:text="У меня уже есть аккаунт"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
   </LinearLayout>
   ```

### 4. **Создание SignIn Screen (Экран входа)**

1. **Создайте активность `SignInActivity`:**
   - Эта активность будет похожа на `SignUpActivity`, но для входа. Также будет кнопка для перехода на экран регистрации.

   ```java
   public class SignInActivity extends AppCompatActivity {

       private EditText emailEditText, passwordEditText;
       private Button signInButton, signUpButton;

       @Override
       protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_sign_in);

           emailEditText = findViewById(R.id.emailEditText);
           passwordEditText = findViewById(R.id.passwordEditText);
           signInButton = findViewById(R.id.signInButton);
           signUpButton = findViewById(R.id.signUpButton);

           signInButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   String email = emailEditText.getText().toString().trim();
                   String password = passwordEditText.getText().toString().trim();

                   if (validateSignInForm(email, password)) {
                       // Отправка запроса на сервер для входа
                       signInUser(email, password);
                   }
              

 }
           });

           signUpButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
               }
           });
       }

       private boolean validateSignInForm(String email, String password) {
           if (email.isEmpty() || password.isEmpty()) {
               showError("Все поля должны быть заполнены.");
               return false;
           }

           if (!isValidEmail(email)) {
               showError("Некорректный email.");
               return false;
           }

           return true;
       }

       private void showError(String message) {
           new AlertDialog.Builder(SignInActivity.this)
               .setMessage(message)
               .setPositiveButton("OK", null)
               .show();
       }

       private void signInUser(String email, String password) {
           // Реализация запроса на сервер для авторизации
           // Если авторизация успешна, переход на Main Screen
       }
   }
   ```

2. **Создайте разметку `activity_sign_in.xml`:**
   - Разметка будет похожа на `SignUpActivity`, но без поля для подтверждения пароля.

   ```xml
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:orientation="vertical"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:padding="16dp">
       
       <EditText
           android:id="@+id/emailEditText"
           android:hint="Email"
           android:inputType="textEmailAddress"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <EditText
           android:id="@+id/passwordEditText"
           android:hint="Пароль"
           android:inputType="textPassword"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <Button
           android:id="@+id/signInButton"
           android:text="Войти"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
       
       <Button
           android:id="@+id/signUpButton"
           android:text="Регистрация"
           android:layout_width="match_parent"
           android:layout_height="wrap_content" />
   </LinearLayout>
   ```

### 5. **Основной экран (Main Screen)**

После успешной регистрации или авторизации, пользователь должен попасть на **Main Activity**.
