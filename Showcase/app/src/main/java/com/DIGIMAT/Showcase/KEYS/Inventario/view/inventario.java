package com.DIGIMAT.Showcase.KEYS.Inventario.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.DIGIMAT.Showcase.KEYS.Home.View.Home;
import com.DIGIMAT.Showcase.KEYS.Home.adapter.adapterKeyList;
import com.DIGIMAT.Showcase.R;

public class inventario extends Fragment {
    public static final String TAG = inventario.class.getSimpleName();
    private RecyclerView rvKeys;
    private adapterKeyList adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
//        rvKeys=view.findViewById(R.id.rvKeys);
//        fillAdapter();
    }

    private void fillAdapter() {
        adapterKeyList adapterKeys = new adapterKeyList();
        // adapterKeys.setOnClickDateListener(UnitMapViewImplV3.this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvKeys.setLayoutManager(layoutManager);
        rvKeys.setAdapter(adapterKeys);
    }
}
