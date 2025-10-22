package com.digimat.showcase.Mas.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Comunidad.view.fragmentComunidad;
import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Mas.adapter.adapterInfo;
import com.digimat.showcase.Mas.adapter.adapterMenus;
import com.digimat.showcase.Mas.adapter.adapterMenusExtras;
import com.digimat.showcase.Menu.models.SetMenu.modelMenu;
import com.digimat.showcase.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class masFrament  extends Fragment implements   View.OnClickListener{
    public static final String TAG = masFrament.class.getSimpleName();
    private RecyclerView rvMenus,masOpciones,Informacion;
    private adapterMenus adapter;
    private adapterMenusExtras adapterExtras;
    private adapterInfo adaptrInfo;
    private TextView txtHeader, descriptionText;
    private ScrollView scrollView;
    private List<modelMenu> menusP=new ArrayList<>();
    private List<modelMenu> menusE=new ArrayList<>();
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

        txtHeader = view.findViewById(R.id.txtHeader); // Header que quieres mostrar
        descriptionText = view.findViewById(R.id.descriptionText); // TextView que quieres ocultar
        scrollView = view.findViewById(R.id.scrollViewMasOpciones); // ScrollView padre
        checkUpJson();
        fillAdapter();
        fillAdapterMas();
        fillInformacion();
        setupScrollListener();
    }

    private void checkUpJson() {
        SharedPreferences preferences = getContext().getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        String menusJson = preferences.getString(GeneralConstantsV2.MENUS_SAVED, null);

        if (menusJson != null) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<modelMenu>>() {}.getType();

            List<modelMenu> allMenus = gson.fromJson(menusJson, listType);

            if (allMenus != null && !allMenus.isEmpty()) {
                int endIndex = Math.min(4, allMenus.size());
                menusP.clear();
                menusP.addAll(allMenus.subList(0, endIndex));

                if (allMenus.size() > 6) {
                    menusE.clear();
                    menusE.addAll(allMenus.subList(6, allMenus.size()));
                }
            }
        }
    }


    private void setupScrollListener() {
        scrollView.getViewTreeObserver().addOnScrollChangedListener(() -> {
            int scrollY = scrollView.getScrollY(); // Posición vertical del scroll

            if (scrollY > 100) { // Ajusta este valor según cuando quieras el cambio
                descriptionText.setVisibility(View.INVISIBLE);
                txtHeader.setVisibility(View.VISIBLE);
            } else {
                descriptionText.setVisibility(View.VISIBLE);
                txtHeader.setVisibility(View.GONE);
            }
        });
    }

    private void fillAdapter() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false; // Deshabilita el scroll vertical
            }
        };
        rvMenus.setLayoutManager(layoutManager);
        adapter = new adapterMenus(getContext(),menusP);
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
        adapterExtras = new adapterMenusExtras(getContext(),menusE);
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
