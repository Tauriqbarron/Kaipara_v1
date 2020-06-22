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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ClientServiceJobsFragment extends Fragment {
    private String id;
    private RecyclerView recyclerView;
    private ServiceJobsAdapter serviceJobsAdapter;
    private LinearLayoutManager manager;
    private List<ServiceJob> serviceJobs;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_client_service_jobs,container,false);
        Log.e("ID Passed:",getArguments().getString("id"));
        id = getArguments().getString("id");
        serviceJobs = new ArrayList<>();
        Log.e("Setup","Sending request");
        getJobs();
        return view;
    }
    private void setupRV(){
        recyclerView = (RecyclerView) view.findViewById(R.id.serviceJobsRv);
        manager = new LinearLayoutManager(getActivity());
        serviceJobsAdapter = new ServiceJobsAdapter(view.getContext(),serviceJobs);
        Log.e("Setup","setting manager");
        recyclerView.setLayoutManager(manager);
        Log.e("Setup","Setting Adapter");
        recyclerView.setAdapter(serviceJobsAdapter);
    }
    private void getJobs() {
        Log.e("API","Retrieving id");
        StringBuilder s = new StringBuilder(100);
        s.append("https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/applications/get_client_applications.php");
        s.append("?id=");
        s.append(id);
        String url = s.toString();
        Log.e("API Request: ", url);
        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    Log.e("Storing item: ","item number = "+ i);
                    try {
                        JSONObject applicationObject = response.getJSONObject(i);
                        ServiceJob application = new ServiceJob();
                        application.setTitle(applicationObject.getString("title").toString());
                        application.setDescription(applicationObject.getString("description").toString());
                        application.setStatus(applicationObject.getString("status").toString());
                        application.setImagePath(applicationObject.getString("imagePath").toString());
                        application.setPrice(applicationObject.getString("price").toString());
                        application.setDate(applicationObject.getString("date").toString());
                        application.setStreet(applicationObject.getString("street").toString());
                        application.setSuburb(applicationObject.getString("suburb").toString());
                        application.setCity(applicationObject.getString("city").toString());
                        application.setMonth(applicationObject.getString("date").toString());


                        serviceJobs.add(application);
                        Log.e("Storing item: ","Completed item =  "+ serviceJobs.get(i).getTitle());
                        Log.e("Storing item: ","month:  "+ serviceJobs.get(i).getMonth());

                    } catch (JSONException | ParseException e) {
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
        queue.add(jsonObjectRequest);
    }
}
