package com.DIGIMAT.Showcase.Menu.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.DIGIMAT.Showcase.KEYS.Home.View.Home;
import com.DIGIMAT.Showcase.KEYS.menuKeys.menuKeys;
import com.DIGIMAT.Showcase.Zonas.view.Zonas;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.DIGIMAT.Showcase.R;
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
        showFragmentHome();
        showFragmentNavigationButtons();
    }


    private void initView() {
        //mynewMenu = findViewById(R.id.bottom_navigation);
        //mynewMenu.setOnNavigationItemSelectedListener(this);


    }


    private void showFragmentHome() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        Home homeKeys = new Home();
        transaction.add(R.id.conteinerMainFragments, homeKeys, Home.TAG).commit();
    }
    private void showFragmentNavigationButtons() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        menuKeys menuKeysV = new menuKeys();
        transaction.add(R.id.conteinerNavigationButtonsMenuV3, menuKeysV, menuKeys.TAG).commit();
    }


}
