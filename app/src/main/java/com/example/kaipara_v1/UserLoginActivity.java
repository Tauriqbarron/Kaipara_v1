package com.example.kaipara_v1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;

import org.json.JSONException;
import org.json.JSONObject;

public class UserLoginActivity extends baseActivity {
    private static final String TAG = "url";
    EditText email,password;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        email = (EditText)findViewById(R.id.loginEmail);
        password= (EditText)findViewById(R.id.loginPassword);
        loginBtn = (Button)findViewById(R.id.btnLogin);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });
    }
    private void jsonParse(){
        Log.e("click check","clicked");
        StringBuilder s = new StringBuilder(100);
        s.append("https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/client/login_client.php");
        s.append("?email=");
        s.append(email.getText());
        s.append("&password=");
        s.append(password.getText());
        String url = s.toString();
        Log.e(TAG, url);
        RequestQueue requestQueue = Volley.newRequestQueue(UserLoginActivity.this );

        JsonObjectRequest objectRequest=new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            if(response.getString("message").equals("Pass")){
                                Intent intent = new Intent(UserLoginActivity.this,ClientHome.class);
                                Log.e("Login Pass","Storing Email");
                                intent.putExtra("email",email.getText().toString());
                                Log.e("Login Pass","moving to Client Home");
                                UserLoginActivity.this.startActivity(intent);
                                Toast.makeText(UserLoginActivity.this, "Login Successful",
                                        Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(UserLoginActivity.this, "Login Failed",
                                        Toast.LENGTH_LONG).show();
                                password.getText().clear();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("API Response", error.toString());
                    }
                }
        );
        requestQueue.add(objectRequest);
    }
}