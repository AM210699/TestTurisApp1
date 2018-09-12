package com.example.android.testturisapp.menu.site.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.android.testturisapp.data.Utilidades;
import com.example.android.testturisapp.data.crud.CrudHotel;
import com.example.android.testturisapp.data.crud.SiteCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class SiteModel {

    private static SiteModel siteModel = null;

    private  SiteCrud siteCrud;



    /**
     * An array of sample (dummy) items.
     */
    public static final List<Site> ITEMS = new ArrayList<Site>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Site> ITEM_MAP = new HashMap<String, Site>();

    /*
    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createSite(i));
        }
    }*/
    
    /*
    private static Site createSite(int position) {
        return new Site(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/


    ////Constructor

    private SiteModel (Context context) {
        this.siteCrud = SiteCrud.getInstance(context);
        this.loadSites();
    }


    /////first the instance

    public static SiteModel getInstance(Context context){

        if (siteModel == null)
        {
            siteModel = new SiteModel(context);
        }
    return siteModel;
    }

    ///////// Create the method to load the data of the sites

    private void loadSites(){

        Cursor cursorSites = this.siteCrud.searchSites();

        while (cursorSites.moveToNext()){

            Site site = new Site(cursorSites);

            addItem(site);

        }

    }


    private static void addItem(Site site) {
        ITEMS.add(site);
        ITEM_MAP.put(site.id, site);
    }

    private static  String generateId() {

        return UUID.randomUUID().toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Site {
        public final String id;
        public final String name;
        public final String description;
        public final String ubication;
        public final int image;

        public Site(String name, String description, String  ubication, int image) {
            this.id = generateId();
            this.name = name;
            this.description =  description;
            this.ubication = ubication;
            this.image = image;
        }

        public Site(Cursor cursor){

            this.id=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios._ID));
            this.name=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_NOMBRE));
            this.description=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_DESCRIPCION));
            this.ubication=cursor.getString(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_UBICACION));
            this.image=cursor.getInt(cursor.getColumnIndex(Utilidades.UtilidadesSitios.SITIO_IMAGEN));

        }

        public ContentValues contentValues()

        {

            ContentValues values = new ContentValues();

            //values.put(Utilidades.UtilidadesSitios._ID,getId());
            values.put(Utilidades.UtilidadesSitios.SITIO_NOMBRE, getName());
            values.put(Utilidades.UtilidadesSitios.SITIO_DESCRIPCION, getDescription());
            values.put(Utilidades.UtilidadesSitios.SITIO_UBICACION,getUbication());
            values.put(Utilidades.UtilidadesSitios.SITIO_IMAGEN,getImage());


            return values;
        }


        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getUbication() {
            return ubication;
        }

        public int getImage() {
            return image;
        }
        
        /*
        @Override
        public String toString() {
            return description ;
        }*/
    }
}
