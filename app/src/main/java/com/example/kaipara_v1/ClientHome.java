package com.example.kaipara_v1;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class ClientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavigationView topNav = findViewById(R.id.top_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListner);
        topNav.setOnNavigationItemSelectedListener(navListnerTop);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListnerTop =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.profile:
                            selectedFragment = new ClientProfileFragment();
                            break;
                        case R.id.propertyManagement:
                            selectedFragment = new ClientServiceFragment();
                            break;
                        case R.id.security:
                            selectedFragment = new ClientSecurityFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
    private BottomNavigationView.OnNavigationItemSelectedListener navListner =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.serviceJobs:
                            selectedFragment = new ClientServiceJobsFragment();
                            break;
                        case R.id.securityBookings:
                            selectedFragment = new ClientSecurityBookingsFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
