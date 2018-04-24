package com.natallia.radaman.epamlabrecyclerandlistview.interfaces;

public interface FragmentCoordinator {
    void onPlaceListItemSelected(int position);

    void onEditButtonClick(int index);

    void backToList();
}
