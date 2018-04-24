package com.natallia.radaman.epamlabrecyclerandlistview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.natallia.radaman.epamlabrecyclerandlistview.Model.Place;
import com.natallia.radaman.epamlabrecyclerandlistview.Model.PlaceList;
import com.natallia.radaman.epamlabrecyclerandlistview.interfaces.FragmentCoordinator;

import java.util.List;

/**
 * Created by Natallia Radaman on 16.04.2018.
 */

public class FragmentListView extends Fragment {
    private ListView listView;
    private List<Place> placeList;
    private ListViewAdapter listViewAdapter;
    FragmentCoordinator callbackActivity;

    public FragmentListView() {
    }

    public static FragmentListView newInstance() {
        FragmentListView fragmentListView = new FragmentListView();
        return fragmentListView;
    }

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
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        placeList = PlaceList.getWorkInstance().getPlaces();
        listViewAdapter = new ListViewAdapter(placeList, getActivity().getApplicationContext());
        listView = view.findViewById(R.id.list_view_places);
        listView.setAdapter(listViewAdapter);
    }

    public void onResume() {
        super.onResume();
        listViewAdapter.notifyDataSetChanged();
    }
}
