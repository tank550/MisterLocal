package com.misterlocal.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dashboard extends AppCompatActivity {

    private SearchView searchView;



    RequestQueue requestQueue;
     String api="https://misterlocal.000webhostapp.com/listcat.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //recher();



        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    int jsonArraySize = jsonArray.length();
                    String descript, img;
                    JSONObject jsonObject;
                    scrollH[] scrollHS = new scrollH[jsonArraySize];

                    for (int i = 0; i < jsonArraySize; i++) {

                        jsonObject = jsonArray.getJSONObject(i);

                        descript = jsonObject.getString("design");
                        img = jsonObject.getString("img");
                        Toast.makeText(dashboard.this, img.toString(), Toast.LENGTH_LONG).show();

                        scrollHS[i] = new scrollH(img, descript);
                        fragmentTransaction.add(R.id.scrollh, scrollHS[i]);
                    }
                    fragmentTransaction.commit();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERREURSCROLL", "onResponse"+error.getMessage());
                Toast.makeText(dashboard.this, "Erreur verifier la requete", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue = Volley.newRequestQueue(dashboard.this);
        requestQueue.add(stringRequest);
    }
    }


    /*public  void recher(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, null, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    int jsonArraySize = jsonArray.length();
                    String descript, img;
                    JSONObject jsonObject;
                    scrollH[] scrollHS = new scrollH[jsonArraySize];

                    for (int i = 0; i < jsonArraySize; i++) {

                        jsonObject = jsonArray.getJSONObject(i);

                        descript = jsonObject.getString("design");
                        img = jsonObject.getString("img");
                        Toast.makeText(dashboard.this, img.toString(), Toast.LENGTH_LONG).show();

                        scrollHS[i] = new scrollH(img, descript);
                        fragmentTransaction.add(R.id.scrollh, scrollHS[i]);
                    }
                    fragmentTransaction.commit();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERREURSCROLL", "onResponse"+error.getMessage());
                Toast.makeText(dashboard.this, "Erreur verifier la requete", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue = Volley.newRequestQueue(dashboard.this);
        requestQueue.add(stringRequest);
    }
}*/