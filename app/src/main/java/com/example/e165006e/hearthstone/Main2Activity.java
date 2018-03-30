package com.example.e165006e.hearthstone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView titre = (TextView) findViewById(R.id.textView6);
        final ListView list = (ListView) findViewById(R.id.listView);
        Intent inte = getIntent();
        Bundle b = inte.getExtras();
        String value = (String) b.get("value");
        String valuef = value.replace(" ", "%20");
        int t = (int) b.get("t");
        titre.append(value);
        final String url1 = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/classes/" + valuef;
        final String url2 = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/types/" + valuef;
        final String url3 = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/factions/" + valuef;
        final String url4 = "https://omgvamp-hearthstone-v1.p.mashape.com/cards/races/" + valuef;
        final Intent intent = new Intent(this,Main3Activity.class);


        if (t == 1) {
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                    (Request.Method.GET, url1, null, new Response.Listener<JSONArray>() {

                        public void onResponse(JSONArray response) {
                            // Do something with response
                            try {
                                ArrayList<String> valuesn = new ArrayList<String>();
                                JSONObject jsonobject = response.getJSONObject(0);

                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject obj = response.getJSONObject(i);
                                    String name = obj.getString("name");
                                    valuesn.add(name);
                                    System.out.println(name);
                                }
                                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                                        android.R.layout.simple_list_item_1, valuesn);
                                list.setAdapter(adapter);

                            } catch (JSONException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    System.out.println(error.getMessage());
                                }

                            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("X-Mashape-Key", "qXXjlrY3QLmshpF5KJeipuDE8bBrp1sLnw2jsntzA5CjD1gzWl");
                    return headers;
                }


            };

            Volley.newRequestQueue(this).add(jsonObjectRequest);
            list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    String item = (String) list.getItemAtPosition(position);
                    Toast.makeText(getBaseContext(),"You selected : " + item,Toast.LENGTH_SHORT).show();
                    String valeur = list.getItemAtPosition(position).toString();
                    intent.putExtra("value", valeur);
                    startActivity(intent);
                }
            });

        }
        if (t == 2) {
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                    (Request.Method.GET, url2, null, new Response.Listener<JSONArray>() {

                        public void onResponse(JSONArray response) {
                            // Do something with response
                            try {
                                ArrayList<String> valuesn = new ArrayList<String>();
                                JSONObject jsonobject = response.getJSONObject(0);

                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject obj = response.getJSONObject(i);
                                    String name = obj.getString("name");
                                    valuesn.add(name);
                                    System.out.println(name);
                                }
                                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                                        android.R.layout.simple_list_item_1, valuesn);
                                list.setAdapter(adapter);

                            } catch (JSONException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    System.out.println(error.getMessage());
                                }

                            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("X-Mashape-Key", "qXXjlrY3QLmshpF5KJeipuDE8bBrp1sLnw2jsntzA5CjD1gzWl");
                    return headers;
                }


            };



            Volley.newRequestQueue(this).add(jsonObjectRequest);
            list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    String item = (String) list.getItemAtPosition(position);
                    Toast.makeText(getBaseContext(),"You selected : " + item,Toast.LENGTH_SHORT).show();
                    String valeur = list.getItemAtPosition(position).toString();
                    intent.putExtra("value", valeur);
                    startActivity(intent);
                }
            });



        }
        if (t == 3) {
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                    (Request.Method.GET, url3, null, new Response.Listener<JSONArray>() {

                        public void onResponse(JSONArray response) {
                            // Do something with response
                            try {
                                ArrayList<String> valuesn = new ArrayList<String>();
                                JSONObject jsonobject = response.getJSONObject(0);

                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject obj = response.getJSONObject(i);
                                    String name = obj.getString("name");
                                    valuesn.add(name);
                                    System.out.println(name);
                                }
                                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                                        android.R.layout.simple_list_item_1, valuesn);
                                list.setAdapter(adapter);

                            } catch (JSONException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    System.out.println(error.getMessage());
                                }

                            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("X-Mashape-Key", "qXXjlrY3QLmshpF5KJeipuDE8bBrp1sLnw2jsntzA5CjD1gzWl");
                    return headers;
                }


            };

            Volley.newRequestQueue(this).add(jsonObjectRequest);
            Volley.newRequestQueue(this).add(jsonObjectRequest);
            list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    String item = (String) list.getItemAtPosition(position);
                    Toast.makeText(getBaseContext(),"You selected : " + item,Toast.LENGTH_SHORT).show();
                    String valeur = list.getItemAtPosition(position).toString();
                    intent.putExtra("value", valeur);
                    startActivity(intent);
                }
            });



        }
        if (t == 4) {
            JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                    (Request.Method.GET, url4, null, new Response.Listener<JSONArray>() {

                        public void onResponse(JSONArray response) {
                            // Do something with response
                            try {
                                ArrayList<String> valuesn = new ArrayList<String>();
                                JSONObject jsonobject = response.getJSONObject(0);

                                for (int i = 0; i < response.length(); i++) {
                                    JSONObject obj = response.getJSONObject(i);
                                    String name = obj.getString("name");
                                    valuesn.add(name);
                                    System.out.println(name);
                                }
                                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(Main2Activity.this,
                                        android.R.layout.simple_list_item_1, valuesn);
                                list.setAdapter(adapter);

                            } catch (JSONException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    System.out.println(error.getMessage());
                                }

                            }) {
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    headers.put("X-Mashape-Key", "qXXjlrY3QLmshpF5KJeipuDE8bBrp1sLnw2jsntzA5CjD1gzWl");
                    return headers;
                }


            };

            Volley.newRequestQueue(this).add(jsonObjectRequest);
            Volley.newRequestQueue(this).add(jsonObjectRequest);
            list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    String item = (String) list.getItemAtPosition(position);
                    Toast.makeText(getBaseContext(),"You selected : " + item,Toast.LENGTH_SHORT).show();
                    String valeur = list.getItemAtPosition(position).toString();
                    intent.putExtra("value", valeur);
                    startActivity(intent);
                }
            });

        }
    }

}


