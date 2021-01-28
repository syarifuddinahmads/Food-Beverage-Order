package com.fborder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    private Intent intentMain;
    private Intent intentRegister;
    private long pressBack;
    private static final int TIME_INTERVAL = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // hide app bar
        getSupportActionBar().hide();

        // init edit text
        etEmail= findViewById(R.id.input_email);
        etPassword= findViewById(R.id.input_password);

        // init button
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        // init intent
        intentMain = new Intent(this,MainActivity.class);
        intentRegister =new Intent(this,RegisterActivity.class);

        // action button login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("EMAIL = "+etEmail.getText().toString());
                System.out.println("PASSWORD = "+etPassword.getText().toString());
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                if (email.equals("admin@gmail.com") && password.equals("123")){
                    startActivity(intentMain);
                }else{
                    Toast toast=Toast. makeText(getApplicationContext(),"Email or Password Incorrect...",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast. show();
                }
            }
        });

        // action button register
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intentRegister);
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        if (pressBack + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Klik 2 kali untuk keluar...",    Toast.LENGTH_SHORT).show();
        }
        pressBack = System.currentTimeMillis();
    }
}
