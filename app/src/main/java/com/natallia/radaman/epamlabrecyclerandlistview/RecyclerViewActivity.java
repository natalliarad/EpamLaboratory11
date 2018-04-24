package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;
import com.squareup.picasso.Picasso;

public class RecyclerViewActivity extends AppCompatActivity implements FragmentCoordinator {
    private DrawerLayout mDrawerLayout;
    private FragmentManager fragmentManager;
    FragmentRecyclerView fragmentRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.open_drawer, R.string.close_drawer);
        toggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                toggle.onDrawerSlide(drawerView, slideOffset);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        ImageView imageView = navigationView.getHeaderView(0)
                .findViewById(R.id.nav_header_image);
        if (isOnline())
            Picasso.get().load("http://www.paddleinspain.com/images/l/canary-islands-jpg-183.jpg")
                    .into(imageView);
        else
            imageView.setImageResource(R.drawable.ic_no_internet_photo_24dp);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        selectDrawerItem(item);
                        return true;
                    }
                }
        );


        fragmentManager = getSupportFragmentManager();
        fragmentRecyclerView = new FragmentRecyclerView();

        backToList();
    }

    protected boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context
                .CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting())
            return true;
        else
            return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectDrawerItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list_view_example:
                Intent intent = new Intent(this, ListViewActivity.class);
                startActivity(intent);
            default:
                break;
        }

        item.setChecked(true);
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
    }

    @Override
    public void onPlaceListItemSelected(int position) {
        PlaceDetailFragment detailFragment = PlaceDetailFragment.newInstance(position);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            fragmentManager.beginTransaction().replace(R.id.content_frame, detailFragment)
                    .addToBackStack(null).commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            fragmentManager.beginTransaction().replace(R.id.detail_container, detailFragment)
                    .commit();

    }

    @Override
    public void onEditButtonClick(int index) {
        PlaceDetailEditFragment placeDetailEditFragment = PlaceDetailEditFragment.newInstance(index);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            fragmentManager.beginTransaction().replace(R.id.content_frame, placeDetailEditFragment)
                    .addToBackStack(null).commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            fragmentManager.beginTransaction().replace(R.id.detail_container, placeDetailEditFragment)
                    .commit();
    }

    @Override
    public void backToList() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragmentRecyclerView)
                    .commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            fragmentManager.beginTransaction().replace(R.id.list_container, fragmentRecyclerView)
                    .commit();
    }
}
