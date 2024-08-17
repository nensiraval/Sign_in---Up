package com.example.signinup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Homepage extends AppCompatActivity {
    TextView name;
    FloatingActionButton add;  ListView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);

        int userid = getIntent().getIntExtra("id",10);
        name.setText(getIntent().getStringExtra("name"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Homepage.this, Contact.class).putExtra("id",userid));
            }
        });

    }
}