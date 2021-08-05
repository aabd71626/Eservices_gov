package com.eservices.gov.ps.views.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import com.eservices.gov.ps.R;

import java.lang.ref.Reference;

public class CustomlinkButtonItem extends LinearLayout {
    private static final String TAG = "CustomlinkButtonItem";
    private ImageView iconView;
    private TextView titleView, subTitleView;
    private Drawable icon;
    private String title,subTitle;
    private boolean subTitleIsVisibile;

    public CustomlinkButtonItem(Context context) {
        super(context, null);
        init(context,null, 0, 0);
    }

    public CustomlinkButtonItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs, 0, 0);
    }

    public CustomlinkButtonItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs, defStyle, 0);

    }

    @RequiresApi(21)
    public CustomlinkButtonItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setTitle(String title) {
        titleView.setText(title);
        invalidate();
        requestLayout();
    }


    public void setSubTitleViewString(String subTitle) {
        subTitleView.setText(subTitle);
        invalidate();
        requestLayout();
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(getContext(), R.layout.custom_view_link_button, this);
        iconView = findViewById(R.id.custom_view_link_button_icon);
        titleView = findViewById(R.id.custom_view_link_button_title);
        subTitleView = findViewById(R.id.custom_view_link_button_subtitle);
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.attr_custom_link_button_item, defStyleAttr, 0);
        try {
            icon = attributes.getDrawable(R.styleable.attr_custom_link_button_item_iconLinkButton);
            title = attributes.getString(R.styleable.attr_custom_link_button_item_titleLinkButton);
            subTitle = attributes.getString(R.styleable.attr_custom_link_button_item_subTitleLinkButton);
            subTitleIsVisibile = attributes.getBoolean(R.styleable.attr_custom_link_button_item_subTitleLinkButtonIsVisibile,false);

            iconView.setImageDrawable(icon);
            titleView.setText(title);
            subTitleView.setText(subTitle);
            if (subTitleIsVisibile) {
                subTitleView.setVisibility(VISIBLE);
            } else {
                subTitleView.setVisibility(GONE);
            }
        } catch (Exception e) {
            Log.e(TAG, "onCreate: " + e.toString());
        }


        attributes.recycle();
    }
}
