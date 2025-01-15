package com.digimat.showcase.Zonas.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.bootmSheetsServicios;
import com.digimat.showcase.Zonas.Dialogs.model.dotZones;
import com.digimat.showcase.Zonas.Dialogs.zonesConfiguratuon;
import com.digimat.showcase.Zonas.adapter.adapterCrudZones;
import com.digimat.showcase.Zonas.model.dataFullVehicles;
import com.digimat.showcase.Zonas.presenter.presenterVehicles;
import com.digimat.showcase.Zonas.presenter.presenterVehiclesImpl;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.kml.KmlLayer;

import java.util.ArrayList;
import java.util.List;

public class Zonas extends Fragment implements OnMapReadyCallback ,zonasView,View.OnClickListener{
    public static final String TAG = Zonas.class.getSimpleName();
    private MapView mView;
    private GoogleMap mMap;
    private List<dataFullVehicles> vehicles;
    private presenterVehicles presenter;
    private Marker vehicle;
    private KmlLayer mKmlLayer;
    private ImageView buttonServicios,colonias,zonesButton;
    private ConstraintLayout xpand_crud;
    private ImageButton closeCrud;

    private RecyclerView rvDetailZones;

    private adapterCrudZones adapterCrud;
    private List<dotZones> dotZones;
    private TextView addtextDot;
    private Marker dotZonenew;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zones, container, false);
        initTrackingMapFragment(view,savedInstanceState);
        return view;
    }
    private void initTrackingMapFragment(View view, Bundle savedInstanceState) {
        bindViews(view);
        onCreateViewMap(savedInstanceState);
        presenter.requestVehicles();
    }

    private void onCreateViewMap(Bundle savedInstanceState) {
        mView.onCreate(savedInstanceState);
        Log.e("onCreateViewMap", "OK");

        if (mView != null) {
            mView.getMapAsync(this);
        }
    }


    private void bindViews(View view) {
        mView = view.findViewById(R.id.map_view_tracking);
        buttonServicios= view.findViewById(R.id. buttonServicios);
        colonias = view.findViewById(R.id. colonias);
        xpand_crud=view.findViewById(R.id.xpand_crud);
        zonesButton =view.findViewById(R.id.zonesButton);
        closeCrud =view.findViewById(R.id.closeCrud);
        rvDetailZones =view.findViewById(R.id.rvDetailZones);
        addtextDot=view.findViewById(R.id. addtextDot);
        addtextDot.setOnClickListener(this);
        closeCrud.setOnClickListener(this);
        zonesButton.setOnClickListener(this);
        buttonServicios.setOnClickListener(this);
        presenter= new presenterVehiclesImpl(this,getContext());

    }
    //region map config
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();
       // mMap.setTrafficEnabled(true);

//        try {
//            // Load KML file from resources (replace R.raw.kml_file with your KML file name)
////            mKmlLayer = new KmlLayer(mMap, R.raw.morkml, getContext());
////            mKmlLayer.addLayerToMap();
//
//        } catch (IOException | XmlPullParserException e) {
//            e.printStackTrace();
//        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.9567483, -98.9836352), 13.5f));

        uiSettingsMap(mMap);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.9567483, -98.9836352), 14f));
            }
        }, 4000);
    }

