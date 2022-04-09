package com.example.ecol.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class BDInsertarDatos extends DBHelper {
    Context context;

    public BDInsertarDatos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarDatos( String usuario, String dirreccion, String log, String lat, String alt, String ecositemaEvaluado, String lugar, String fecha, String ciudad, String departamento, String nombreProfesional, String puntoEcosistema, String nombreEcosistema, String codigoMuestra, String clima, String hidrologia, String turbidez, String regimenPrecipitacion, String qbr, String ihf, String byword, String bmwpZamora, String actividad){
        long id = 0;
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("usuario", usuario);
            values.put("dirreccion", dirreccion);
            values.put("log", log);
            values.put("lat", lat);
            values.put("alt", alt);
            values.put("ecositemaEvaluado", ecositemaEvaluado);
            values.put("lugar", lugar);
            values.put("fecha", fecha);
            values.put("ciudad", ciudad);
            values.put("departamento", departamento);
            values.put("nombreProfesional", nombreProfesional);
            values.put("puntoEcosistema", puntoEcosistema);
            values.put("ecositemaEvaluado", nombreEcosistema);
            values.put("codigoMuestra", codigoMuestra);
            values.put("clima", clima);
            values.put("hidrologia", hidrologia);
            values.put("turbidez", turbidez);
            values.put("regimenPrecipitacion", regimenPrecipitacion);
            values.put("qbr", qbr);
            values.put("ihf", ihf);
            values.put("byword", byword);
            values.put("bmwpZamora", bmwpZamora);
            values.put("actividadEcositema", actividad);

           id = db.insert(TABLE_DATOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}