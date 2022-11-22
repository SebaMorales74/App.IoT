package com.sebastian.iot

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context:Context) : SQLiteOpenHelper(context,"USUARIOS",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE USUARIOS(_ID INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT, password TEXT)"
        db!!.execSQL(query)
        var user = "INSERT INTO USUARIOS(username,password) VALUES ('admin','admin')"
        db?.execSQL(user)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}