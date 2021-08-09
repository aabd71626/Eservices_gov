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
import com.eservices.gov.ps.models.Additions;
import com.eservices.gov.ps.views.adapteres.CustomSalaryDetailsAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AdditionsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Object> mAdditionsList;
    private CustomSalaryDetailsAdapter additionsAdapter;
    private Context context;
    private FragmentAdditionsBinding binding;

    public AdditionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AdditionsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdditionsFragment newInstance(String param1, String param2) {
        AdditionsFragment fragment = new AdditionsFragment();
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
        binding = FragmentAdditionsBinding.inflate(inflater,container,false);
        context = binding.getRoot().getContext();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdditionsList = new ArrayList<>();

        mAdditionsList.add(new Additions(1,5489,"نفقات طارئة","-","مبلغ","1400"));
        mAdditionsList.add(new Additions(1,5489,"نفقات طارئة","-","مبلغ","1400"));
        mAdditionsList.add(new Additions(1,5489,"نفقات طارئة","-","مبلغ","1400"));
        mAdditionsList.add(new Additions(1,5489,"نفقات طارئة","-","مبلغ","1400"));
        mAdditionsList.add(new Additions(1,5489,"نفقات طارئة","-","مبلغ","1400"));

        additionsAdapter = new CustomSalaryDetailsAdapter(context, new LinkedList<Object>(Arrays.asList(mAdditionsList.toArray())));
        binding.additionsRcv.setHasFixedSize(true);
        binding.additionsRcv.setLayoutManager(new LinearLayoutManager(context));
        binding.additionsRcv.setAdapter(additionsAdapter);

    }
}