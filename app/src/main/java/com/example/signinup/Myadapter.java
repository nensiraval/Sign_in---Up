package com.example.signinup;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Currency;

public class Myadapter extends BaseAdapter {

//    ArrayList <String> numlist = new ArrayList<>();
//    ArrayList <String> namelist = new ArrayList<>();
    // jyare limited to vadhare data hoi tyare ek j arraylist banavvi

    ArrayList<Modelclass> datalist = new ArrayList<>();

    Context context;
    int uid;
    Myadapter (Context context, int uid)
    {
        this.context = context;
        this.uid = uid;
        Mydatabase db = new Mydatabase(context);
        Cursor cr = db.contact(uid);

        while (cr.moveToNext())
        {
            Modelclass d = new Modelclass(); //(cr.getString(2),cr.getString(3),cr.getInt(0));
            d.setName(cr.getString(2));
            d.setNum(cr.getString(3));
            d.setId(cr.getInt(0));
            datalist.add(d);
        }
    }
    @Override
    public int getCount() {
        return  datalist.size();
//        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View vv = LayoutInflater.from(context).inflate(R.layout.myview,parent,false);

        TextView name = vv.findViewById(R.id.vname), num = vv.findViewById(R.id.vnumber);

        name.setText(datalist.get(position).getName());
        num.setText(datalist.get(position).getNum());

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,editpaged.class).putExtra("name",name.getText()).
                        putExtra("num", num.getText()).putExtra("cid",datalist.get(position).getId()).putExtra("uid",uid));
            }
        });

//        vname.setText(namelist.get(position));
//        vnumber.setText(numlist.get(position));
        return vv ;
    }
}
