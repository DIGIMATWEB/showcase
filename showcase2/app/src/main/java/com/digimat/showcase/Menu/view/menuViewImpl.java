package com.digimat.showcase.Menu.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.digimat.showcase.R;
public class menuViewImpl extends AppCompatActivity {

    public static float a, b, c, d, e, f;
    public static boolean selectedVehicle = false;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private BottomNavigationView mynewMenu;
    private BottomNavigationItemView mv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinamic_menu);
        initView();
        showFragmentDashboard();
        showFragmentNavigationButtons();
    }


    private void initView() {
        //mynewMenu = findViewById(R.id.bottom_navigation);
        //mynewMenu.setOnNavigationItemSelectedListener(this);


    }


    private void showFragmentDashboard() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        Zonas zonesFragment = new Zonas();
        transaction.add(R.id.conteinerMainFragments, zonesFragment, Zonas.TAG).commit();
    }
    private void showFragmentNavigationButtons() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        FragmentNavigationMenuV3 fragmentNavigationButtonsMenu = new FragmentNavigationMenuV3();
        transaction.add(R.id.conteinerNavigationButtonsMenuV3, fragmentNavigationButtonsMenu, FragmentNavigationMenuV3.TAG).commit();
    }


}
