package com.example.kaipara_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ClientSecurityFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String id;
    EditText descriptionTxt,streetTxt,suburbTxt,cityTxt,postTxt;
    TextView durationTxt,numberP;
    Button btnConfrim;
    DatePicker startdate1;
    TimePicker time1;
    Spinner type;
    SeekBar seekBar;
    List<KeyValuePair> inputList;
    ArrayAdapter<CharSequence> adapter;
    RadioButton addressRB;
    Boolean addressFlag;

    CalendarView calendar;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_client_security,container,false);
        setup();
        return view;
    }

    private void setup(){
        Log.e("Setup","Setting up spinner");
        type = view.findViewById(R.id.SBF_type_input);
        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.security_type,android.R.layout.simple_selectable_list_item);
        adapter.setDropDownViewResource(android.R.layout.simple_selectable_list_item);
        type.setAdapter(adapter);
        type.setOnItemSelectedListener(this);
        Log.e("Setup","Spinner Adapter set");
        descriptionTxt = view.findViewById(R.id.SBF_description);
        streetTxt = view.findViewById(R.id.SBF_street);
        cityTxt = view.findViewById(R.id.SBF_city);
        suburbTxt = view.findViewById(R.id.SBF_suburb);
        postTxt = view.findViewById(R.id.SBF_postcode);
        durationTxt = view.findViewById(R.id.SBF_lbl_duration);
        durationTxt.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "12")});
        startdate1 = view.findViewById(R.id.SBF_date);
        time1 = view.findViewById(R.id.SBF_start_time);
        seekBar = view.findViewById(R.id.SBF_number);
        numberP = view.findViewById(R.id.SBF_number_preview);
        seekbarSetup();
        btnConfrimSetup();
    }
    private void seekbarSetup(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 int change = seekBar.getProgress();
                 numberP.setText(Integer.toString(change));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
   private void btnConfrimSetup(){
        btnConfrim = view.findViewById(R.id.SBF_btn_confirm);

        btnConfrim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String typeI,descriptionI,streetI,suburbI,cityI,postcodeI,dateI,end_dateI
                        ,start_timeI, end_timeI,number;
                typeI = type.getSelectedItem().toString();
                number = Integer.toString(seekBar.getProgress());
                descriptionI = descriptionTxt.getText().toString();
                streetI = streetTxt.getText().toString();
                cityI = cityTxt.getText().toString();
                postcodeI = postTxt.getText().toString();
                suburbI = suburbTxt.getText().toString();
                int month = startdate1.getMonth();
                int year = startdate1.getYear();
                int day =startdate1.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,month,day);
                dateI = calendar.getTime().toString();
                int hour = time1.getHour();
                int minute =time1.getMinute();
                start_timeI = (hour)+"."+(minute);
                //int duration = Integer.parseInt(durationTxt.getText().toString());
                Calendar cal = Calendar.getInstance();
                cal.set(year,month,day,hour,minute);
                cal.add(Calendar.HOUR,hour);
                end_timeI = cal.get(Calendar.HOUR)+"."+cal.get(Calendar.MINUTE);
                end_dateI = cal.getTime().toString();
                inputList = new ArrayList<>();
                inputList.add(new KeyValuePair("type",typeI));
                inputList.add(new KeyValuePair("description",descriptionI));
                inputList.add(new KeyValuePair("street",streetI));
                inputList.add(new KeyValuePair("suburb",suburbI));
                inputList.add(new KeyValuePair("city",cityI));
                inputList.add(new KeyValuePair("postcode",postcodeI));
                inputList.add(new KeyValuePair("start_date",dateI));
                inputList.add(new KeyValuePair("end_date",end_dateI));
                inputList.add(new KeyValuePair("start_time",start_timeI));
                inputList.add(new KeyValuePair("end_time",end_timeI));
                inputList.add(new KeyValuePair("number",number));
                Fragment confirmFrag = new ClientSecurityBookingOverviewFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,confirmFrag).commit();
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public static class KeyValuePair {
        private String key;
        private String value;
        public KeyValuePair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
