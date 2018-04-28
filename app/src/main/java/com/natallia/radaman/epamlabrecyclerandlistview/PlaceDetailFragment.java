package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.natallia.radaman.epamlabrecyclerandlistview.Model.Place;
import com.natallia.radaman.epamlabrecyclerandlistview.Model.PlaceList;
import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlaceDetailFragment extends Fragment {
    private static final String TAG = "PlaceDetailFragment";
    private static final String CURRENT_INDEX = "current_index";

    private TextView titleTextView;
    private TextView coordinatesTextView;
    private TextView ratingTextView;
    private ImageView itemImageView;
    private TextView descriptionTextView;

    private int currentIndex = 0;
    private List<Place> places;
    FragmentCoordinator callbackActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackActivity = (FragmentCoordinator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        places = PlaceList.getWorkInstance().getPlaces();
        currentIndex = getArguments().getInt(CURRENT_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_place_detail, container, false);
        if (savedInstanceState != null)
            currentIndex = savedInstanceState.getInt(CURRENT_INDEX);
        initUI(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_INDEX, currentIndex);
    }

    private void initUI(View view) {
        itemImageView = view.findViewById(R.id.place_main_image_view);
        Picasso.get().load(places.get(currentIndex).getImageSrc()).into(itemImageView);

        titleTextView = view.findViewById(R.id.place_title);
        titleTextView.setText(places.get(currentIndex).getTitle());

        coordinatesTextView = view.findViewById(R.id.place_coordinates_detail);
        coordinatesTextView.setText(places.get(currentIndex).getCoordinates());

        ratingTextView = view.findViewById(R.id.place_rating_detail);
        ratingTextView.setText(String.valueOf(places.get(currentIndex).getRating()));

        descriptionTextView = view.findViewById(R.id.place_description_detail);
        descriptionTextView.setText(places.get(currentIndex).getDescription());

        FloatingActionButton floatingActionButton = view.findViewById(R.id.fab_edit_place);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callbackActivity.onEditButtonClick(currentIndex);
            }
        });
    }

    public static PlaceDetailFragment newInstance(int placePositionIndex) {
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        Bundle args = new Bundle();
        args.putInt(CURRENT_INDEX, placePositionIndex);
        fragment.setArguments(args);
        return fragment;
    }
}
