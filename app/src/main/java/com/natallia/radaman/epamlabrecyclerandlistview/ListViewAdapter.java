package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.natallia.radaman.epamlabrecyclerandlistview.Model.Place;
import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ListViewAdapter extends BaseAdapter implements View.OnClickListener {
    public List<Place> placeList;
    public Context context;
    public LayoutInflater layoutInflater;
    public FragmentCoordinator callbackActivity;

    TextView titleTextView;
    TextView addressTextView;
    TextView ratingTextView;
    ImageView itemImageView;
    CardView itemCardView;


    public ListViewAdapter(List<Place> placeList, Context context) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.placeList = placeList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return placeList.size();
    }

    @Override
    public Object getItem(int position) {
        return placeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.place_item_layout, parent, false);
        titleTextView = convertView.findViewById(R.id.place_item_title_text_view);
        addressTextView = convertView.findViewById(R.id.place_item_coordinates_text_view);
        ratingTextView = convertView.findViewById(R.id.place_item_rating_text_view);
        itemImageView = convertView.findViewById(R.id.place_item_image);
        itemCardView = convertView.findViewById(R.id.place_item_card_view);
        titleTextView.setText(placeList.get(position).getTitle());
        addressTextView.setText(placeList.get(position).getCoordinates());
        ratingTextView.setText(String.valueOf(placeList.get(position).getRating()));
        InputStream inputStream = null;
        try {
            inputStream = context.getApplicationContext().getAssets().open(placeList.get
                    (position).getImageSrc());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            itemImageView.setImageDrawable(drawable);
            itemImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackActivity.onPlaceListItemSelected(position);
            }
        });
        return convertView;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = ((ListViewActivity) context).getSupportFragmentManager();
        switch (v.getId()) {
            default:
                PlaceDetailFragment detailFragment = PlaceDetailFragment.newInstance(v.getId());
                if (context.getResources().getConfiguration().orientation == Configuration
                        .ORIENTATION_PORTRAIT)
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detailFragment)
                            .addToBackStack(null).commit();
                if (context.getResources().getConfiguration().orientation == Configuration
                        .ORIENTATION_LANDSCAPE)
                    fragmentManager.beginTransaction().replace(R.id.detail_container, detailFragment)
                            .commit();
        }
    }
}
