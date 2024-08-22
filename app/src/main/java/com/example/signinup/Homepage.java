package com.example.signinup;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    FloatingActionButton add;  ListView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        add = findViewById(R.id.add);
        number = findViewById(R.id.number);

        int userid = getIntent().getIntExtra("id",10);

        number.setAdapter(new Myadapter(this, userid));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Homepage.this, Contact.class).putExtra("id", userid));
                finish();
            }
        });
    }
}