package com.eservices.gov.ps.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.eservices.gov.ps.R;
import com.google.android.material.navigation.NavigationView;

import static android.content.Context.MODE_PRIVATE;

public class SetUpNaveigaton {
    private static DrawerLayout mDrawerLayout;
    private static SharedPreferences sharedPreferences;

    public static NavigationView setUpNavigationDrawer(final Context context, Activity activity,
                                                       DrawerLayout drawerLayout, NavigationView navigationView, ImageView menu) {
        try {
            mDrawerLayout = drawerLayout;
            sharedPreferences = context.getSharedPreferences("User", MODE_PRIVATE);
            ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, null, R.string.drawer_open, R.string.drawer_close);
            drawerLayout.addDrawerListener(drawerToggle);
            drawerToggle.syncState();

            menu.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View v) {
                    SetUpNaveigaton.getmDrawerLayout().openDrawer(Gravity.RIGHT);
                }
            });
        } catch (Exception e) {
            Log.e("setUpNavigationDrawer", e.getMessage());
        }
        return navigationView;
    }

    public static DrawerLayout getmDrawerLayout() {
        return mDrawerLayout;
    }
}
