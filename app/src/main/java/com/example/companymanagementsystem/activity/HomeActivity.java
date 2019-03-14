package com.example.companymanagementsystem.activity;
/**
 * @author Swati Khobragade
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.companymanagementsystem.ManagementApplication;
import com.example.companymanagementsystem.R;
import com.example.companymanagementsystem.fragment.DeveloperInfoFragment;
import com.example.companymanagementsystem.fragment.OrganisationInfoFragment;
import com.example.companymanagementsystem.fragment.SettingsFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        Log.i("Person List ::", ManagementApplication.personList.toString());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.i("Trim Memory","Please release some resources !!");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i("Low Memory","Memory too low !!");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_about) {
            Intent intent = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_devInfo) {
            launchFragment(DeveloperInfoFragment.newInstance());
        } else if (itemId == R.id.nav_orgInfo) {
            launchFragment(OrganisationInfoFragment.newInstance());
        } else if (itemId == R.id.nav_settings) {
            launchFragment(SettingsFragment.newInstance());
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * Launch Fragment
     */
    private void launchFragment(Fragment fragmentInstance) {
        DeveloperInfoFragment developerInfoFragment = DeveloperInfoFragment.newInstance();
        Fragment fragment;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        fragment = fragmentInstance;
        transaction.replace(R.id.mainFrame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
