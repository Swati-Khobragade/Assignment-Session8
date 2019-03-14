package com.example.companymanagementsystem.adapter;
/**
 * @author Swati Khobragade
 */

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.companymanagementsystem.fragment.ApplicationVersionFragment;
import com.example.companymanagementsystem.fragment.ApplicationInfoFragment;
import com.example.companymanagementsystem.fragment.DeviceInfoFragment;

public class AboutPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 3;

    /**
     * @param fragmentManager
     */
    public AboutPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                fragment = ApplicationInfoFragment.newInstance();
                break;
            case 1: // Fragment # 0 - This will show FirstFragment different title
                fragment = DeviceInfoFragment.newInstance();
                break;
            case 2: // Fragment # 1 - This will show SecondFragment
                fragment = ApplicationVersionFragment.newInstance();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Application Information";
            case 1:
                return "Device Information";
            case 2:
                return "Application Version";
            default:
                return null;
        }
    }
}
