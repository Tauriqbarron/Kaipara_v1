package com.example.kaipara_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;

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

public class ClientSecurityBookingsFragment extends Fragment {
    View view;
    private String id;
    private RecyclerView recyclerView;
    private SecuirtyBookingsAdapter secuirtyBookingsAdapter;
    private LinearLayoutManager manager;
    private List<SecurityBookings> securityBookings;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_client_security_bookings,container,false);
        Log.e("ID Passed:",getArguments().getString("id"));
        id = getArguments().getString("id");
        securityBookings = new ArrayList<>();
        Log.e("Setup","Sending request");
        getBookings();
        return view;
    }
    private void setupRV(){
        recyclerView = (RecyclerView) view.findViewById(R.id.securityBookingsRV);
        manager = new LinearLayoutManager(getActivity());
        secuirtyBookingsAdapter = new SecuirtyBookingsAdapter(view.getContext(),securityBookings);
        Log.e("Setup","setting manager");
        recyclerView.setLayoutManager(manager);
        Log.e("Setup","Setting Adapter");
        recyclerView.setAdapter(secuirtyBookingsAdapter);
    }

    private void getBookings() {
        Log.e("API","Retrieving id");
        StringBuilder s = new StringBuilder(100);
        s.append("https://kaipara-v1.herokuapp.com/php_rest_kiapara/api/bookings/get_client_bookings.php");
        s.append("?id=");
        s.append(id);
        String url = s.toString();
        Log.e("API Request: ", url);
        RequestQueue queue = Volley.newRequestQueue(this.getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    Log.e("Storing Booking: ", "item number = " + i);
                    try {
                        JSONObject bookingObject = response.getJSONObject(i);
                        SecurityBookings booking = new SecurityBookings();
                        booking.setDescription(bookingObject.getString("description").toString());
                        booking.setPrice(bookingObject.getString("price").toString());
                        booking.setStatus(bookingObject.getString("status").toString());
                        booking.setStreet(bookingObject.getString("street").toString());
                        booking.setSuburb(bookingObject.getString("suburb").toString());
                        booking.setCity(bookingObject.getString("city").toString());
                        booking.setStart_date(bookingObject.getString("date").toString());
                        booking.setEnd_date(bookingObject.getString("end_date").toString());
                        booking.setStart_time(bookingObject.getString("start_time").toString());
                        booking.setEnd_time(bookingObject.getString("finish_time").toString());
                        securityBookings.add(booking);
                        Log.e("Storing item: ", "Completed item =  " + securityBookings.get(i).getDescription());
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
        queue.add(jsonArrayRequest);
    }


}
