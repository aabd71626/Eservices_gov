package com.eservices.gov.ps.views.adapteres;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eservices.gov.ps.databinding.CustomAdditionsItemBinding;
import com.eservices.gov.ps.databinding.CustomDifferencesItemBinding;
import com.eservices.gov.ps.models.Additions;
import com.eservices.gov.ps.models.Differences;
import com.eservices.gov.ps.models.Discounts;

import java.util.List;

public class SalaryDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Object> mObjectsList;
    private static final int ADDITIONS_ITEM_VIEW_TYPE = 0;
    private static final int DIFFERENCES_VIEW_TYPE = 1;
    private static final int DISCOUNTS_VIEW_TYPE = 2;

    public SalaryDetailsAdapter(Context mContext, List<Object> mObjectsList) {
        this.mContext = mContext;
        this.mObjectsList = mObjectsList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case DIFFERENCES_VIEW_TYPE:
                CustomDifferencesItemBinding differencesItemBinding = CustomDifferencesItemBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CustomDifferencesViewHolder(differencesItemBinding);
            case DISCOUNTS_VIEW_TYPE:
                CustomAdditionsItemBinding discountItemBinding = CustomAdditionsItemBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CustomAdditionsViewHolder(discountItemBinding);
            case ADDITIONS_ITEM_VIEW_TYPE:
                CustomAdditionsItemBinding additionsItemBinding = CustomAdditionsItemBinding
                        .inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new CustomAdditionsViewHolder(additionsItemBinding);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case DIFFERENCES_VIEW_TYPE:
                CustomDifferencesViewHolder differences_vh = (CustomDifferencesViewHolder) holder;
                Differences differences = (Differences) mObjectsList.get(position);
                differences_vh.itemBinding.additionsNum.setText(String.valueOf(differences.getDateTime()));
                differences_vh.itemBinding.additionsCodeNum.setText(String.valueOf(differences.getPayableSalaries()));
                differences_vh.itemBinding.additionsTitle.setText(differences.getTotal());
                break;
            case DISCOUNTS_VIEW_TYPE:
                CustomAdditionsViewHolder discounts_vh = (CustomAdditionsViewHolder) holder;
                Discounts discounts = (Discounts) mObjectsList.get(position);
                discounts_vh.itemBinding.additionsNum.setText(String.valueOf(discounts.getNum()));
                discounts_vh.itemBinding.additionsCodeNum.setText(String.valueOf(discounts.getCodeNum()));
                discounts_vh.itemBinding.additionsTitle.setText(discounts.getAdditionsTitle());
                discounts_vh.itemBinding.additionsAmount.setText(discounts.getAmount());
                discounts_vh.itemBinding.additionsDescription.setText(discounts.getDescription());
                discounts_vh.itemBinding.additionsAmountMoney.setText(discounts.getAmountMoney());
                break;
            case ADDITIONS_ITEM_VIEW_TYPE:
                CustomAdditionsViewHolder additions_vh = (CustomAdditionsViewHolder) holder;
                Additions additions = (Additions) mObjectsList.get(position);
                additions_vh.itemBinding.additionsNum.setText(String.valueOf(additions.getNum()));
                additions_vh.itemBinding.additionsCodeNum.setText(String.valueOf(additions.getCodeNum()));
                additions_vh.itemBinding.additionsTitle.setText(additions.getAdditionsTitle());
                additions_vh.itemBinding.additionsAmount.setText(additions.getAmount());
                additions_vh.itemBinding.additionsDescription.setText(additions.getDescription());
                additions_vh.itemBinding.additionsAmountMoney.setText(additions.getAmountMoney());
                break;
            default:
                return;
        }
    }


    @Override
    public int getItemCount() {
        return mObjectsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object objectItem = mObjectsList.get(position);
        if (objectItem instanceof Differences) {
            return DIFFERENCES_VIEW_TYPE;
        } else if (objectItem instanceof Discounts) {
            return DISCOUNTS_VIEW_TYPE;
        } else {
            return ADDITIONS_ITEM_VIEW_TYPE;
        }
    }

    class CustomAdditionsViewHolder extends RecyclerView.ViewHolder {
        private CustomAdditionsItemBinding itemBinding;

        public CustomAdditionsViewHolder(CustomAdditionsItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }


    class CustomDifferencesViewHolder extends RecyclerView.ViewHolder {
        private CustomDifferencesItemBinding itemBinding;

        public CustomDifferencesViewHolder(CustomDifferencesItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
