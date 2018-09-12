package com.example.android.testturisapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.view.ViewAnimationUtils;

import com.example.android.testturisapp.R;
import com.example.android.testturisapp.menu.Hotel.dummy.ModeloHotel;
import com.example.android.testturisapp.menu.site.dummy.SiteModel;


public class ConexionOpenHelper extends SQLiteOpenHelper
{
    private static final String DATA_BASE_NAME = "turisapp.db";
    private static final int VERSION = 1;



    public ConexionOpenHelper(Context contexto)
    {

        super(contexto, DATA_BASE_NAME, null, VERSION);
    }

    public interface Tablas
    {
        String HOTEL = "hotel";
        String RESTAURANTE = "restaurante";
        String SITIO = "sitio";
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Utilidades.UtilidadesHotel.CREAR_TABLA_HOTEL);
        db.execSQL(Utilidades.UtilidadesRestaurante.CREACION_TABLA_RESTAURATE);
        db.execSQL(Utilidades.UtilidadesSitios.CREAR_TABLA_SITIO);
        cargarDatosHotel(db);
        loadSites(db);
    }


////////          HOTEL            //////////////////////////////////


    public void cargarDatosHotel(SQLiteDatabase db)
    {
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));

        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));

        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
        CargarHotel(db,new ModeloHotel.Hotel(
                "Armenia Hotel",
                "Categoría del hotel:3,5 estrella(s), Cantidad de habitaciones: 18 ",
                "Dirección: Avenida Bolivar 8",
                R.drawable.armenia));
    }

    public long CargarHotel(SQLiteDatabase db,ModeloHotel.Hotel hotel)
    {
        return db.insert(Tablas.HOTEL,null,hotel.contentValues());
    }

    ////////          SITES            //////////////////////////////////


    public void loadSites(SQLiteDatabase db){

        loadSite(db, new SiteModel.Site("Ukumari", "El Parque Temático de Flora y Fauna de Pereira .","Cerritos-Cartago, FONDA CENTRAL, Pereira, Risaralda",R.drawable.ukumari ));
        loadSite(db, new SiteModel.Site("Plaza Bolivar", "La Plaza de Bolívar es el parque principal de Pereira.", "con, Cra. 7, Pereira, Risaralda",R.drawable.plazabolivar));
        loadSite(db, new SiteModel.Site("Lucy Tejada","Lucy Tejada Saenz nació en Pereira, Colombia el 9 de octubre de 1920 y murió en Cali.","Cra. 10 #16-60, Pereira, Risaralda",R.drawable.centrolucytejada));
        loadSite(db, new SiteModel.Site("Catedral de Nuestra Señora de la Pobreza de Pereira", "La Catedral de Nuestra Señora de la Pobreza es la iglesia catedralicia de culto católico ubicada en la ciudad colombiana de Pereira.","Cra. 7, Pereira, Risaralda",R.drawable.catedral));
    }


    public long loadSite(SQLiteDatabase db,SiteModel.Site site ){

        return db.insert(Tablas.SITIO,null, site.contentValues());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.HOTEL);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.RESTAURANTE);
        db.execSQL("DROP TABLE IF EXISTS "+Tablas.SITIO);
        this.onCreate(db);
    }
}
