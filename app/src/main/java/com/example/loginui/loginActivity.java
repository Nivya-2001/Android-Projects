package com.example.loginui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    private EditText ed_username;
    private EditText ed_password;
    private Button btn_login;
    private Button btn_signUp;

    private final String CREDENTIAL_SECURED_PREF ="out_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_username = findViewById(R.id.ed_username);
        ed_password = findViewById(R.id.ed_password);
        btn_login = findViewById(R.id.btn_login);
        btn_signUp = findViewById(R.id.btn_signup);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signUpActivity.class);
                startActivity(intent);
//                Toast.makeText(loginActivity.this, "Hello", Toast.LENGTH_SHORT).show();
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences credential = getSharedPreferences(CREDENTIAL_SECURED_PREF, Context.MODE_PRIVATE);
                String strUsername = credential.getString("Username", null);
                String strPassword = credential.getString("Password", null);

                String username_from_ed = ed_username.getText().toString();
                String password_from_ed = ed_password.getText().toString();

                if (strUsername != null && username_from_ed != null && strUsername.equalsIgnoreCase(username_from_ed)){
                    if (strPassword != null && password_from_ed != null && strPassword.equalsIgnoreCase(password_from_ed))
                    {
                        Toast.makeText(loginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(loginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(loginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
                         
            }
        });

    }
}