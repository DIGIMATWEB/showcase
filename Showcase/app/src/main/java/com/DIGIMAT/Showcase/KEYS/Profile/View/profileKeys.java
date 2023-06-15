package com.DIGIMAT.Showcase.KEYS.Profile.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.DIGIMAT.Showcase.KEYS.Home.View.Home;
import com.DIGIMAT.Showcase.R;

public class profileKeys extends Fragment {
    public static final String TAG = profileKeys.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilekey, container, false);

        return view;
    }
}