package com.example.kaipara_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ClientSecurityFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    String id;
    Spinner type;
    ArrayAdapter<CharSequence> adapter;
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
        adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.security_type,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type.setAdapter(adapter);
        type.setOnItemSelectedListener(this);
        Log.e("Setup","Spinner Adapter set");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
