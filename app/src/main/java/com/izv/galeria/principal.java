package com.izv.galeria;

import android.app.Activity;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;


public class principal extends Activity {

    ListView lv;

    private GridView gridView;
    private Adaptador customGridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        gridView = (GridView) findViewById(R.id.gridView);
        customGridAdapter = new Adaptador(this, R.layout.detalle, getData());
        gridView.setAdapter(customGridAdapter);
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Log.v("AAAAAA: ","PULSADO");
                Toast.makeText(principal.this, position + "#Selected", Toast.LENGTH_SHORT).show();
            }
        });


        /*Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] proyeccion = null;
        String condicion = null;
        String[] parametros = null;
        String orden = null;
        Cursor c = getContentResolver().query(
                uri,
                proyeccion,
                condicion,
                parametros,
                orden);
        String nombre = "";
        c.getColumnNames();
        c.moveToFirst();
        while(!c.isAfterLast()){
            nombre = c.getString(c.getColumnIndex("_data"));
            c.moveToNext();
        }
        try{
            File f = new File(nombre);
            Picasso.with(this).load(f).into(iv);
        }catch (Exception e){
        }*/
    }

    private ArrayList<ImageItem> getData() {
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        ArrayList<ImageItem> fotos = new ArrayList<ImageItem>();
        String[] proyeccion = null;
        String condicion = null;
        String[] parametros = null;
        String orden = null;
        Cursor c = getContentResolver().query(
                uri,
                proyeccion,
                condicion,
                parametros,
                orden);
        String nombre = "";
        c.getColumnNames();
        c.moveToFirst();
        int i = 0;
        while(!c.isAfterLast()){
            String[] nombreFoto = nombre.split("/");
            nombre = c.getString(c.getColumnIndex("_data"));
            c.moveToNext();
            File f = new File(nombre);
            fotos.add(new ImageItem(f,nombreFoto[nombreFoto.length-1]+i));
            i++;
        }
        return fotos;
       }
}
