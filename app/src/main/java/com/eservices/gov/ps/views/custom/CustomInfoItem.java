package com.eservices.gov.ps.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.eservices.gov.ps.R;

public class CustomInfoItem extends LinearLayout {
    private static final String TAG = "CustomInfoItem";
    private TextView titleView, valueView;
    private String title,value;

    public CustomInfoItem(Context context) {
        super(context, null);
        init(context,null, 0, 0);
    }

    public CustomInfoItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0, 0);
    }

    public CustomInfoItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle, 0);

    }

    @RequiresApi(21)
    public CustomInfoItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
        inflate(getContext(), R.layout.custom_view_info, this);
        titleView = findViewById(R.id.custom_view_info_title);
        valueView = findViewById(R.id.custom_view_info_value);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.attr_custom_info_item, defStyleAttr, 0);
        try {
            title = attributes.getString(R.styleable.attr_custom_info_item_titleInfo);
            value = attributes.getString(R.styleable.attr_custom_info_item_valueInfo);
            Log.e(TAG, "CustomInfoItem: "+title);
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.toString());
        }
        titleView.setText(title);
        valueView.setText(value);

        attributes.recycle();
    }
}
