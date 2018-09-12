package com.example.android.testturisapp.data.crud;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.android.testturisapp.data.ConexionOpenHelper;
import com.example.android.testturisapp.data.Utilidades;
import com.example.android.testturisapp.menu.Hotel.dummy.ModeloHotel;

/**
 * Created by android on 11/09/2018.
 */

public class SiteCrud {


    private static ConexionOpenHelper dataBase;

    private static SiteCrud instance = new SiteCrud();

    public SiteCrud() {

    }

    public static SiteCrud getInstance(Context context){

        if(dataBase == null){

            dataBase = new ConexionOpenHelper(context);
        }

        return instance;
    }


    public Cursor searchSites(){

        SQLiteDatabase db = dataBase.getReadableDatabase();
        String sql = String.format(" SELECT * FROM %s ORDER BY %s", ConexionOpenHelper.Tablas.SITIO, Utilidades.UtilidadesSitios.SITIO_NOMBRE);
        return db.rawQuery(sql, null);
    }

    public Cursor searchSite(String siteId){

            SQLiteDatabase db = dataBase.getReadableDatabase();
            String sql = String.format(" SELECT * FROM %s WHERE %s=%s", ConexionOpenHelper.Tablas.SITIO, Utilidades.UtilidadesSitios._ID, siteId);
            return db.rawQuery(sql, null);

    }
}
