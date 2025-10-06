package com.digimat.showcase.Splash.view;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Login.view.LoginContainerActivity;
import com.digimat.showcase.Menu.view.menuViewImpl;
import com.digimat.showcase.R;
import com.digimat.showcase.Splash.model.dataSplash;
import com.digimat.showcase.Splash.presenter.presenterSplash;
import com.digimat.showcase.Splash.presenter.presenterSplashImpl;

public class Splash extends AppCompatActivity implements viewSplash {
    private presenterSplash presenter;
    private ImageView logo;
    private ConstraintLayout splashbackground;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        initView();
      //  presenter.getSplashData();
    }

    private void initView() {
        logo=findViewById(R.id.logo);
        splashbackground=findViewById(R.id.splashbackground);
        initSplashScreenActivity();
       // presenter= new presenterSplashImpl(this,getApplicationContext());
    }

    private void initSplashScreenActivity() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        String token = preferences.getString(GeneralConstantsV2.TOKEN_PREFERENCES, null);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(token!=null){
                    Intent intent = new Intent(getApplicationContext(), menuViewImpl.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);//
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else {
                    goToLoginContainer();
                }
            }
        }, 2500);
    }

    private void goToLoginContainer() {
        Bundle bndl = new Bundle();
        bndl.putBoolean("HelpStatus", false);
        Intent intent = new Intent(Splash.this, LoginContainerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtras(bndl);
        startActivity(intent);
        finish();
    }

    @Override
    public void setSplash(dataSplash data) {
        if(data!=null) {
            int color = Color.parseColor(data.getBackgroundColor());
            splashbackground.setBackgroundColor(color);

            Glide.with(this)
                    .load(data.getBackgroundImage())
                    .into(logo);
        }
       // initSplashScreenActivity();
    }
}
