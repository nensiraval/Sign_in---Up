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
    TextView name;
    FloatingActionButton add;  ListView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        number = findViewById(R.id.number);
     //   ArrayList<String> contacts = new ArrayList<>();

        int userid = getIntent().getIntExtra("id",10);
        name.setText(getIntent().getStringExtra("name"));

     //   Mydatabase dbc = new Mydatabase(Homepage.this);

//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, contacts);
//        number.setAdapter(adapter);

//        number.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Cursor data =  dbc.contact(name.getText().toString());
//                Log.e("+++", "onItemClick: " + position);
//                String a = contacts.get(position);
//                startActivity(new Intent(Homepage.this,Contact.class).putExtra("new",a));
//            }
//        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this, Contact.class).putExtra("id", userid));
        }
        });
    }
}