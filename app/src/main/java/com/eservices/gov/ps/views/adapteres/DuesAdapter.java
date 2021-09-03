package com.eservices.gov.ps.views.adapteres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eservices.gov.ps.databinding.CustomArrearsMovementItemBinding;
import com.eservices.gov.ps.models.Dues;

import java.util.List;

public class DuesAdapter extends RecyclerView.Adapter<DuesAdapter.DuesViewHolder> {
    private Context mContext;
    private List<Dues> mDuesList;

    public DuesAdapter(Context mContext, List<Dues> mDuesList) {
        this.mContext = mContext;
        this.mDuesList = mDuesList;
    }

    @NonNull
    @Override
    public DuesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CustomArrearsMovementItemBinding itemBinding = CustomArrearsMovementItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new DuesViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DuesViewHolder holder, int position) {
        Dues dues = mDuesList.get(position);
        holder.itemBinding.arrearsMovementDatetime.setValue(dues.getDateTime());
        holder.itemBinding.arrearsMovementDuesFunds.setValue(dues.getDuesFunds());
        holder.itemBinding.arrearsMovementForDues.setValue(dues.getForDues());
        holder.itemBinding.arrearsMovementForEmployee.setValue(dues.getForEmployee());
        holder.itemBinding.arrearsMovementNotes.setValue(dues.getNotes());
    }

    @Override
    public int getItemCount() {
        return mDuesList.size();
    }

    class DuesViewHolder extends RecyclerView.ViewHolder {
        private CustomArrearsMovementItemBinding itemBinding;
        public DuesViewHolder(@NonNull CustomArrearsMovementItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
