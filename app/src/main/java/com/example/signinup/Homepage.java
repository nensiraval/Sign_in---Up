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
import androidx.appcompat.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Comparator;

public class Homepage extends AppCompatActivity {
    FloatingActionButton add,logout;  ListView number;
    ImageView more;
    ArrayList<Modelclass> datalist = new ArrayList<>();
    SearchView search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        add = findViewById(R.id.add);
        number = findViewById(R.id.number);
        more = findViewById(R.id.more);
        search = findViewById(R.id.search);
        ArrayList<Modelclass> searchList = new ArrayList<>();
//        logout = findViewById(R.id.logout);

        int userid = getIntent().getIntExtra("id",10);


        Mydatabase db = new Mydatabase(this);
        Cursor cr = db.contact(userid);

        while (cr.moveToNext())
        {
            Modelclass d = new Modelclass(); //(cr.getString(2),cr.getString(3),cr.getInt(0));
            d.setName(cr.getString(2));
            d.setNum(cr.getString(3));
            d.setId(cr.getInt(0));
            datalist.add(d);
        }

        //Data sorting
        ArrayList<String> namelist = new ArrayList<>();
        for (int i=0; i<datalist.size(); i++)
        {
            namelist.add(datalist.get(i).getName());
        }
        namelist.sort(Comparator.naturalOrder());

        ArrayList<Modelclass> tmp = new ArrayList<>();
        for(int i =0; i<datalist.size(); i++)
        {
            for (int j =0 ; j<datalist.size(); j++)
            {
                if (namelist.get(i) == datalist.get(j).getName())
                {
                    tmp.add(datalist.get(j));
                    break;
                }
            }
        }
        datalist = tmp;


        //search button clicked
        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("===", "onQueryTextSubmit: "+query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.e("===", "onQueryTextChange: "+newText);
                //searchview ma jem data enter kriye tem name ave
                searchList.clear();
                for (int i = 0; i<datalist.size(); i++)
                {
                    if (datalist.get(i).getName().contains(newText))
                    {
                        searchList.add(datalist.get(i));
                    }
                }
                number.setAdapter(new Myadapter(Homepage.this, userid, searchList));
                return true;
            }
        });
        number.setAdapter(new Myadapter(Homepage.this, userid, datalist));

        //new contact add karvva
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