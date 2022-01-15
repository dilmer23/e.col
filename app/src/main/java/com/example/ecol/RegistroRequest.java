package com.example.ecol;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistroRequest extends StringRequest {
    private  static  final  String ruta  ="https://ecolapp.webcindario.com/app/registroecol.php";
    private Map<String,String> parametros;
    public RegistroRequest(String nombre, String usuario, String clave ,int edad,String entidad, String email, Response.Listener<String>  listener){
        super(Method.POST, ruta ,listener,null);
        parametros= new HashMap<>();
        parametros.put("nombre" , nombre+"");
        parametros.put("usuario" , usuario+"");
        parametros.put("clave" , clave+"");
        parametros.put("edad" , edad+"");
        parametros.put("entidad" , entidad+"");
        parametros.put("email" , email+"");
    }

    @Override
    protected Map<String, String> getParams()  {
        return parametros;
    }
}
