package com.example.ecol;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import maes.tech.intentanim.CustomIntent;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class ubicacion extends AppCompatActivity {

    EditText direccion, lat,lon,altura;
    Button guardar,manual;
    TextView tetxoubicacion;



    @SuppressLint("WrongConstant")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("\nubicacion");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ubicacion2);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlueJeans)));
        setContentView(R.layout.activity_ubicacion);
        tetxoubicacion=(TextView) findViewById(R.id.txtubicacion);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            tetxoubicacion.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
        direccion=(EditText)findViewById(R.id.txtDireccion);
        lat=(EditText)findViewById(R.id.txtLat);
        lon=(EditText)findViewById(R.id.txtLon);
        altura=(EditText)findViewById(R.id.txtaltura);


        manual=(Button)findViewById(R.id.btnmanualcordenadas);

        manual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostarmodl();
            }
        });


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
        } else {
            locationStart();
        }
    }


    private void locationStart() {
        LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Localizacion Local = new Localizacion();
        Local.setMainActivity(this);
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
            return;
        }
        mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, (LocationListener) Local);
        mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) Local);
        lat.setText("Localización agregada");
        direccion.setText("");
    }
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationStart();
                return;
            }
        }
    }
    public void setLocation(Location loc) {
        //Obtener la direccion de la calle a partir de la latitud y la longitud
        if (loc.getLatitude() != 0.0 && loc.getLongitude() != 0.0) {
            try {
                Geocoder geocoder = new Geocoder(this, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(
                        loc.getLatitude(), loc.getLongitude(), 1);
                if (!list.isEmpty()) {
                    Address DirCalle = list.get(0);
                    direccion.setText(DirCalle.getAddressLine(0));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
        /////////////////////////////enviar parametros a la actividad desboar/////////////////////////////////7
    public void enviarparametro(View view) {
        String dr= direccion.getText().toString();
        String longitud= lon.getText().toString();
        String latitud= lat.getText().toString();
        String altu= altura.getText().toString();
        if(TextUtils.isEmpty(altu)) {
            altura.setError("Verifique tiene un Campo vacio"); return;
        }
        Intent miinten =new Intent(ubicacion.this,dashboard.class);
        Bundle mibuble= new Bundle();
        mibuble.putString("dr",direccion.getText().toString());
        mibuble.putString("longitud",lon.getText().toString());
        mibuble.putString("lactitud",lat.getText().toString());
        mibuble.putString("altura",altura.getText().toString());
        miinten.putExtras(mibuble);
        startActivity(miinten);
        ///// animacion al camniar de activity//////////////////////
        CustomIntent.customType(this,"fadein-to-fadeout");
    }

    public void regresar(View view) {
        Intent miIntent =new Intent(ubicacion.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }


    private void mostarmodl() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ubicacion.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_fragment_manulaubicacion,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        Button cerrar = view.findViewById(R.id.btnCancel);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        final EditText longi = view.findViewById(R.id.manuallongitud);
        final EditText lati = view.findViewById(R.id.manuallatitud);
        final EditText dirrec = view.findViewById(R.id.manualdirrecion);
        final EditText altur = view.findViewById(R.id.manualaltura);

        Button siguiente = view.findViewById(R.id.btnReintentar);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dr= dirrec.getText().toString();
                String longitud= longi.getText().toString();
                String latitud= lati.getText().toString();
                String altura= altur.getText().toString();
                Intent miinten =new Intent(ubicacion.this,dashboard.class);
                Bundle mibuble= new Bundle();
                mibuble.putString("dr",dirrec.getText().toString());
                mibuble.putString("longitud",longi.getText().toString());
                mibuble.putString("lactitud",lati.getText().toString());
                mibuble.putString("altura",altur.getText().toString());
                miinten.putExtras(mibuble);
                startActivity(miinten);
            }
        });

    }

    /* Aqui empieza la Clase Localizacion */
    public class Localizacion implements LocationListener {
        ubicacion mainActivity;
        public ubicacion getMainActivity() {
            return mainActivity;
        }
        public void setMainActivity(ubicacion mainActivity) {
            this.mainActivity = mainActivity;
        }
        @Override
        public void onLocationChanged(Location loc) {
            // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
            // debido a la deteccion de un cambio de ubicacion
            loc.getLatitude();
            loc.getLongitude();
            loc.getAltitude();
            String Text1 = String.valueOf(loc.getLatitude());
            String Text2 = String.valueOf(loc.getLongitude());
            String Text3 = String.valueOf(loc.getAltitude());
            lat.setText(Text1);
            lon.setText(Text2);
            altura.setText(Text3);
            this.mainActivity.setLocation(loc);

        }
        @Override
        public void onProviderDisabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es desactivado
            lat.setText("GPS Desactivado");
        }
        @Override
        public void onProviderEnabled(String provider) {
            // Este metodo se ejecuta cuando el GPS es activado
            lat.setText("GPS Activado");
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.AVAILABLE:
                    Log.d("debug", "LocationProvider.AVAILABLE");
                    break;
                case LocationProvider.OUT_OF_SERVICE:
                    Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                    break;
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent miIntent =new Intent(ubicacion.this,consejosActivity.class);
        startActivity(miIntent);
        CustomIntent.customType(this,"fadein-to-fadeout");
        finish();
    }
}
