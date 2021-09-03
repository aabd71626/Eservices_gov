package com.eservices.gov.ps.views.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eservices.gov.ps.databinding.FragmentSalaryHistoryBinding;
import com.eservices.gov.ps.models.OnClickSalaryDetails;
import com.eservices.gov.ps.models.Salary;
import com.eservices.gov.ps.views.activities.SalaryDetailsActivity;
import com.eservices.gov.ps.views.adapteres.SalaryHistoryAdapter;

import java.util.LinkedList;
import java.util.List;

public class SalaryHistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final String TAG = "SalaryHistoryFragment";
    private FragmentSalaryHistoryBinding binding;
    private Context context;
    private SalaryHistoryAdapter historyAdapter;
    private List<Salary> salaryList;

    public SalaryHistoryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SalaryHistoryFragment newInstance(String param1, String param2) {
        SalaryHistoryFragment fragment = new SalaryHistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSalaryHistoryBinding.inflate(inflater,container,false);
        context = binding.getRoot().getContext();


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        salaryList = new LinkedList<>();

        salaryList.add(new Salary("1","05/2020","","0 / 0","1341"));
        salaryList.add(new Salary("2","06/2020","","0 / 0","1242"));
        salaryList.add(new Salary("3","07/2020","","0 / 0","1443"));
        salaryList.add(new Salary("4","08/2020","","0 / 0","1544"));
        salaryList.add(new Salary("4","09/2020","","0 / 0","1645"));
        salaryList.add(new Salary("5","10/2020","","0 / 0","1746"));
        salaryList.add(new Salary("6","11/2020","","0 / 0","1847"));

        historyAdapter = new SalaryHistoryAdapter(context, salaryList, new OnClickSalaryDetails() {
            @Override
            public void onClick() {
                Intent intent = new Intent(context, SalaryDetailsActivity.class);
                context.startActivity(intent);
            }
        });
        binding.salaryHistoryRcv.setHasFixedSize(true);
        binding.salaryHistoryRcv.setLayoutManager(new LinearLayoutManager(context));
        binding.salaryHistoryRcv.setAdapter(historyAdapter);
    }
}