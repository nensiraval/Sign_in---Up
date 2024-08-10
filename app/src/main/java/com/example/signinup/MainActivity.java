package com.example.signinup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    Button loginuser;
    TextInputEditText password, username;
    static SharedPreferences sp; // get
    static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        sp = getSharedPreferences("mydata", MODE_PRIVATE);
        edit = sp.edit();

        signup = findViewById(R.id.signup);
        loginuser = findViewById(R.id.loginuser);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        edit.putInt("username", 0);
        edit.apply();

        Mydatabase db = new Mydatabase(MainActivity.this);

        loginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernametext = username.getText().toString();
                String passwordtext = password.getText().toString();

                Cursor data =  db.userlogin(usernametext, passwordtext);

                while (data.moveToNext())
                {
                    //Log.e("==n", "name: "+data.getString(0));
                    Log.e("==n", "email: "+data.getString(0));
                    Log.e("==n", "pass: "+data.getString(1));
                }
                startActivity(new Intent(MainActivity.this, homepage.class).putExtra("username", usernametext));
            }
        });

        startActivity(new Intent(MainActivity.this, homepage.class).putExtra("username",username.getText().toString()));

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2up.class));
                finish();
            }
        } );
    }
}
//public class MainActivity extends AppCompatActivity {
//     TextView signup;
//     Button loginuser;
//    TextInputEditText password,username;
//   static SharedPreferences sp; // get
//   static SharedPreferences.Editor edit;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signin);
//
//        sp = getSharedPreferences("mydata", MODE_PRIVATE);
//        edit = sp.edit();
//
//        edit.putInt("username", 0);
//        //edit.putString("username", username.getText().toString());
//        edit.apply();
//
//        startActivity(new Intent(MainActivity.this, homepage.class).putExtra("username",username.getText().toString()));
//
//        signup = findViewById(R.id.signup);
//        loginuser = findViewById(R.id.loginuser);
//        password = findViewById(R.id.password);
//        username = findViewById(R.id.username);
//
//        Mydatabase db = new Mydatabase(MainActivity.this);
//
//        loginuser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               Cursor data =  db.userlogin(username.getText().toString(), password.getText().toString());
//
//               while (data.moveToNext())
//               {
////                   Log.e("==n", "name: "+data.getString(0));
////                   Log.e("==n", "email: "+data.getString(1));
//                   Log.e("==n", "pass: "+data.getString(0));
//               }
//
//            }
//        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MainActivity2up.class));
//                finish();
//            }
//        } );
//
//    }
//}