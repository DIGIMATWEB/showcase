package com.digimat.showcase.Login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.digimat.showcase.Menu.view.menuViewImpl;
import com.digimat.showcase.R;

public class LoginContainerActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
      initLoginContainerView();
    }

    public void initLoginContainerView() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(LoginViewImpl.TAG);
        transaction.add(R.id.login_containerF, new LoginViewImpl()).commit();


    }

}
