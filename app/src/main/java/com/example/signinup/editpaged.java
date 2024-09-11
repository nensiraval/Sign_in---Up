package com.example.signinup;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class editpaged extends AppCompatActivity {
    TextInputEditText ename, enumber;
    Button esave, edelete;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editpaged);

        ename = findViewById(R.id.ename);
        enumber = findViewById(R.id.enumber);
        esave = findViewById(R.id.esave);
        edelete = findViewById(R.id.edelete);

        String oldname = getIntent().getStringExtra("name");
        String oldnumber = getIntent().getStringExtra("num");
        int cid = getIntent().getIntExtra("cid", 90);

        ename.setText(oldname);
        enumber.setText(oldnumber);

        int userid = getIntent().getIntExtra("uid", 20);
        esave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Mydatabase db = new Mydatabase(editpaged.this);
                db.editdata(ename.getText().toString(),enumber.getText().toString(),cid);

                startActivity(new Intent(editpaged.this,Homepage.class).putExtra("id",userid));
                finish();
            }
        });

        edelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                Mydatabase db = new Mydatabase(editpaged.this);
//              //  db.deletedata(ename.getText().toString());
//                db.deletedata(cid);
//                startActivity(new Intent(editpaged.this,Homepage.class).putExtra("id",userid));
//                finish();
                Dialog dialog = new Dialog(editpaged.this);
                dialog.setContentView(R.layout.edit);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();

                //1st line no code jo apde bar game tya click kriye to close na thay
                dialog.setCancelable(false);
                TextView text= dialog.findViewById(R.id.text);
                Button yes = dialog.findViewById(R.id.yes);
                Button no = dialog.findViewById(R.id.no);

                text.getText();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        Mydatabase db = new Mydatabase(editpaged.this);
                        db.deletedata(cid);
                        startActivity(new Intent(editpaged.this,Homepage.class).putExtra("id",userid));
                         finish();
                    }
                });
                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}