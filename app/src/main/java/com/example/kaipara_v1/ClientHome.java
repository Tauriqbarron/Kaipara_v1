package com.example.kaipara_v1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ClientHome extends AppCompatActivity {
    String email;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationView topNav = findViewById(R.id.top_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
        topNav.setOnNavigationItemSelectedListener(navListnerTop);
        Bundle data = getIntent().getExtras();
        if (data != null){
            email = data.getString("email");
            Log.e("Email Passed:",email);
        }
        jsonParse();
    }
    private void startFirstFrag(){
        Fragment startFrag;
        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        startFrag = new ClientServiceJobsFragment();
        startFrag.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,startFrag).commit();
    }
    private void jsonParse(){
        Log.e("API","Retrieving id");
        StringBuilder s = new StringBuilder(100);
        s.append("https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/client/get_single_client.php");
        s.append("?email=");
        s.append(email);
        String url = s.toString();
        Log.e("API Request: ", url);

        RequestQueue requestQueue = Volley.newRequestQueue(ClientHome.this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            id = response.getString("id").toString();
                            Log.e("API Response: ", id);
                            startFirstFrag();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("API Error", error.toString());
            }
        }
        );
        requestQueue.add(objectRequest);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListnerTop =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.profile:
                            selectedFragment = new ClientProfileFragment();
                            break;
                        case R.id.propertyManagement:
                            selectedFragment = new ClientServiceFragment();
                            break;
                        case R.id.security:
                            selectedFragment = new ClientSecurityFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.serviceJobs:
                            Bundle bundle = new Bundle();
                            bundle.putString("id",id);
                            selectedFragment = new ClientServiceJobsFragment();
                            selectedFragment.setArguments(bundle);
                            break;
                        case R.id.securityBookings:
                            selectedFragment = new ClientSecurityBookingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
