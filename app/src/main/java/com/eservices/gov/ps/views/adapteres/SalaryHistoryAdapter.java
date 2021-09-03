package com.eservices.gov.ps.views.adapteres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eservices.gov.ps.databinding.CustomSalaryHistoryItemBinding;
import com.eservices.gov.ps.models.OnClickSalaryDetails;
import com.eservices.gov.ps.models.Salary;

import java.util.List;

public class SalaryHistoryAdapter extends RecyclerView.Adapter<SalaryHistoryAdapter.CustomSalaryViewHolder> {

    private Context mContext;
    private List<Salary> mSalaryList;
    private OnClickSalaryDetails clickSalaryDetails;
    public SalaryHistoryAdapter(Context mContext, List<Salary> mSalaryList) {
        this.mContext = mContext;
        this.mSalaryList = mSalaryList;
    }

    public SalaryHistoryAdapter(Context mContext, List<Salary> mSalaryList, OnClickSalaryDetails clickSalaryDetails) {
        this.mContext = mContext;
        this.mSalaryList = mSalaryList;
        this.clickSalaryDetails = clickSalaryDetails;
    }

    @NonNull
    @Override
    public CustomSalaryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomSalaryHistoryItemBinding salaryHistoryItemBinding = CustomSalaryHistoryItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CustomSalaryViewHolder(salaryHistoryItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomSalaryViewHolder holder, int position) {
        Salary salary = mSalaryList.get(position);
        holder.itemBinding.salaryHistoryNum.setText(salary.getNum());
        holder.itemBinding.salaryHistoryDatetime.setText(salary.getDateTime());
        holder.itemBinding.salaryHistoryCategory.setText(salary.getCategory());
        holder.itemBinding.salaryHistoryType.setText(salary.getType());
        holder.itemBinding.salaryHistoryInBank.setText(salary.getInBank());
    }

    @Override
    public int getItemCount() {
        return mSalaryList.size();
    }


    class CustomSalaryViewHolder extends RecyclerView.ViewHolder {
        private CustomSalaryHistoryItemBinding itemBinding;

        public CustomSalaryViewHolder(CustomSalaryHistoryItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            itemBinding.salaryHistoryProcedure.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                  clickSalaryDetails.onClick();
                }
            });
        }
    }

}
