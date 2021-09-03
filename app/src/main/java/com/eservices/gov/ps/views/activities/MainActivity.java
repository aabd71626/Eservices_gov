package com.eservices.gov.ps.views.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.eservices.gov.ps.R;
import com.eservices.gov.ps.databinding.ActivityMainBinding;

import com.eservices.gov.ps.databinding.AppBarMainBinding;
import com.eservices.gov.ps.models.Additions;
import com.eservices.gov.ps.utils.SetUpNaveigaton;
import com.eservices.gov.ps.views.fragments.AdditionsFragment;
import com.eservices.gov.ps.views.fragments.ArrearsDetailsFragment;
import com.eservices.gov.ps.views.fragments.ArrearsMovementFragment;
import com.eservices.gov.ps.views.fragments.DifferencesFragment;
import com.eservices.gov.ps.views.fragments.DiscountsFragment;
import com.eservices.gov.ps.views.fragments.HomeFragment;
import com.eservices.gov.ps.views.fragments.SalaryHistoryFragment;
import com.eservices.gov.ps.views.fragments.TransportationFragment;
import com.eservices.gov.ps.views.fragments.TuitionFeesFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding mainBinding;
    private AppBarMainBinding appBarMainBinding;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private ArrearsDetailsFragment arrearsDetailsFragment;
    private ArrearsMovementFragment arrearsMovementFragment;
    private SalaryHistoryFragment salaryHistoryFragment;
    private TuitionFeesFragment tuitionFeesFragment;
    private TransportationFragment transportationFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        init();

    }

    @SuppressLint("RestrictedApi")
    private void init() {
        appBarMainBinding = mainBinding.includeAppbar;
        setSupportActionBar(appBarMainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, mainBinding.mainDrawerLayout,
                appBarMainBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mainBinding.mainDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        mainBinding.mainNavigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.disallowAddToBackStack();
        homeFragment = new HomeFragment();
        fragmentTransaction.replace(R.id.nav_host_fragment, homeFragment,"home");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (mainBinding.mainDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
            mainBinding.mainDrawerLayout.closeDrawer(Gravity.RIGHT);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        try {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.disallowAddToBackStack();
            switch (item.getItemId()){
                case R.id.nav_home:
                    homeFragment = new HomeFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, homeFragment,"home");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_salary:
                    salaryHistoryFragment = new SalaryHistoryFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, salaryHistoryFragment,"salary_details");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_arrears_details:
                    arrearsDetailsFragment = new ArrearsDetailsFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, arrearsDetailsFragment,"arrears_details");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_tuition_fees_new:
                    tuitionFeesFragment = new TuitionFeesFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, tuitionFeesFragment,"tuition_fees");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_tuition_fees_old:
//                    tuitionFeesFragment = new TuitionFeesFragment();
//                    fragmentTransaction.replace(R.id.nav_host_fragment, tuitionFeesFragment,"tuition_fees");
//                    fragmentTransaction.commit();
                    break;
                case R.id.nav_arrears_movement:
                    arrearsMovementFragment = new ArrearsMovementFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, arrearsMovementFragment,"arrears_details");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_transportation:
                    transportationFragment = new TransportationFragment();
                    fragmentTransaction.replace(R.id.nav_host_fragment, transportationFragment,"transportation");
                    fragmentTransaction.commit();
                    break;
                case R.id.nav_website:
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