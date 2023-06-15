package com.DIGIMAT.Showcase.Splash.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.DIGIMAT.Showcase.Login.view.LoginContainerActivity;
import com.DIGIMAT.Showcase.Menu.view.menuViewImpl;
import com.DIGIMAT.Showcase.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initSplashScreenActivity();
    }

    private void initSplashScreenActivity() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                gotoHome();
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
    private void gotoHome(){
        Intent intent = new Intent(this, menuViewImpl.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);//
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}