package com.example.signinup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2up extends AppCompatActivity {
    TextView login; Button enter; TextInputEditText user, email, pass, compss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        login = findViewById(R.id.login);
        enter = findViewById(R.id.enter);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        compss = findViewById(R.id.compss);

        Mydatabase db = new Mydatabase(MainActivity2up.this);

//        pass.getText().toString();
//        compss.getText().toString();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean n = db.insertdata(user.getText().toString(), email.getText().toString(), pass.getText().toString());

                if (n == true)
                {
                    startActivity(new Intent(MainActivity2up.this,MainActivity.class));
                    finish();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2up.this, MainActivity.class));
                finish();
            }
        });
    }
}