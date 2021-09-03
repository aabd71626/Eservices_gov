package com.eservices.gov.ps.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.eservices.gov.ps.R;

public class CustomSalaryInfoItem extends LinearLayout {
    private static final String TAG = "CustomSalaryInfoItem";
    private TextView titleView, valueView;
    private String title,value;
    private float titleTextSize;
    private float valueTextSize;

    public CustomSalaryInfoItem(Context context) {
        super(context, null);
        init(context,null, 0, 0);
    }

    public CustomSalaryInfoItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0, 0);
    }

    public CustomSalaryInfoItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle, 0);

    }

    @RequiresApi(21)
    public CustomSalaryInfoItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTitle(String title) {
        titleView.setText(title);
        invalidate();
        requestLayout();
    }


    public void setValue(String value) {
        valueView.setText(value);
        invalidate();
        requestLayout();
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(getContext(), R.layout.custom_view_salary_info, this);
        titleView = findViewById(R.id.custom_view_salary_info_title);
        valueView = findViewById(R.id.custom_view_salary_info_value);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.attr_custom_salary_info_item, defStyleAttr, 0);
        try {
            title = attributes.getString(R.styleable.attr_custom_salary_info_item_titleSalaryInfo);
            value = attributes.getString(R.styleable.attr_custom_salary_info_item_valueSalaryInfo);
            titleTextSize = attributes.getDimension(R.styleable.attr_custom_salary_info_item_titleTextSize,18);
            valueTextSize = attributes.getDimension(R.styleable.attr_custom_salary_info_item_valueTextSize,24);
            titleView.setText(title);
            titleView.setTextSize(titleTextSize);
            valueView.setText(value);
            valueView.setTextSize(valueTextSize);
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.toString());
        }


        attributes.recycle();
    }
}
