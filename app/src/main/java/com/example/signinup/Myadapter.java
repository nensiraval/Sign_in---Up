package com.example.signinup;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Currency;

public class Myadapter extends BaseAdapter {

    ArrayList <String> numlist = new ArrayList<>();
    ArrayList <String> namelist = new ArrayList<>();
    Context context;

    Myadapter (Context context, int uid)
    {
        this.context = context;

        Mydatabase db = new Mydatabase(context);
        Cursor cr = db.contact(uid);

        while (cr.moveToNext())
        {
            namelist.add(cr.getString(2));
            numlist.add(cr.getString(3));
        }
    }
    @Override
    public int getCount() {
        return namelist.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        View vv = LayoutInflater.from(context).inflate(R.layout.myview,parent,false);

        TextView vname = vv.findViewById(R.id.vname), vnumber = vv.findViewById(R.id.vnumber);

        vname.setText(namelist.get(position));
        vnumber.setText(numlist.get(position));
        return vv ;
    }
}
