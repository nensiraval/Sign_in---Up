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
    ImageView more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        save = findViewById(R.id.save);
        fname = findViewById(R.id.fname);
        mael = findViewById(R.id.mael);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone);
        more = findViewById(R.id.more);

        int userid = getIntent().getIntExtra("id", 20);

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pmenu = new PopupMenu(Contact.this,more);
                pmenu.inflate(R.menu.dotop);
                pmenu.show();

                Dialog dialog = new Dialog(Contact.this);

                dialog.setContentView(R.layout.condialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();

                //1st line no code jo apde bar game tya click kriye to close na thay
                dialog.setCancelable(false);
                TextView txt= dialog.findViewById(R.id.txt);
                Button close = dialog.findViewById(R.id.close);
                Button out = dialog.findViewById(R.id.out);

                out.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();
                        startActivity(new Intent(Contact.this,MainActivity.class));
                        finish();
                    }
                });

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        txt.setText("No");
                    }
                });
                pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.logt)
                        {
                            SpaceScreen.edit.putBoolean("status",false);
                            SpaceScreen.edit.apply();

//                            startActivity(new Intent(Contact.this,MainActivity.class));
//                            finish();
                        } else if (item.getItemId() == R.id.stg)
                        {
                            Toast.makeText(Contact.this,"Setting",Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.shre) {
                            Toast.makeText(Contact.this,"Share",Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.dlet) {
                            Toast.makeText(Contact.this,"Delete",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });


        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Mydatabase db = new Mydatabase(Contact.this);
                Boolean b = db.addcontact(userid, fname.getText().toString(), lname.getText().toString(), phone.getText().toString(), mael.getText().toString());
               if(b)
               {
                startActivity(new Intent(Contact.this, Homepage.class).putExtra("id",userid));
                finish();
               }
            }
        });
    }
}