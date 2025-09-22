package com.digimat.showcase.Profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Alerts.adapter.adapterAlertList;
import com.digimat.showcase.Login.view.LoginContainerActivity;
import com.digimat.showcase.Menu.view.menuViewImpl;
import com.digimat.showcase.Profile.adapter.adapterProfile;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.view.Zonas;

public class profileViewImplements extends Fragment implements View.OnClickListener {
    public static final String TAG = profileViewImplements.class.getSimpleName();
    private Button logout;
    private  RecyclerView rv;
    private adapterProfile adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        logout=view.findViewById(R.id.edit_profile_button);
        logout.setOnClickListener(this);
        rv=view.findViewById(R.id.rvitemsProfile);
        fillAlerts();
    }
    private void fillAlerts(){//este metodo es para los vehiculos del admin
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        adapter=new adapterProfile(getContext());
        rv.setAdapter(adapter);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_profile_button:
                Intent intent = new Intent(getContext(), LoginContainerActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);//
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }

    }
}