//
    private void uiSettingsMap(GoogleMap googleMap) {
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setRotateGesturesEnabled(false);
        mMap.setPadding(0, 0, 0, 100);
    }
    //endregion
    //region lifecycle
    @Override
    public void onStart() {
        super.onStart();
        mView.onStart();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    @Override
    public void onResume() {
        super.onResume();
        mView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mView.onPause();
        Log.e("onPause", "OK");
    }
    @Override
    public void onStop() {
        super.onStop();
        mView.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView.onDestroy();
    }
    //endregion
    @Override
    public void setVehicles(List<dataFullVehicles> data) {
    this.vehicles=data;
        setMarkers(vehicles);
    }

    private void setMarkers(List<dataFullVehicles> mvehicles) {
        for (int i = 0; i < mvehicles.size(); i++) {
            double lat = Double.parseDouble(mvehicles.get(i).getLatUser());
            double lng = Double.parseDouble(mvehicles.get(i).getLongUser());
            LatLng ubicacion = new LatLng(lat, lng);
            mMap.addMarker(new MarkerOptions()
                    .position(ubicacion)
                    .title("Marker " + i));
        }
    }
    private void fillAdapterCrud(List<dotZones> dotZoness) {
        // Configura el LayoutManager para que sea horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvDetailZones.setLayoutManager(layoutManager);
        // Crea y configura el Adapter (aquí asumes que ya tienes el Adapter implementado)
        adapterCrud = new adapterCrudZones(dotZoness,getContext());
        rvDetailZones.setAdapter(adapterCrud);
    }
    public void setDots(List<dotZones> dotZoness) {
        this.dotZones=dotZoness;

    }
    public void ZoneCrud(Integer type) {
        if(type==1){
            //Toast.makeText(getContext(), "crear", Toast.LENGTH_SHORT).show();
            xpand_crud.setVisibility(View.VISIBLE);
            List<dotZones> dotZoness=new ArrayList<>();
            fillAdapterCrud(dotZoness);
        }else if(type==2){
           // Toast.makeText(getContext(), "editar", Toast.LENGTH_SHORT).show();
            xpand_crud.setVisibility(View.VISIBLE);
            fillAdapterCrud(dotZones);
        }else if(type==3){
            //Toast.makeText(getContext(), "eliminar", Toast.LENGTH_SHORT).show();
           // xpand_crud.setVisibility(View.VISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.CustomAlertDialogTheme);
            builder.setTitle("Zona") // Set the title
                    .setMessage("Deseas eliminar esta zona") // Set the message
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Action for "OK" button
                            Toast.makeText(getContext(), "Pendiente eliminar", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Action for "Cancel" button
                            dialog.dismiss(); // Close the dialog
                        }
                    });

// Create and show the dialog
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
    @SuppressLint("PotentialBehaviorOverride")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonServicios:
                //este bottom sheeet es para desplkegar una lista de servicios disponibles
                bootmSheetsServicios bottomSheetDialog = new bootmSheetsServicios();
                bottomSheetDialog.show(getChildFragmentManager(), "bootmSheetsServicios");
                break;
            case R.id.zonesButton:
                zonesConfiguratuon zoneconfig = new zonesConfiguratuon();
                zoneconfig.show(getChildFragmentManager(), "zonesConfiguratuon");
                break;
            case R.id.closeCrud:
                xpand_crud.setVisibility(View.GONE);
                if (dotZonenew != null) {
                    dotZonenew.remove();
                    dotZonenew=null;

                }

                break;
            case R.id.addtextDot:
                if(dotZonenew==null) {
                    dotZonenew = mMap.addMarker(new MarkerOptions().position(mMap.getCameraPosition().target).title("Nuevo punto").draggable(true));
                    mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                        @Override
                        public void onMarkerDragStart(Marker marker) {
                            // Called when the user starts dragging the marker
                            Log.d("MarkerDrag", "Dragging started for: " + marker.getTitle());
                        }

                        @Override
                        public void onMarkerDrag(Marker marker) {
                            // Called repeatedly as the marker is being dragged
                            LatLng position = marker.getPosition();
                            Log.d("MarkerDrag", "Dragging at: " + position.latitude + ", " + position.longitude);
                        }

                        @Override
                        public void onMarkerDragEnd(Marker marker) {
                            // Called when the user stops dragging the marker
                            LatLng finalPosition = marker.getPosition();
                            Log.d("MarkerDrag", "Dragging ended at: " + finalPosition.latitude + ", " + finalPosition.longitude);

                            // Update the marker's position in the adapter
                            adapterCrud.updateDotPosition( finalPosition); // Implement update logic in your adapter
                        }
                    });
                    adapterCrud.addDot(dotZonenew.getPosition());
                }else{
                    Toast.makeText(getContext(), "ya haz creado el marcador", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
}

