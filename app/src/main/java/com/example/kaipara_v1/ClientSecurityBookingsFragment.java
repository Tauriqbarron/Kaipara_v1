package com.example.kaipara_v1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;

public class ClientSecurityBookingsFragment extends Fragment {
    View view;
    ConstraintLayout expandableView;
    Button arrowBtn;
    CardView cardView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_client_security_bookings,container,false);
        setup();
        btnSetup();
        return view;
    }

    private void setup(){
        expandableView = view.findViewById(R.id.expandView);
        Log.e("Setup", "setting up btn " );
        arrowBtn = view.findViewById(R.id.arrowbtn);
        cardView = view.findViewById(R.id.card);
    }
    private void btnSetup(){
        Log.e("Setup", "setting up btn Listener " );

        arrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expandableView.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.VISIBLE);

                }else{
                    TransitionManager.beginDelayedTransition(cardView,new AutoTransition());
                    expandableView.setVisibility(View.GONE);
                }
            }
        });
    }
}
