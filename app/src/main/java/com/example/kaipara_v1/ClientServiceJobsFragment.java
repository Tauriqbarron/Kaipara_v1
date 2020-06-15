package com.example.kaipara_v1;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ClientServiceJobsFragment extends Fragment {
    String id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e("ID Passed:",getArguments().getString("id"));
        id = getArguments().getString("id");
        return inflater.inflate(R.layout.fragment_client_service_jobs,container,false);
    }
}
