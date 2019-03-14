package com.example.companymanagementsystem.activity;
/**
 * @author Swati Khobragade
 */

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.companymanagementsystem.R;
import com.example.companymanagementsystem.adapter.AboutPagerAdapter;

public class AboutActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private AboutPagerAdapter aboutPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        initViews();
        setAdapter();
    }

    /**
     * Initialize the views
     */
    private void initViews() {
        viewPager = findViewById(R.id.viewPagerAbout);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * Set Adapter to ViewPager
     */
    private void setAdapter() {
        aboutPagerAdapter = new AboutPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(aboutPagerAdapter);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
