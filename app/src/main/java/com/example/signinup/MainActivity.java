package com.example.signinup;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    Button loginuser;
    TextInputEditText password, username;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        signup = findViewById(R.id.signup);
        loginuser = findViewById(R.id.loginuser);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);

        Mydatabase db = new Mydatabase(MainActivity.this);
        loginuser.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View view)
              {
//                  if (!password.equals(""))
//                  {
//                      Toast.makeText(MainActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();
//                  }
//                  else
//                  {
//                      Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
//                      finish();
//                  }
                Cursor data =  db.userlogin(username.getText().toString(), password.getText().toString());

                while (data.moveToNext())
                {
                    Log.e("==n", "id: "+data.getInt(0));
                    Log.e("==n", "name: "+data.getString(1));
                    Log.e("==n", "email: "+data.getString(2));
                    Log.e("==n", "pass: "+data.getString(3));

                    SpaceScreen.edit.putBoolean("status",true);
                    SpaceScreen.edit.putInt("uid",data.getInt(0));
                    SpaceScreen.edit.apply();

                    startActivity(new Intent(MainActivity.this, Homepage.class).putExtra("id",data.getInt(0))
                            .putExtra("name",data.getString(1)));
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MainActivity.this, MainActivity2up.class));
                finish();
            }
        });
    }
}