package com.example.kaipara_v1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ClientSecurityBookingOverviewFragment extends Fragment {
    View view;
    TextView type,number,street,suburb,city,postcode,date,start_time,end_time,description;
    HashMap<String,String> inputs;
    String id;
    Button bnConfirm;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // inputs = (ArrayList<KeyValuePair>)getArguments().getSerializable("inputs");
        inputs = new HashMap<String, String>();
        Bundle bundle = getArguments();
        id = getArguments().getString("id");
        inputs = (HashMap<String, String>)bundle.getSerializable("inputs");
        view = inflater.inflate(R.layout.fragment_client_security_booking_overview,container,false);
        try {
            setup();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return view;
    }

    private void setup() throws ParseException {
        type = view.findViewById(R.id.SBFO_type);
        number = view.findViewById(R.id.SBFO_number);
        street = view.findViewById(R.id.SBFO_street);
        suburb = view.findViewById(R.id.SBFO_suburb);
        city = view.findViewById(R.id.SBFO_city);
        postcode = view.findViewById(R.id.SBFO_postcode);
        date = view.findViewById(R.id.SBFO_date);
        start_time = view.findViewById(R.id.SBFO_start_time);
        end_time = view.findViewById(R.id.SBFO_end_time);
        description = view.findViewById(R.id.SBFO_description);
        setInputs();
    }

    private void setInputs() throws ParseException {
        type.setText(inputs.get("type"));
        number.setText(inputs.get("number"));
        street.setText(inputs.get("street"));
        suburb.setText(inputs.get("suburb"));
        city.setText(inputs.get("city"));
        postcode.setText(inputs.get("postcode"));

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        Date dateF = dateFormat.parse(inputs.get("start_date"));
        date.setText(dateFormat.format(dateF));

        SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
        Date start = format.parse(inputs.get("start_time"));
        Date end = format.parse(inputs.get("end_time"));
        start_time.setText(format.format(start));
        end_time.setText(format.format(end));
        description.setText(inputs.get("description"));
        btnSetup();
    }

    private void btnSetup() {
        bnConfirm = view.findViewById(R.id.SBFO_btn_confirm);
        bnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
