package com.example.signinup;

import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



// Try mate PRactice have apde ane main ma add karvanu
public class Pmenu extends AppCompatActivity {

    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pmenu);

        imageview = findViewById(R.id.imageview);

        //popupmenu atle k jyare apde main main par click kriye atle je options show thay te popupmenu throw thay chhe
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pmenu = new PopupMenu(Pmenu.this, imageview);

                //jyare mymenu nu layout banaviye tyare j icon pr click krvathi te options show krse
                pmenu.inflate(R.menu.mymenu);
               pmenu.show();
                pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        //Click karta toast pade(Massage)
                        if (item.getItemId() == R.id.logt)
                        {
                            Toast.makeText(Pmenu.this,"logout",Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.setting) {
                            Toast.makeText(Pmenu.this,"Setting",Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                });
            }
        });

        //Dialog use : jyare aapade screen pr koi pn box open thay chhe te a dialog throw thay chhe,
        // jem k koi pn folder open kriye atle ek box jevu ave ane tema options ave
        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(Pmenu.this);

                dialog.setContentView(R.layout.dialog);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();

                //1st line no code jo apde bar game tya click kriye to close na thay
                dialog.setCancelable(false);
                TextView textView= dialog.findViewById(R.id.textView);
                Button sub = dialog.findViewById(R.id.sub);
                Button cancel = dialog.findViewById(R.id.cancel);

                sub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText("Submit");
                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });
    }
}