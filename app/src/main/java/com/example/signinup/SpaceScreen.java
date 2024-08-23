package com.example.signinup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SpaceScreen extends AppCompatActivity {
    static SharedPreferences sp;
    static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_space_screen);

        sp = getSharedPreferences("myshare",MODE_PRIVATE);
        edit = sp.edit();

        Boolean userstatus = sp.getBoolean("status",false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (userstatus){
                    startActivity(new Intent(SpaceScreen.this, Homepage.class).
                            putExtra("id",sp.getInt("uid",0)));
                    finish();
                }
                else
                {
                startActivity(new Intent(SpaceScreen.this,MainActivity.class));
                finish();
                }
            }
        },2000);
    }
}