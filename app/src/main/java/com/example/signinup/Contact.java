package com.example.signinup;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Contact extends AppCompatActivity
{
    Button save;
    TextInputEditText fname, mael, lname,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        save = findViewById(R.id.save);
        fname = findViewById(R.id.fname);
        mael = findViewById(R.id.mael);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone);

        int userid = getIntent().getIntExtra("id", 20);

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Mydatabase db = new Mydatabase(Contact.this);
                Boolean b = db.addcontact(userid, fname.getText().toString(), phone.getText().toString(), lname.getText().toString(), mael.getText().toString());
               if(b)
               {
                startActivity(new Intent(Contact.this, Homepage.class).putExtra("id",userid));
                finish();
               }
            }
        });
    }
}