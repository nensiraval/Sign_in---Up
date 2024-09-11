package com.example.signinup;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    FloatingActionButton add,logout;  ListView number;
    ImageView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        add = findViewById(R.id.add);
        number = findViewById(R.id.number);
        more = findViewById(R.id.more);
//        logout = findViewById(R.id.logout);

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

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pmenu = new PopupMenu(Homepage.this,more);
                pmenu.inflate(R.menu.dotop);
                pmenu.show();

                pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.logt)
                        {
                            Dialog dialog = new Dialog(Homepage.this);
                            dialog.setContentView(R.layout.condialog);
                            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            dialog.show();

                            //1st line no code jo apde bar game tya click kriye to close na thay
                            dialog.setCancelable(false);
                            TextView txt= dialog.findViewById(R.id.txt);
                            Button close = dialog.findViewById(R.id.close);
                            Button out = dialog.findViewById(R.id.out);

                            txt.getText();
                            out.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v)
                                {
                                    dialog.dismiss();
                                    startActivity(new Intent(Homepage.this,MainActivity.class));
                                    finish();
                                }
                            });

                            close.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                        } else if (item.getItemId() == R.id.stg)
                        {
                            Toast.makeText(Homepage.this,"Setting",Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.shre) {
                            Toast.makeText(Homepage.this,"Share",Toast.LENGTH_SHORT).show();
                        }
                        else if (item.getItemId() == R.id.dlet)
                        {
                            Toast.makeText(Homepage.this,"Delete",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                SpaceScreen.edit.putBoolean("status",false);
//                SpaceScreen.edit.apply();
//                startActivity(new Intent(Homepage.this, SpaceScreen.class));
//                finish();
//            }
//        });
    }
}