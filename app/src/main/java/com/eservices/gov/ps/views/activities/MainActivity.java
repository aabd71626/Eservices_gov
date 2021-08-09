package com.eservices.gov.ps.views.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;

import com.eservices.gov.ps.R;
import com.eservices.gov.ps.databinding.ActivityMainBinding;
import com.eservices.gov.ps.models.Additions;
import com.eservices.gov.ps.utils.SetUpNaveigaton;
import com.eservices.gov.ps.views.fragments.AdditionsFragment;
import com.eservices.gov.ps.views.fragments.ArrearsDetailsFragment;
import com.eservices.gov.ps.views.fragments.DifferencesFragment;
import com.eservices.gov.ps.views.fragments.DiscountsFragment;
import com.eservices.gov.ps.views.fragments.HomeFragment;
import com.eservices.gov.ps.views.fragments.SalaryHistoryFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding mainBinding;
    private static final String TAG = "MainActivity";
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private ArrearsDetailsFragment arrearsDetailsFragment;
    private SalaryHistoryFragment salaryHistoryFragment;

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
        fragmentTransaction.disallowAddToBackStack();
        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.main_fragment, homeFragment,"home");
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

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        try {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.disallowAddToBackStack();
            switch (item.getItemId()){
                case R.id.menu_home:
                    homeFragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.main_fragment, homeFragment,"home");
                    fragmentTransaction.commit();
                    break;
                case R.id.menu_salary:
                    salaryHistoryFragment = new SalaryHistoryFragment();
                    fragmentTransaction.replace(R.id.main_fragment, salaryHistoryFragment,"salary_details");
                    fragmentTransaction.commit();
                    break;
                case R.id.menu_arrears_details:
                    arrearsDetailsFragment = new ArrearsDetailsFragment();
                    fragmentTransaction.replace(R.id.main_fragment, arrearsDetailsFragment,"arrears_details");
                    fragmentTransaction.commit();
                    break;
                case R.id.menu_tuition_fees:
                    break;
                case R.id.menu_arrears_movement:
                    break;
                case R.id.menu_website:
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mof.gov.ps"));
                    startActivity(browserIntent);
                    break;
            }
            mainBinding.mainDrawerLayout.closeDrawers();
        } catch (Exception e) {
            Log.e(TAG, "onNavigationItemSelected: " + e.toString());
        }
        return false;
    }
}