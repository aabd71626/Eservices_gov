package com.eservices.gov.ps.views.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import com.eservices.gov.ps.R;
import com.eservices.gov.ps.databinding.ActivitySalaryDetailsBinding;
import com.eservices.gov.ps.views.fragments.AdditionsFragment;
import com.eservices.gov.ps.views.fragments.DifferencesFragment;
import com.eservices.gov.ps.views.fragments.DiscountsFragment;
import com.google.android.material.tabs.TabLayout;

public class SalaryDetailsActivity extends AppCompatActivity {
    private static final String TAG = "SalaryDetailsFragment";
    private ActivitySalaryDetailsBinding binding;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private AdditionsFragment additionsFragment;
    private DiscountsFragment discountsFragment;
    private DifferencesFragment differencesFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySalaryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        init();
    }

    private void init(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.salary_derails_linear_layout_content, new AdditionsFragment());
        fragmentTransaction.commit();
        binding.salaryDerailsTabLayout.addOnTabSelectedListener(onTabSelectedListener);
    }

    TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            try {
                fragmentTransaction = fragmentManager.beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        additionsFragment = new AdditionsFragment();
                        fragmentTransaction.replace(R.id.salary_derails_linear_layout_content,additionsFragment);
                        fragmentTransaction.commit();
                        break;
                    case 1:
                        discountsFragment = new DiscountsFragment();
                        fragmentTransaction.replace(R.id.salary_derails_linear_layout_content, discountsFragment);
                        fragmentTransaction.commit();
                        break;
                    case 2:
                        differencesFragment = new DifferencesFragment();
                        fragmentTransaction.replace(R.id.salary_derails_linear_layout_content, differencesFragment);
                        fragmentTransaction.commit();
                        break;
                }
            } catch (Exception e) {
                Log.e(TAG, "onTabSelectedListener: " + e.toString());
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };
}