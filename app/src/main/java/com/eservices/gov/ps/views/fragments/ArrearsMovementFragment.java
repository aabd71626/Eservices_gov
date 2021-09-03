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
import com.eservices.gov.ps.databinding.FragmentArrearsMovementBinding;
import com.eservices.gov.ps.models.Dues;
import com.eservices.gov.ps.views.adapteres.DuesAdapter;

import java.util.ArrayList;
import java.util.List;

public class ArrearsMovementFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private DuesAdapter mDuesAdapter;
    private FragmentArrearsMovementBinding binding;
    private List<Dues> mDuesList;
    private Context mContext;

    public ArrearsMovementFragment() {
        // Required empty public constructor
    }

    public static ArrearsMovementFragment newInstance(String param1, String param2) {
        ArrearsMovementFragment fragment = new ArrearsMovementFragment();
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
        binding = FragmentArrearsMovementBinding.inflate(inflater, container, false);
        mContext = binding.getRoot().getContext();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mDuesList = new ArrayList<>();
        mDuesList.add(new Dues("01/2020","475.15","1000","475.15","رصيد سابق"));
        mDuesList.add(new Dues("01/2020","475.15","1000","475.15","رصيد سابق"));
        mDuesList.add(new Dues("01/2020","475.15","1000","475.15",""));
        mDuesList.add(new Dues("01/2020","475.15","1000","475.15","رصيد سابق"));
        mDuesList.add(new Dues("01/2020","475.15","1000","475.15","رصيد سابق"));

        mDuesAdapter = new DuesAdapter(mContext,mDuesList);
        binding.arrearsMovementRcv.setHasFixedSize(true);
        binding.arrearsMovementRcv.setLayoutManager(new LinearLayoutManager(mContext));
        binding.arrearsMovementRcv.setAdapter(mDuesAdapter);
    }
}