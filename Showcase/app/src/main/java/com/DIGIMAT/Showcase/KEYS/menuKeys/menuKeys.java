package com.DIGIMAT.Showcase.KEYS.menuKeys;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.DIGIMAT.Showcase.KEYS.Home.View.Home;
import com.DIGIMAT.Showcase.KEYS.Profile.View.profileKeys;
import com.DIGIMAT.Showcase.R;

public class menuKeys extends Fragment implements View.OnClickListener {
    public static final String TAG = Home.class.getSimpleName();
    private ImageView iconMenu1,iconMenu2,iconMenu3;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menukeys, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        iconMenu1=view.findViewById(R.id.iconMenu1);
        iconMenu1.setOnClickListener(this);
        iconMenu2=view.findViewById(R.id.iconMenu2);
        iconMenu2.setOnClickListener(this);
        iconMenu3=view.findViewById(R.id.iconMenu3);
        iconMenu3.setOnClickListener(this);
    }


    private void goHome() {
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        Home mHome = new Home();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, mHome, Home.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }
    private void goInventary() {
    }
    private void goProfile() {
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();
        profileKeys perfiKeys = new profileKeys();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, perfiKeys, profileKeys.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iconMenu1:
                goHome();
                break;
            case R.id.iconMenu2:
                goInventary();
                break;
            case R.id.iconMenu3:
                goProfile();
                break;
        }
    }




}
