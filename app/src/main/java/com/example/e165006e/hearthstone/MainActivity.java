package com.example.e165006e.hearthstone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.e165006e.hearthstone.R.id.spinner;

public class MainActivity extends AppCompatActivity {
    private boolean userIsInteracting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "https://omgvamp-hearthstone-v1.p.mashape.com/info";
        final TextView mTextView = (TextView) findViewById(R.id.textView5);
        final Spinner spinnerc = (Spinner) findViewById(R.id.spinner2);
        final Spinner spinnert = (Spinner) findViewById(R.id.spinner3);
        final Spinner spinnerf = (Spinner) findViewById(R.id.spinner4);
        final Spinner spinnerr = (Spinner) findViewById(R.id.spinner);
        final Intent intent = new Intent(this,Main2Activity.class);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    public void onResponse(JSONObject response) {
                        // Do something with response
                        try {
                            JSONArray lesclasses = response.getJSONArray("classes");
                            JSONArray lestypes = response.getJSONArray("types");
                            JSONArray lesfactions = response.getJSONArray("factions");
                            JSONArray lesraces = response.getJSONArray("races");

                            ArrayList<String> valuesc = new ArrayList<String>();
                            ArrayList<String> valuest = new ArrayList<String>();
                            ArrayList<String> valuesf = new ArrayList<String>();
                            ArrayList<String> valuesr = new ArrayList<String>();

                            for(int i=0;i<lesclasses.length();i++){
                                valuesc.add(lesclasses.get(i).toString());
                            }
                            for(int i=0;i<lestypes.length();i++){
                                valuest.add(lestypes.get(i).toString());
                            }
                            for(int i=0;i<lesfactions.length();i++){
                                valuesf.add(lesfactions.get(i).toString());
                            }
                            for(int i=0;i<lesraces.length();i++){
                                valuesr.add(lesraces.get(i).toString());
                            }

                            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valuesc);
                            spinnerc.setAdapter(spinnerArrayAdapter);

                            ArrayAdapter<String> spinnerArrayAdaptert = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valuest);
                            spinnert.setAdapter(spinnerArrayAdaptert);


                            ArrayAdapter<String> spinnerArrayAdapterf = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valuesf);
                            spinnerf.setAdapter(spinnerArrayAdapterf);


                            ArrayAdapter<String> spinnerArrayAdapterr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, valuesr);
                            spinnerr.setAdapter(spinnerArrayAdapterr);

                        } catch (JSONException e) {
                            mTextView.setText(e.getMessage());
                        }
                    }

                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                //TODO
                            }
                        }) {
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                headers.put("X-Mashape-Key", "ly3SnM9L0dmshlipYFaC3tamgcDZp1elCuIjsnshThOM33ChBr");
                return headers;
            }



        };



        spinnerc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                if (userIsInteracting) {
                    Toast.makeText(getBaseContext(),
                            "You have selected item : " + spinnerc.getItemAtPosition(index),
                            Toast.LENGTH_SHORT).show();
                    String valeur = spinnerc.getItemAtPosition(index).toString();
                    intent.putExtra("value", valeur);
                    int t = 1;
                    intent.putExtra("t",t);
                    startActivity(intent);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnert.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                if (userIsInteracting) {
                    Toast.makeText(getBaseContext(),
                            "You have selected item : " + spinnert.getItemAtPosition(index),
                            Toast.LENGTH_SHORT).show();
                    String valeur = spinnert.getItemAtPosition(index).toString();
                    int t = 2;
                    intent.putExtra("t",t);
                    intent.putExtra("value", valeur);
                    startActivity(intent);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                if (userIsInteracting) {
                    Toast.makeText(getBaseContext(),
                            "You have selected item : " + spinnerf.getItemAtPosition(index),
                            Toast.LENGTH_SHORT).show();
                    String valeur = spinnerf.getItemAtPosition(index).toString();
                    int t = 3;
                    intent.putExtra("value", valeur);
                    intent.putExtra("t",t);
                    startActivity(intent);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                if (userIsInteracting) {
                    Toast.makeText(getBaseContext(),
                            "You have selected item : " + spinnerr.getItemAtPosition(index),
                            Toast.LENGTH_SHORT).show();
                    String valeur = spinnerr.getItemAtPosition(index).toString();
                    int t = 4;
                    intent.putExtra("value", valeur);
                    intent.putExtra("t",t);
                    startActivity(intent);
                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });





        // Add JsonObjectRequest to the RequestQueue
        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        userIsInteracting = true;
    }

}




