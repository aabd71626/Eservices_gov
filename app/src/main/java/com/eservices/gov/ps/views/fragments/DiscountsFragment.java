package com.eservices.gov.ps.views.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eservices.gov.ps.R;
import com.eservices.gov.ps.databinding.FragmentAdditionsBinding;
import com.eservices.gov.ps.databinding.FragmentDiscountsBinding;
import com.eservices.gov.ps.models.Additions;
import com.eservices.gov.ps.models.Discounts;
import com.eservices.gov.ps.views.adapteres.CustomSalaryDetailsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DiscountsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Object> mDiscountsList;
    private CustomSalaryDetailsAdapter mSalaryDetailsAdapter;
    private Context context;
    private FragmentDiscountsBinding binding;

    public DiscountsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DiscountsFragment newInstance(String param1, String param2) {
        DiscountsFragment fragment = new DiscountsFragment();
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
        binding = FragmentDiscountsBinding.inflate(inflater, container, false);
        context = binding.getRoot().getContext();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDiscountsList = new ArrayList<>();

        mDiscountsList.add(new Discounts(1, 8754, "نفقات طارئة1", "-", "مبلغ", "1400"));
        mDiscountsList.add(new Discounts(2, 1283, "نفقات طارئة2", "-", "مبلغ", "1500"));
        mDiscountsList.add(new Discounts(3, 6589, "نفقات طارئة3", "-", "مبلغ", "1400"));
        mDiscountsList.add(new Discounts(4, 5489, "نفقات طارئة4", "-", "مبلغ", "2000"));
        mDiscountsList.add(new Discounts(5, 7896, "نفقات طارئة5", "-", "مبلغ", "8000"));

        mSalaryDetailsAdapter = new CustomSalaryDetailsAdapter(context, new LinkedList<Object>(Arrays.asList(mDiscountsList.toArray())));
        binding.discountsRcv.setHasFixedSize(true);
        binding.discountsRcv.setLayoutManager(new LinearLayoutManager(context));
        binding.discountsRcv.setAdapter(mSalaryDetailsAdapter);

    }
}