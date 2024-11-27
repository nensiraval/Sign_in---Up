package com.example.signinup;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
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

    // new file
    Button save,cl;
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
        cl = findViewById(R.id.cl);

        int userid = getIntent().getIntExtra("id", 20);

        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Mydatabase db = new Mydatabase(Contact.this);
                //phone number input from the user
                String email =  mael.getText().toString();
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    mael.setError("Please enter a valid email address");
                    return;
                }

                //number required check
                String number = phone.getText().toString();
                if (number.isEmpty())
                {
                    phone.setError("number if required");
                } else if (number.length() != 10) //number 10 digit na j ave ana mate
                {
                    phone.setError("Limited Digits 10");
                    return;
                }
                //jyare save button par ni click pr data store krvana hoi tyare
                Boolean b = db.addcontact(userid, fname.getText().toString(), phone.getText().toString(), lname.getText().toString(), mael.getText().toString());
                if(b)
                {
                    startActivity(new Intent(Contact.this, Homepage.class).putExtra("id",userid));
                    finish();
                }
            }
        });
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Contact.this,Homepage.class).putExtra("id",userid));
                finish();
            }
        });
    }
}