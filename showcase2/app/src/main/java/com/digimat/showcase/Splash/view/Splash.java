package com.digimat.showcase.Splash.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Login.view.LoginContainerActivity;
import com.digimat.showcase.Menu.view.FragmentNavigationMenuV3;
import com.digimat.showcase.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        initSplashScreenActivity();
    }
    private void initSplashScreenActivity() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    goToLoginContainer();
            }
        }, 2500);
    }

    private void goToLoginContainer() {
        Bundle bndl = new Bundle();
        bndl.putBoolean("HelpStatus", false);
        Intent intent = new Intent(Splash.this, LoginContainerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(bndl);
        startActivity(intent);
        finish();
    }
}
