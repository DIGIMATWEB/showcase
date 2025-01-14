package com.digimat.showcase.Zonas.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.Zonas.adapter.adapterServicios;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.digimat.showcase.R;

import java.util.ArrayList;
import java.util.List;

public class bootmSheetsServicios extends BottomSheetDialogFragment implements View.OnClickListener {
    public static final String TAG = bootmSheetsServicios.class.getSimpleName();

    private ImageButton closeButton;
    private RecyclerView rvServicios;
    private adapterServicios madapter;
    private List<String> itemList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del Bottom Sheet
        return inflater.inflate(R.layout.fragment_bottom_sheet_serviciow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        // Configurar el botón de cerrar


    }

    private void initView(View view) {
        closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(this);
        rvServicios= view.findViewById(R.id.rvServicios);
        harcodedData();
        fillAdapter(itemList);
    }

    private void harcodedData() {
        itemList= new ArrayList<>();
        itemList.add("Seguridad publica");
        itemList.add("Seguridad preventiva");
        itemList.add("Proteccion Civil");
        itemList.add("Recoleccion basura");
        itemList.add("Alumbrado publico");
        itemList.add("Agua Drenaje alcantarillado");
        itemList.add("Tramites");
        itemList.add("Participacion Ciudadana");
        itemList.add("Fomento Comercial");
        itemList.add("Fomento Turistico");
        itemList.add("Fomento Artesanal");
        itemList.add("Salud ");
        itemList.add("vivienda ");
        itemList.add("Educacion y Cultura ");
        itemList.add("Deporte y Juventud ");
    }

    private void fillAdapter(List<String> itemList) {
        // Configura el LayoutManager para que sea horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvServicios.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        madapter = new adapterServicios(itemList,getContext());
        rvServicios.setAdapter(madapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.closeButton:
                dismiss();
                break;
        }
    }
}