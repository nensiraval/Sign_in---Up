package com.example.signinup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class homepage extends AppCompatActivity {
    TextInputEditText userh, email, hpass, cpassh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        userh = findViewById(R.id.userh);
        email = findViewById(R.id.email);
        hpass = findViewById(R.id.hpass);
        cpassh = findViewById(R.id.cpassh);

//        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
//        String username = sp.getString("username", "");

//        userh.setText("Welcome, " + username + "!");

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String email = intent.getStringExtra("email");
        String copsss = intent.getStringExtra("copsss");

        userh.setText(username);
        userh.setText(password);
        userh.setText(email);
        userh.setText(copsss);
        finish();

        Log.e("--", "onCreate: "+userh);
    }
}