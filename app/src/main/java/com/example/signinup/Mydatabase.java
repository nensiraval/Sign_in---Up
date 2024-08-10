package com.example.signinup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.DriverManager;

public class Mydatabase extends SQLiteOpenHelper {

    public  Mydatabase(Context context)
    {
        super(context,"data.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE usertable (username text unique, email text, password text)";
//        String table = "CREATE TABLE use(usernamr text, email text, password text)";
//                        CREATE TABLE table_name(column_name datatype constraints, , ,)
        db.execSQL(table);
    }

    public Boolean insertdata(String username, String email, String pass)
    {
        try {

            String insert = "INSERT INTO usertable(username, email, password) VALUES ('"+username+"','"+email+"','"+pass+"')";
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(insert, new String[]{username, email, pass});
//            String insert = "INSERT INTO user(username, email, password) VALUES ('"+"nency"+"','"+"nency@gmail.com"+"', '""+"nency123"+"')";
            getWritableDatabase().execSQL(insert);

            return  true;

            //INSERT INTO table_name(column_name, , ,)VALUES (value,,,)
            //String value ''
        }
        catch (Exception e)
        {
            Log.e("++", "insertdata: "+e);
            return  false;
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
    }
    public Cursor userlogin(String user, String pass)
    {
     //   String select = "SELECT * FROM usertable";
     //  String select = "SELECT password FROM usertable";
        String select = "SELECT * FROM usertable WHERE username = '"+user+"'AND password = '"+pass+"'";
        SQLiteDatabase db = this.getReadableDatabase();
//        Log.e("==", "userlogin: ",  );
        Cursor cr = db.rawQuery(select, null);
      //  Cursor cr = getReadableDatabase().rawQuery(select, null);
        return cr;
    }
}