package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ImageButton imageButtonOpenRecycler;
    private ImageButton imageButtonOpenList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonOpenRecycler = findViewById(R.id.openRecyclerView);
        imageButtonOpenRecycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(v, R.id.openRecyclerView);
            }
        });

        imageButtonOpenList = findViewById(R.id.openListView);
        imageButtonOpenList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(v, R.id.openListView);
            }
        });

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

    private void openActivity(View view, int flag) {
        Intent intent;
        switch (flag) {
            case R.id.openRecyclerView:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
            case R.id.openListView:
                intent = new Intent(this, ListViewActivity.class);
                break;
            default:
                intent = new Intent(this, RecyclerViewActivity.class);
                break;
        }
        startActivity(intent);
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
        Fragment fragment = null;
        Class fragmentClass;

        switch (item.getItemId()) {
            case R.id.recycler_view_example:
                fragmentClass = FragmentRecyclerView.class;
                break;
            case R.id.list_view_example:
                fragmentClass = FragmentListView.class;
                break;
            default:
                fragmentClass = FragmentRecyclerView.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        item.setChecked(true);
        setTitle(item.getTitle());
        mDrawerLayout.closeDrawers();
    }
}
