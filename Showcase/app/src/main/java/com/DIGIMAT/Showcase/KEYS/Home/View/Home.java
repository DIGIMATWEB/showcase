package com.DIGIMAT.Showcase.KEYS.Home.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DIGIMAT.Showcase.KEYS.Home.adapter.adapterKeyList;
import com.DIGIMAT.Showcase.R;
import com.DIGIMAT.Showcase.Zonas.view.Zonas;

public class Home extends Fragment {
    public static final String TAG = Home.class.getSimpleName();
    private RecyclerView rvKeys;
    private adapterKeyList adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homekeys, container, false);
        initView(view);

        ImageButton menuButton = view.findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        setHasOptionsMenu(true);

        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_home, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menu_item1:
                // Handle menu item 1 click
                return true;
            case R.id.menu_item2:
                // Handle menu item 2 click
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void initView(View view) {
        rvKeys=view.findViewById(R.id.rvKeys);
        fillAdapter();
    }
    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_home, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle menu item clicks here
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.menu_item1:
                        // Handle menu item 1 click
                        return true;
                    case R.id.menu_item2:
                        // Handle menu item 2 click
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }
    private void fillAdapter() {
         adapterKeyList adapterKeys = new adapterKeyList();
               // adapterKeys.setOnClickDateListener(UnitMapViewImplV3.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvKeys.setLayoutManager(layoutManager);
        rvKeys.setAdapter(adapterKeys);
    }
}
