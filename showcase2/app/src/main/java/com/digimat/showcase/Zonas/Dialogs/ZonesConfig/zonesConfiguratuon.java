package com.digimat.showcase.Zonas.Dialogs.ZonesConfig;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.presenter.presenterZones;
import com.digimat.showcase.Zonas.adapter.adapterCrudZones;
import com.digimat.showcase.Zonas.adapter.adapterZones;
import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class zonesConfiguratuon extends BottomSheetDialogFragment implements View.OnClickListener ,interfaceZones.View{
    public static final String TAG = zonesConfiguratuon.class.getSimpleName();
    private RecyclerView rvListZones,rvDetailZones;

    private adapterZones adapter;
    private adapterCrudZones adapterCrud;
    private ImageView addZones;
    private Button buttonCancel, buttonAcept;
    private SearchView searchZones;
    private interfaceZones.Presenter presenter;
    private Zonas fragment;
    private List<dataGetAllZones> dataZones;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del Bottom Sheet
        return inflater.inflate(R.layout.fragment_bottom_sheet_geozones, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragment= (Zonas) getParentFragment();
        initView(view);
        // Configurar el botón de cerrar


    }

    private void initView(View view) {
        rvListZones = view.findViewById(R.id.rvListZones);

        addZones = view.findViewById(R.id.addZones);
        addZones.setOnClickListener(this);
        buttonCancel = view.findViewById(R.id.buttonCancel);
        buttonAcept = view.findViewById(R.id.buttonAcept);
        buttonCancel.setOnClickListener(this);
        buttonAcept.setOnClickListener(this);
        searchZones = view.findViewById(R.id.searchZones);
        presenter=new presenterZones(this,getContext());
        presenter.requestZones();

    }
    @Override
    public void setZones(List<dataGetAllZones> data) {
        this.dataZones=data;
        fillAdapter(data);
    }

    private void fillAdapter(List<dataGetAllZones> data) {
        // Configura el LayoutManager para que sea horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListZones.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        adapter = new adapterZones(this,data,getContext());
        rvListZones.setAdapter(adapter);
        searchZones.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<dataGetAllZones>  filterList =filter(data,newText);
                adapter.setFilter(filterList);
//                if(newText.isEmpty()){
//                    Log.e("unitsV3filter","clear filter2");
//                    neeLegacylist.clear();
//                }
                return true;
            }
        });

    }
    private List<dataGetAllZones> filter(List<dataGetAllZones> data, String text) {
        List<dataGetAllZones>  mfilterList= new ArrayList<>();
        text =text.toLowerCase();
        if(data!=null){
            for(dataGetAllZones zone:data)
            {
                String manifestname=zone.getZoneName().toLowerCase();
                if(manifestname.contains(text)){
                    mfilterList.add(zone);
                }
            }
        }

        return mfilterList;
    }
    public void senDotsEditor(List<dotZonesm> dotZoness) {
        fragment.setDots(dotZoness);
    }
    public void editZonesValues(String zoneId, String descZone, String ratio, String zoneName) {
        fragment.editZonesValues(zoneId,descZone,ratio,zoneName);
    }
    public void sendToEditorZone(Integer type){
        fragment.ZoneCrud(type);
        dismiss();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.closeButton:
                dismiss();
                break;
            case R.id.addZones:

                sendToEditorZone(1);
                break;
            case R.id.buttonCancel:
                rvListZones.setVisibility(View.VISIBLE);
                buttonAcept.setVisibility(View.GONE);
                buttonCancel.setVisibility(View.GONE);
                searchZones.setVisibility(View.VISIBLE);
                break;
        }
    }



}
