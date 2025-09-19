package com.digimat.showcase.Alerts.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Alerts.adapter.adapterAlertList;
import com.digimat.showcase.Alerts.adapter.adapterDates;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.view.Zonas;

public class alertsUser extends Fragment implements View.OnClickListener{
    public static final String TAG = alertsUser.class.getSimpleName();

    private RecyclerView rv,rvA;
    private adapterDates adapter;
    private TextView descriptionText;
    private adapterAlertList adapterAlerts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alerts, container, false);
        init(view);
        return view;
    }
    private void fillDates(){//este metodo es para los vehiculos del admin
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv.setLayoutManager(layoutManager);
        adapter=new adapterDates(getContext());
        rv.setAdapter(adapter);
    }

    private void fillAlerts(){//este metodo es para los vehiculos del admin
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvA.setLayoutManager(layoutManager);
        adapterAlerts=new adapterAlertList(getContext());
        rvA.setAdapter(adapterAlerts);
    }
    private void init(View view) {
        descriptionText=view.findViewById (R.id. descriptionText);
        rv=view.findViewById (R.id.rvDates);
        rvA=view.findViewById (R.id.rvAlertList);
        fillDates();
        fillAlerts();
    }

    @Override
    public void onClick(View view) {

    }
}
