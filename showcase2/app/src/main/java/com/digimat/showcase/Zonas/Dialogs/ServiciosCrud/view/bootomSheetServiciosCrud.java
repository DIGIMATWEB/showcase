package com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.adapter.adapterServiciosCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.adapter.adapterServiciosCrud;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.model.crudServicios.dataServicesCatalog;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.presenter.presenterServiciosCrud;
import com.digimat.showcase.Zonas.Dialogs.ServiciosCrud.presenter.presenterServiciosCrudImpl;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class bootomSheetServiciosCrud extends BottomSheetDialogFragment implements View.OnClickListener ,BottomSheetDialogFragmentView{
    public static final String TAG = bootomSheetServiciosCrud.class.getSimpleName();

    private ImageButton closeButton;
    private adapterServiciosCatalog madapter2;
    private adapterServiciosCrud madapter;

    private List<dataServicesCatalog> itemList;
    private SearchView msearchView;
    private Switch switchServicios;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private presenterServiciosCrud presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.TransparentBottomSheetDialog);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el diseño del Bottom Sheet
        return inflater.inflate(R.layout.fragment_bottom_sheet_servicios_crud, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        // Configurar el botón de cerrar


    }

    private void initView(View view) {
        switchServicios=view.findViewById(R.id.switchServicios);
        closeButton = view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(this);
        msearchView= view.findViewById(R.id.searchViewServicios);
        rv1=view.findViewById(R.id.rvServicioscrud);
        rv2=view.findViewById(R.id.rvServicioscrudSet);

        msearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                List<dataServicesCatalog>  filterList =filter(itemList,newText);
                madapter.setFilter(filterList);
//                if(newText.isEmpty()){
//                    Log.e("unitsV3filter","clear filter2");
//                    neeLegacylist.clear();
//                }
                return true;
            }
        });
        switchServicios.setChecked(false);

        presenter=new presenterServiciosCrudImpl(this,getContext());
//        presenter.getServiciosComunity();
//        presenter.getCatalogoServicios();
        switchServicios.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
//                    if(presenter!=null) {
                        presenter.getCatalogoServicios();
//                    }
                    rv1.setVisibility(View.GONE);
                    rv2.setVisibility(View.VISIBLE);
                    //}
                } else {
//                    if(presenter!=null) {
                        presenter.getServiciosComunity();
//                    }
                    //  if(madapter!=null&&madapter2!=null) {
//                    rv1.setVisibility(View.VISIBLE);
//                    rv2.setVisibility(View.GONE);
                    //  }

                }
            }
        });

    }

    private List<dataServicesCatalog> filter(List<dataServicesCatalog> itemList, String newText) {
        List<dataServicesCatalog>  mfilterList= new ArrayList<>();
        newText =newText.toLowerCase();
        if(newText!=null){
            for(dataServicesCatalog data:itemList)
            {
                String servicioName=data.getNameService().toString().toLowerCase();
                if(servicioName.contains(newText)){
                    mfilterList.add(data);
                }
            }
        }

        return mfilterList;
    }

    private void harcodedData() {
    }

    private void fillAdapter(List<dataServicesCatalog> catalog) {
        // Configura el LayoutManager para que sea horizontal
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(),3, LinearLayoutManager.VERTICAL, false);
        rv1.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        madapter = new adapterServiciosCrud(this,catalog,getContext());
        rv1.setAdapter(madapter);
    }
    private void fillCatalog(List<dataServicesCatalog> catalog) {
        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(),3, LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        madapter2 = new adapterServiciosCatalog(this,catalog,getContext());
        rv2.setAdapter(madapter2);
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

    @Override
    public void setCatalogServices(List<dataServicesCatalog> catalog) {
        fillCatalog(catalog);
    }



    @Override
    public void setServicesAvailable(List<dataServicesCatalog> catalog) {
        fillAdapter(catalog);
    }

    @Override
    public void succesUpdate() {
       // presenter.getServiciosComunity();
    }

    public void addServiceDialog(int i, String comunity, Integer idService, String nameService) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.CustomAlertDialogTheme);
        builder.setTitle("Agregar servicio ")
                .setMessage("¿Deseas agregar "+nameService+" a tu comunidad?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    // Acción cuando el usuario elige "Sí" (true)
                    presenter.setServiceOnComunity(i,comunity,idService,nameService);
                })
                .setNegativeButton("No", (dialog, which) -> {
                    // Acción cuando el usuario elige "No" (false)
                   dismiss();
                })
                .setCancelable(false) // Evita que el usuario cierre el diálogo tocando fuera
                .show();

    }
}

