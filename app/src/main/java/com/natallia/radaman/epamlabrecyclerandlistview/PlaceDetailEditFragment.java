package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.natallia.radaman.epamlabrecyclerandlistview.Model.Place;
import com.natallia.radaman.epamlabrecyclerandlistview.Model.PlaceList;
import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;

public class PlaceDetailEditFragment extends Fragment {
    private static final String CURRENT_INDEX = "current_index";

    private EditText titleEditText;
    private EditText coordinatesEditText;
    private EditText imageSrcEditText;
    private EditText ratingEditText;
    private EditText descriptionEditText;
    private Button completeButton;
    private FragmentCoordinator callbackActivity;

    Place place;
    int currentIndex = 0;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackActivity = (FragmentCoordinator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentIndex = getArguments().getInt(CURRENT_INDEX);
        place = PlaceList.getWorkInstance().getPlaces().get(currentIndex);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.single_place_detail_edit, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        titleEditText = view.findViewById(R.id.title_edit_text);
        titleEditText.setText(place.getTitle());

        coordinatesEditText = view.findViewById(R.id.coordinates_edit_text);
        coordinatesEditText.setText(place.getCoordinates());

        imageSrcEditText = view.findViewById(R.id.imageSrc_edit_text);
        imageSrcEditText.setText(place.getImageSrc());

        ratingEditText = view.findViewById(R.id.rating_edit_text);
        ratingEditText.setText(String.valueOf(place.getRating()));

        descriptionEditText = view.findViewById(R.id.description_edit_text);
        descriptionEditText.setText(place.getDescription());

        completeButton = view.findViewById(R.id.complete_edit_button);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place.setTitle(titleEditText.getText().toString());
                place.setCoordinates(coordinatesEditText.getText().toString());
                place.setImageSrc(imageSrcEditText.getText().toString());
                place.setRating(Integer.valueOf(ratingEditText.getText().toString()));
                place.setDescription(descriptionEditText.getText().toString());
                PlaceList.getWorkInstance().getPlaces().remove(currentIndex);
                PlaceList.getWorkInstance().getPlaces().add(currentIndex, place);
                callbackActivity.backToList();
            }
        });
    }

    public static PlaceDetailEditFragment newInstance(int placePositionIndex) {
        PlaceDetailEditFragment fragment = new PlaceDetailEditFragment();
        Bundle args = new Bundle();
        args.putInt(CURRENT_INDEX, placePositionIndex);
        fragment.setArguments(args);
        return fragment;
    }
}
