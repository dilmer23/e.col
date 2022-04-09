package com.example.ecol.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;



public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE  = "ecol.bd";
    static final String TABLE_DATOS = "actaVisitaIr";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DATOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario TEXT NOT NULL," +
                "dirreccion TEXT NOT NULL," +
                "log TEXT NOT NULL," +
                "lat TEXT NOT NULL," +
                "alt TEXT NOT NULL," +
                "ecositemaEvaluado TEXT NOT NULL," +
                "lugar TEXT NOT NULL," +
                "fecha TEXT NOT NULL," +
                "ciudad TEXT NOT NULL," +
                "departamento TEXT NOT NULL," +
                "nombreProfesional TEXT NOT NULL,"+
                "puntoEcosistema TEXT NOT NULL," +
                "codigoMuestra TEXT NOT NULL," +
                "clima TEXT NOT NULL," +
                "hidrologia TEXT NOT NULL,"+
                "turbidez TEXT NOT NULL," +
                "regimenPrecipitacion TEXT NOT NULL," +
                "qbr TEXT NOT NULL,"+
                "ihf TEXT NOT NULL," +
                "byword TEXT NOT NULL," +
                "bmwpZamora TEXT NOT NULL," +
                "actividadEcositema TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_DATOS);
        onCreate(sqLiteDatabase);

    }
}
