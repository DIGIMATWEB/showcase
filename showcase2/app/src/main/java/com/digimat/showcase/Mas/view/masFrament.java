package com.digimat.showcase.Mas.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Comunidad.view.fragmentComunidad;
import com.digimat.showcase.Mas.adapter.adapterInfo;
import com.digimat.showcase.Mas.adapter.adapterMenus;
import com.digimat.showcase.Mas.adapter.adapterMenusExtras;
import com.digimat.showcase.R;

public class masFrament  extends Fragment implements   View.OnClickListener{
    public static final String TAG = masFrament.class.getSimpleName();
    private RecyclerView rvMenus,masOpciones,Informacion;
    private adapterMenus adapter;
    private adapterMenusExtras adapterExtras;
    private adapterInfo adaptrInfo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mas_opciones, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rvMenus=view.findViewById(R.id.rvMenus);
        masOpciones=view.findViewById(R.id.masOpciones);
        Informacion=view.findViewById(R.id.Informacion);
        fillAdapter();
        fillAdapterMas();
        fillInformacion();
    }




    private void fillAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false; // Deshabilita el scroll vertical
            }
        };
        rvMenus.setLayoutManager(layoutManager);
        adapter = new adapterMenus(getContext());
        rvMenus.setAdapter(adapter);
    }
    private void fillAdapterMas() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false; // Deshabilita el scroll vertical
            }
        };
        masOpciones.setLayoutManager(layoutManager);
        adapterExtras = new adapterMenusExtras(getContext());
        masOpciones.setAdapter(adapterExtras);
    }
    private void fillInformacion() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false; // Deshabilita el scroll vertical
            }
        };
        Informacion.setLayoutManager(layoutManager);
        adaptrInfo = new adapterInfo(getContext());
        Informacion.setAdapter(adaptrInfo);
    }
    @Override
    public void onClick(View view) {

    }
}
