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
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, +WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //Log.e("checkinguser","splash"+UserDataDB.getUserData().getEmployee_name());
       // RealmConfig.initRealm(getApplicationContext());
        //Log.e("checkinguser","splash              "+UnitDB.getUnitList());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // if (UserDataDB.isEmpty()){
              //      Log.e("checkinguser","go to login  ");
                    goToLoginContainer();
                /*}else {
                    SharedPreferences preferences = getApplicationContext().getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
                    String status = preferences.getString(GeneralConstantsV2.CLOSE_SESSION_PREFERENCES, null);
                    
                    if(status.equals("YES"))
                    {
                        goToLoginContainer();
                    }else
                    {
                        goToMenu();
                    }

                }*/
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

    /*private void goToMenu(){
        Bundle bundle = new Bundle();
        bundle.putString("nav","UNITS");
        Intent intent = new Intent(SplashScreenActivity.this,  menuViewImpl.class);// menuViewImpl.class);//MainMenuContainerActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtras(bundle);
        startActivity(intent);
        finish();
    }*/


}
