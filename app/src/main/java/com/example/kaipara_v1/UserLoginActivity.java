package com.example.kaipara_v1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
    TextView sign;
    Button loginBtn,serviceBtn,clientBtn;
    int usertype;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setup();
    }

    private void setup() {
        usertype = 1;
        email = (EditText)findViewById(R.id.loginEmail);
        password= (EditText)findViewById(R.id.loginPassword);
        loginBtn = (Button)findViewById(R.id.btnLogin);
        clientBtn = (Button)findViewById(R.id.btnclient);
        serviceBtn = (Button)findViewById(R.id.btnService);
        sign = (TextView)findViewById(R.id.sign_in);
        logo = (ImageView)findViewById(R.id.logo);
        logo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                usertype = 3;
                sign.setText("Staff Login");
                return true;
            }
        });
        clientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype = 1;
                sign.setText("Signing in as Client");
                clientBtn.setBackgroundResource(R.drawable.login_selected);
                serviceBtn.setBackgroundResource(R.drawable.login_unselected);
            }
        });
        serviceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertype = 2;
                sign.setText("Signing in as Service Provider");
                clientBtn.setBackgroundResource(R.drawable.login_unselected);
                serviceBtn.setBackgroundResource(R.drawable.login_selected);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (usertype){
                    case 1:
                        jsonParseClient();
                    break;
                    case 2:
                        jsonParseService();
                        break;

                    case 3:
                        jsonParseStaff();
                        break;
                }
            }
        });
    }

    private void jsonParseStaff() {
    }

    private void jsonParseService() {
        Log.e("click check","clicked");
        StringBuilder s = new StringBuilder(100);
        s.append("https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/serviceprovider/login.php");
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
                                Intent intent = new Intent(UserLoginActivity.this,ServiceHome.class);
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

    private void jsonParseClient(){
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