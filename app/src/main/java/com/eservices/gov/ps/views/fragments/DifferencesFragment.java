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

import com.eservices.gov.ps.databinding.FragmentDifferencesBinding;
import com.eservices.gov.ps.models.Differences;
import com.eservices.gov.ps.views.adapteres.SalaryDetailsAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DifferencesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DifferencesFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Differences> mDifferencesList;
    private SalaryDetailsAdapter mSalaryDetailsAdapter;
    private Context context;
    private FragmentDifferencesBinding binding;

    public DifferencesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscountsFragment.
     */
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
        binding = FragmentDifferencesBinding.inflate(inflater, container, false);
        context = binding.getRoot().getContext();


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDifferencesList = new ArrayList<>();

        mDifferencesList.add(new Differences("04/2020","-200","-100"));
        mDifferencesList.add(new Differences("","-100","-100"));
        mDifferencesList.add(new Differences("04/2020","-150","-150"));

        mSalaryDetailsAdapter = new SalaryDetailsAdapter(context, new LinkedList<Object>(Arrays.asList(mDifferencesList.toArray())));
        binding.discountsRcv.setHasFixedSize(true);
        binding.discountsRcv.setLayoutManager(new LinearLayoutManager(context));
        binding.discountsRcv.setAdapter(mSalaryDetailsAdapter);

    }
}