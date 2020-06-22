package com.example.kaipara_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ServiceApplicationsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ApplicationsAdapter applicationsAdapter;
    private LinearLayoutManager manager;
    private List<Application> applications;
    private Button acceptBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_service_applications,container,false);
        Log.e("ID Passed:",getArguments().getString("id"));
        String id = getArguments().getString("id");
        applications = new ArrayList<>();
        Log.e("Setup","Sending request");
        getApplications();
        return view;
    }

    private void setupRV(){
        recyclerView = (RecyclerView) view.findViewById(R.id.applicationsRV);
        manager = new LinearLayoutManager(getActivity());
        applicationsAdapter = new ApplicationsAdapter(view.getContext(),applications);
        Log.e("Setup","setting manager");
        recyclerView.setLayoutManager(manager);
        Log.e("Setup","Setting Adapter");
        recyclerView.setAdapter(applicationsAdapter);
    }

    private void accept(String id, String sp_id){

    }

    private void getApplications() {
        String url = "https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/applications/get_available.php";
        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    Log.e("Storing Application: ", "item number = " + i);
                    try {
                        JSONObject applicationObjt = response.getJSONObject(i);
                        Application application = new Application();

                        application.setTitle(applicationObjt.getString("title").toString());
                        application.setDescription(applicationObjt.getString("description"));
                        application.setPrice(applicationObjt.getString("price"));
                        application.setNumber(applicationObjt.getString("number"));
                        application.setImgPath(applicationObjt.getString("imagePath"));
                        application.setStreet(applicationObjt.getString("street"));
                        application.setSuburb(applicationObjt.getString("suburb"));
                        application.setCity(applicationObjt.getString("city"));
                        application.setName(applicationObjt.getString("f_name"),
                                applicationObjt.getString("l_name"));
                        application.setType(applicationObjt.getString("type"));
                        application.setAddress(application.getStreet(), application.getSuburb(),
                                application.getCity());


                        applications.add(application);
                        Log.e("Storing item: ", "Completed item =  " + application.getAddress());
                        Log.e("Storing item: ", "Completed item =  " + application.getName());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setupRV();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("error: ","ErrorResponce " + error.getMessage());

            }
        }
        );
        queue.add(jsonArrayRequest);
    }
}
