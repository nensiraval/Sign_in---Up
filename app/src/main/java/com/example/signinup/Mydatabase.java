package com.example.signinup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Mydatabase extends SQLiteOpenHelper {

    public Mydatabase(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE usertable (id integer primary key autoincrement,username text unique, email text, password text)";
//                        CREATE TABLE table_name(column_name datatype constraints, , ,)
        db.execSQL(table);
        //contanct table
        String contact = "CREATE TABLE contact (id integer primary key autoincrement, userid integer, fname text, phone text, lname text, mael text)";
        db.execSQL(contact);
    }

    public Boolean addcontact(int userid, String fname, String phone, String lname, String mael) {
        try {
            String insrt = "INSERT INTO contact (userid, fname, phone, lname, mael) VALUES (" + userid + ", '" + fname + "', '" + phone + "', '" + lname + "', '" + mael + "')";
            getWritableDatabase().execSQL(insrt);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public Boolean insertdata(String username, String email, String pass) {
        try {

            String insert = "INSERT INTO usertable(username, email, password) VALUES ('" + username + "','" + email + "','" + pass + "')";
            SQLiteDatabase db = this.getWritableDatabase();
//            String insert = "INSERT INTO user(username, email, password) VALUES ('"+"nency"+"','"+"nency@gmail.com"+"', '""+"nency123"+"')";
            getWritableDatabase().execSQL(insert);

            return true;
            //INSERT INTO table_name(column_name, , ,)VALUES (value,,,)
            //String value ''
        } catch (Exception e) {
            Log.e("++", "insertdata: " + e);
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor userlogin(String user, String pass) {
        //  String select = "SELECT password FROM usertable";
        String select = "SELECT * FROM usertable WHERE username = '" + user + "'AND password = '" + pass + "'";

        Cursor cr = getReadableDatabase().rawQuery(select, null);
        return cr;
    }

    public Cursor contact(int userid) {
        String cnselect = "SELECT * FROM contact WHERE userid = " + userid;

        return getReadableDatabase().rawQuery(cnselect, null);
    }

    public void editdata(String newname, String newnum, int contactid)
    {
        String update = "UPDATE contact SET fname = '" + newname + "', phone = '" + newnum + "' WHERE id = " + contactid;
        getWritableDatabase().execSQL(update);

    }
    //name deleted
//    public void deletedata(String name)
//    {
////        String delete = "DELETE FROM contact WHERE fname = '"+name+"'";
////        getWritableDatabase().execSQL(delete);
//    }

    //id throw delete
    public void deletedata(int contactid) {
        String delete = "DELETE FROM contact  WHERE id = " + contactid;
        getWritableDatabase().execSQL(delete);
    }

}