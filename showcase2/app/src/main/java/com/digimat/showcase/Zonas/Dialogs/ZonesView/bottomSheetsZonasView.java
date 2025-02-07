package com.digimat.showcase.Zonas.Dialogs.ZonesView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.adapter.adapterZonesView;
import com.digimat.showcase.Zonas.view.Zonas;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class bottomSheetsZonasView extends BottomSheetDialogFragment implements View.OnClickListener {
    public static final String TAG = bottomSheetsZonasView.class.getSimpleName();

    private ImageButton closeButton;
    private RecyclerView rvZonasView;
    private adapterZonesView madapter;
    private List<String> itemList;
    private SearchView msearchView;

    private Zonas mview;
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
        return inflater.inflate(R.layout.fragment_bottom_sheets_zonasview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mview= (Zonas)getParentFragment();
        initView(view);
        // Configurar el botón de cerrar


    }

    private void initView(View view) {
        closeButton = view.findViewById(R.id.closeButtonZ);
        closeButton.setOnClickListener(this);
        rvZonasView= view.findViewById(R.id.rvZonas);
        msearchView= view.findViewById(R.id.searchZonasView);
        harcodedData();
        fillAdapter(itemList);
        msearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<String>  filterList =filter(itemList,newText);
                madapter.setFilter(filterList);
//                if(newText.isEmpty()){
//                    Log.e("unitsV3filter","clear filter2");
//                    neeLegacylist.clear();
//                }
                return true;
            }
        });
    }

    private List<String> filter(List<String> itemList, String newText) {
        List<String>  mfilterList= new ArrayList<>();
        newText =newText.toLowerCase();
        if(newText!=null){
            for(String data:itemList)
            {
                String servicioName=data.toString().toLowerCase();
                if(servicioName.contains(newText)){
                    mfilterList.add(data);
                }
            }
        }

        return mfilterList;
    }

    private void harcodedData() {
        itemList= new ArrayList<>();
        itemList.add("Barrio de San José");
        itemList.add("Barrio de San Andrés");
        itemList.add("Barrio de San Agustín");
        itemList.add("Barrio de Santa Ana");
        itemList.add("Barrio de Santa Cruz");
        itemList.add("Barrio de San Martín");
        itemList.add("Barrio de San Juan Bautista");
        itemList.add("Barrio de Santiago");
    }

    private void fillAdapter(List<String> itemList) {
        // Configura el LayoutManager para que sea horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvZonasView.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        madapter = new adapterZonesView(this,itemList,getContext());
        rvZonasView.setAdapter(madapter);
    }
    public void goZoneifExist(int position) {
            for(dataGetAllZones zone:dataZones) {
                if (itemList.get(position).toString().equals(zone.getZoneName())){
                    mview.goToBoundsZone(zone);
                    break;
                }
            }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.closeButtonZ:
                dismiss();
                break;
        }
    }

    public void checkExistingZone(List<dataGetAllZones> data) {
        this.dataZones=data;
        for (dataGetAllZones zone:data) {
            String zoneName = zone.getZoneName();

            if (itemList.contains(zoneName)) {
                itemList.remove(zoneName); // Remove from its current position
                itemList.add(0, zoneName); // Add to the beginning without replacing anything
            } else {
                itemList.add(0, zoneName); // Add to the beginning if it doesn't exist
            }
        }
        madapter.notifyDataSetChanged(); // Notify the adapter of the change
    }


}