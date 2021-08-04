package com.eservices.gov.ps.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.eservices.gov.ps.R;
import com.eservices.gov.ps.databinding.ActivityMainBinding;
import com.eservices.gov.ps.utils.SetUpNaveigaton;
import com.eservices.gov.ps.views.fragments.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding mainBinding;
    private static final String TAG = "MainActivity";
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        init();


    }

    private void init() {
        setSupportActionBar(mainBinding.mainToolbar);
        setNavigationDrawer();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment);
        fragmentTransaction.commit();
    }

    private void setNavigationDrawer() {
        try {
            NavigationView navigation = SetUpNaveigaton.setUpNavigationDrawer(this,
                    MainActivity.this, mainBinding.mainDrawerLayout, mainBinding.mainNavigationView, mainBinding.mainMenuIcon);
            navigation.setNavigationItemSelectedListener(this);
        } catch (Exception e) {
            Log.e(TAG, "setNavigationDrawer: " + e.toString());
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        try {

        } catch (Exception e) {
            Log.e(TAG, "onNavigationItemSelected: " + e.toString());
        }
        return false;
    }
}