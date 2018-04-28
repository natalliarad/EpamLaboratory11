package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.natallia.radaman.epamlabrecyclerandlistview.Model.Place;
import com.natallia.radaman.epamlabrecyclerandlistview.Model.PlaceList;
import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Natallia Radaman on 16.04.2018.
 */

public class FragmentRecyclerView extends Fragment {
    private RecyclerView recyclerView;
    private List<Place> placeList;
    private PlaceAdapter placeAdapter;
    FragmentCoordinator callbackActivity;

    public FragmentRecyclerView() {

    }

    public static FragmentRecyclerView newInstance() {
        FragmentRecyclerView fragmentRecyclerView = new FragmentRecyclerView();
        return fragmentRecyclerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callbackActivity = (FragmentCoordinator) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        placeList = PlaceList.getWorkInstance().getPlaces();
        placeAdapter = new PlaceAdapter(placeList, getActivity().getApplicationContext());
        if (placeAdapter.getItemCount() == 0) {
            Toast.makeText(getActivity().getApplicationContext(), "No elements",
                    Toast.LENGTH_SHORT).show();
        }
        recyclerView = view.findViewById(R.id.recycler_view_places);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(placeAdapter);
        final FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                PlaceDetailEditFragment detailFragment = PlaceDetailEditFragment.newInstance(0);
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detailFragment)
                            .addToBackStack(null).commit();
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
                    fragmentManager.beginTransaction().replace(R.id.detail_container, detailFragment)
                            .commit();
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0 || dy < 0 && fab.isShown()) {
                    fab.hide();
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        placeAdapter.notifyDataSetChanged();
    }

    private class PlaceAdapter extends RecyclerView.Adapter<PlaceViewHolder> {
        private List<Place> placeList;
        private Context context;

        public PlaceAdapter(List<Place> placeList, Context context) {
            this.placeList = placeList;
            this.context = context;
        }

        @NonNull
        @Override
        public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.place_item_layout, parent, false);
            return new PlaceViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull final PlaceViewHolder holder, int position) {
            holder.titleTextView.setText(placeList.get(holder.getAdapterPosition()).getTitle());
            holder.coordinatesTextView.setText(placeList.get(holder.getAdapterPosition()).getCoordinates());
            holder.ratingTextView.setText(String.valueOf(placeList.get(holder.getAdapterPosition())
                    .getRating()));
            Picasso.get().load(placeList.get(holder.getAdapterPosition()).getImageSrc()).into
                    (holder.itemImageView);
            holder.itemCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callbackActivity.onPlaceListItemSelected(holder.getAdapterPosition());
                }
            });
        }

        @Override
        public int getItemCount() {
            if (placeList != null)
                return placeList.size();
            return 0;
        }
    }

    private static class PlaceViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView coordinatesTextView;
        public TextView ratingTextView;
        public ImageView itemImageView;
        public CardView itemCardView;

        public PlaceViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.place_item_title_text_view);
            coordinatesTextView = itemView.findViewById(R.id.place_item_coordinates_text_view);
            ratingTextView = itemView.findViewById(R.id.place_item_rating_text_view);
            itemImageView = itemView.findViewById(R.id.place_item_image);
            itemCardView = itemView.findViewById(R.id.place_item_card_view);
        }
    }
}
