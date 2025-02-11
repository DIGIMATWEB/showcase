package com.digimat.showcase.Zonas.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digimat.showcase.Dialogs.dialogFragmentProgress;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.Servicios.bootmSheetsServicios;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dataGetAllZones;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.model.dotZonesm;
import com.digimat.showcase.Zonas.Dialogs.ZonesConfig.zonesConfiguratuon;
import com.digimat.showcase.Zonas.Dialogs.ZonesView.bottomSheetsZonasView;
import com.digimat.showcase.Zonas.adapter.adapterCrudZones;
import com.digimat.showcase.Zonas.adapter.adapterUsers;
import com.digimat.showcase.Zonas.adapter.adapterVehicles;
import com.digimat.showcase.Zonas.adapter.adapterVehiclesCrud;
import com.digimat.showcase.Zonas.adapter.adapterVehiclesCrudDetail;
import com.digimat.showcase.Zonas.model.getUsers.dataFullUsers;
import com.digimat.showcase.Zonas.model.getVehicles.dataVehicles;
import com.digimat.showcase.Zonas.model.getVehicles.dotVehiclesPath;
import com.digimat.showcase.Zonas.presenter.presenterComunities;
import com.digimat.showcase.Zonas.presenter.presenterComunitiesImpl;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Zonas extends Fragment implements OnMapReadyCallback ,zonasView,View.OnClickListener{
    public static final String TAG = Zonas.class.getSimpleName();
    private MapView mView;
    private GoogleMap mMap;
    private List<dataFullUsers> usersAll;
    private presenterComunities presenter;
    private Marker vehicle;
    private KmlLayer mKmlLayer;
    private ImageView buttonServicios,colonias,zonesButton,users,vehiculosB,vehiculos;
    private ConstraintLayout xpand_crud,xpand_usercrud,xpand_vehiclescrud,xpand_vehiclescrudView,xpand_vehicle_detail;
    private ImageButton closeCrud,updateCrud,closeCrudVehiclesDetail,updatePath;

    private RecyclerView rvDetailZones;

    private adapterCrudZones adapterCrud;
    private List<dotZonesm> dotZones;
    private List<dotVehiclesPath> dotPath;
    private TextView addtextDot;
    private TextView addtextDotVehicle;
    private Marker dotZonenew;
    private Marker dotPathnew;
    private String zoneId;
    private String nameZone;
    private String descZone;
    private String ratio;
    private Integer typeEditZone;
    private EditText nameZoneEdtx;
    private EditText descZoneEdtxt;
    private TextView textView5;
    private EditText ratioEdtxt;
    private Polygon editablePoligon;
    private Circle editableCircle;
    private Polyline polylinePath;
    private ImageView imageTypeZone;
    private adapterUsers madapterUsrs;
    private RecyclerView rvUsrs;
    private Switch switchrank,switchVehicles,switchVehicles_view;
    private RecyclerView rvVehicles_view,rvVehicles;
    private adapterVehicles adapterV;
    private adapterVehiclesCrud madapterVehiclesCrud;
    private adapterVehiclesCrudDetail madapterVehiclesCrudDetail;
    private List<Marker> markerVehiculos=new ArrayList<>();
    private Map<String, Marker> markerVehiculosMap = new HashMap<>();
    private Handler handler;
    private Runnable periodicTask;
    private ImageView close_crud_vehicles_view;
    private  List<dataVehicles> mvehicles;
    private Marker currentVehicle;
    private String currentVehicleId;
    private RecyclerView rvDetailVehicleDots;
    private String path;
    private dialogFragmentProgress dialogProgres;
    private Switch switchFreeDotMode;
    private List<LatLng> freemode = new ArrayList<>();
    private Polyline polylinefreemode;
    List<dotZonesm> freModeDotsZones=new ArrayList<>();
    private bottomSheetsZonasView bottomSheetsZonasViewDialog;
    private Set<String> uniquePositions = new HashSet<>();
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
        callVehicles();
        presenter.requestUsers();
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
        xpand_usercrud =view.findViewById(R.id.xpand_usercrud);
        xpand_vehiclescrud =view.findViewById(R.id.xpand_vehiclescrud);
        xpand_vehicle_detail =view.findViewById(R.id.xpand_vehicle_detail);

        xpand_vehiclescrudView =view.findViewById(R.id.xpand_vehiclescrudView);
        zonesButton =view.findViewById(R.id.zonesButton);
        vehiculosB=view.findViewById(R.id. vehiculosB);
        vehiculos=view.findViewById(R.id.  vehiculos);
        users =view.findViewById(R.id.users);
        close_crud_vehicles_view =view.findViewById(R.id. close_crud_vehicles_view);
        closeCrud =view.findViewById(R.id.closeCrud);
        closeCrudVehiclesDetail =view.findViewById(R.id. closeCrudVehiclesDetail);
        updatePath =view.findViewById(R.id.updatePath);
        rvDetailZones =view.findViewById(R.id.rvDetailZones);
        rvUsrs =view.findViewById(R.id.rvUsrs);
        rvVehicles_view =view.findViewById(R.id.rvVehicles_view);
        rvVehicles =view.findViewById(R.id. rvVehicles);
        rvDetailVehicleDots=view.findViewById(R.id.rvDetailVehicleDots);
        switchrank =view.findViewById(R.id.switchrank);
        switchFreeDotMode =view.findViewById(R.id.switchFreeDotMode);
        textView5= view.findViewById(R.id.textView5);
        switchrank.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Acción cuando el Switch está encendido
                    Log.d("Switch", "Encendido");
                } else {
                    // Acción cuando el Switch está apagado
                    Log.d("Switch", "Apagado");
                }
            }
        });
        switchFreeDotMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Acción cuando el Switch está encendido
                    Log.e("Switch", "Free mode");
                    addtextDot.setText("Free mode");
                    addtextDot.setEnabled(false);
                    mMap.clear();
                    freModeDotsZones.clear();
                    manageFreepoligonPoliline();
                } else {
                    // Acción cuando el Switch está apagado
                    freModeDotsZones.clear();
                    Log.e("Switch", "Agregar");
                    addtextDot.setText("Agregar");
                    addtextDot.setEnabled(true);
                }
            }
        });
        switchVehicles =view.findViewById(R.id.switchVehicles);
        switchVehicles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Acción cuando el Switch está encendido
                    if(madapterVehiclesCrud!=null){
                        madapterVehiclesCrud.filterByReal(mvehicles);
                    }
                } else {
                    // Acción cuando el Switch está apagado
                    if(madapterVehiclesCrud!=null) {
                        madapterVehiclesCrud.filterByBots(mvehicles);

                    }
                }
            }
        });
        switchVehicles_view  =view.findViewById(R.id.switchVehicles_view);
        switchVehicles_view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Acción cuando el Switch está encendido

                    if(adapterV!=null){
                        adapterV.filterByReal(mvehicles);
                    }
                } else {
                    // Acción cuando el Switch está apagado
                    if(adapterV!=null) {
                        adapterV.filterByBots(mvehicles);

                    }
                }
            }
        });
        addtextDot=view.findViewById(R.id. addtextDot);
        addtextDotVehicle=view.findViewById(R.id. addtextDotVehicle);
        updateCrud=view.findViewById(R.id. updateCrud);

        nameZoneEdtx=view.findViewById(R.id.nameZoneEdtx);
        descZoneEdtxt=view.findViewById(R.id.descZoneEdtxt);
        ratioEdtxt=view.findViewById(R.id.ratioEdtxt);
        ratioEdtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(mMap!=null){
                    mMap.clear();
                }
                if(!editable.toString().isEmpty()) {
                    ratio = editable.toString();
                    if(adapterCrud!=null) {
                        if(editableCircle!=null) {
                            adapterCrud.notifyDataSetChanged();
                        }
                    }
                }else{
                    ratio="50";
                    if(adapterCrud!=null) {
                        if(editableCircle!=null) {
                            adapterCrud.notifyDataSetChanged();
                        }
                    }
                }

            }
        });
        imageTypeZone=view.findViewById(R.id. imageTypeZone);
        updateCrud.setOnClickListener(this);
        addtextDot.setOnClickListener(this);
        addtextDotVehicle.setOnClickListener(this);
        closeCrud.setOnClickListener(this);
        closeCrudVehiclesDetail.setOnClickListener(this);
        updatePath.setOnClickListener(this);
        zonesButton.setOnClickListener(this);
        vehiculosB.setOnClickListener(this);
        vehiculos.setOnClickListener(this);
        users.setOnClickListener(this);
        buttonServicios.setOnClickListener(this);
        colonias.setOnClickListener(this);
        close_crud_vehicles_view.setOnClickListener(this);
        presenter= new presenterComunitiesImpl(this,getContext());
        dialogProgres= new dialogFragmentProgress();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        dialogProgres.show(fragmentManager, "dialogFragmentProgress");
    }

    private void manageFreepoligonPoliline() {
        mMap.setOnMapLongClickListener(latLng -> {
            // Convertir latLng en una clave única
            String key = latLng.latitude + "," + latLng.longitude;

            // Verificar si el punto ya existe en la lista
            if (!uniquePositions.contains(key)) {
                // Agregar punto a la lista global de control
                uniquePositions.add(key);

                // Agregar punto a la lista
                freemode.add(latLng);

                // Agregar marcador en la posición seleccionada
                mMap.addMarker(new MarkerOptions().position(latLng).title("Punto " + freemode.size()));

                // Dibujar la Polilínea
                actualizarPolilineaFreeMode();

                // Mostrar los puntos en Logcat
                Log.d("PUNTOS", "Lista de Puntos: " + freemode);

                if (adapterCrud != null) {
                    // Limpiar la lista antes de llenarla para evitar duplicados
                    freModeDotsZones.clear();

                    // Agregar solo puntos únicos
                    for (LatLng position : freemode) {
                        freModeDotsZones.add(new dotZonesm(String.valueOf(position.latitude), String.valueOf(position.longitude)));
                    }

                    // Uncomment if needed
                     if (freModeDotsZones.size() > 2) {
                         adapterCrud.fillRvFreemode(freModeDotsZones);
                     }
                }
            } else {
                Log.d("PUNTOS", "El punto ya existe, no se agregará nuevamente.");
            }
        });
    }

    private void actualizarPolilineaFreeMode() {
        if (polylinefreemode != null) {
            polylinefreemode.remove();
        }

        // Dibujar la nueva polilínea sin duplicados
        polylinefreemode = mMap.addPolyline(new PolylineOptions()
                .addAll(freemode)  // Ya está filtrado para que no haya repetidos
                .width(8f)
                .color(Color.BLUE)
                .geodesic(true));
    }
    //region map config
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.clear();
       // mMap.setTrafficEnabled(true);

        callKml();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.9567483, -98.9710052), 11.5f));

        uiSettingsMap(mMap);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.9567483, -98.9710052), 12.4f));
                dialogProgres.dismiss();
            }
        }, 4000);
        if(mvehicles!=null){
            setVehiclesInMap();
        }

    }

    private void callVehicles() {
        handler = new Handler(Looper.getMainLooper());

        // Define the periodic task
        periodicTask = new Runnable() {
            @Override
            public void run() {
                // Call the method in the presenter
                presenter.getVehicles();

                // Re-schedule the task to run again in 10 seconds
                handler.postDelayed(this, 10000); // 10000 ms = 10 seconds
            }
        };
    }

    private void callKml() {
        try {
            KmlLayer kmlLayer = new KmlLayer(mMap, R.raw.tlayacapan, getContext());
            kmlLayer.addLayerToMap();

            // Optionally handle KML features
            for (KmlPlacemark placemark : kmlLayer.getPlacemarks()) {
                if (placemark.getGeometry() instanceof KmlPolygon) {
                    KmlPolygon polygon = (KmlPolygon) placemark.getGeometry();
                    Log.d("KML", "Polygon: " + polygon.getGeometryObject());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if(handler!=null) {
            handler.post(periodicTask);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(handler!=null) {
            handler.removeCallbacks(periodicTask);
        }
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
        if(handler!=null) {
        handler.removeCallbacks(periodicTask);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mView.onDestroy();
    }
    //endregion
    @Override
    public void setUsers(List<dataFullUsers> data) {
    this.usersAll=data;
        setMarkers(usersAll);//
        fillUssers(usersAll);

    }

    private void fillUssers(List<dataFullUsers> usersAll) {
         LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvUsrs.setLayoutManager(layoutManager);
        madapterUsrs = new adapterUsers(this, usersAll, getContext());
        rvUsrs.setAdapter(madapterUsrs);

    }
    private void fillVehiclesAdmin(){//este metodo es para los vehiculos del admin
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvVehicles.setLayoutManager(layoutManager);
        madapterVehiclesCrud=new adapterVehiclesCrud(this,getContext(),mvehicles,true);
        rvVehicles.setAdapter(madapterVehiclesCrud);
    }
    private void fillVehiclesAdminDetail(){//este metodo es para los puntos del path
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvDetailVehicleDots.setLayoutManager(layoutManager);
        madapterVehiclesCrudDetail=new adapterVehiclesCrudDetail(this,getContext(),path);
        rvDetailVehicleDots.setAdapter(madapterVehiclesCrudDetail);
    }
    private void fillVehicles(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvVehicles_view.setLayoutManager(layoutManager);
        adapterV=new adapterVehicles(this,getContext(),mvehicles,true);
         rvVehicles_view.setAdapter(adapterV);
    }
    public void drawPosition(dataVehicles dataVehicles) {//este metodo es para los vehiculos del admin y pra el path
        Log.e("path","vehiclePath "+dataVehicles.getPath());
        LatLng postionCurrentVehicle=new LatLng(Double.valueOf(dataVehicles.getLatitude()),Double.valueOf(dataVehicles.getLongitude()));
        MarkerOptions markerOptions = new MarkerOptions()
                .position(postionCurrentVehicle)
                .title(dataVehicles.getVehicleId())
                .snippet("Velocidad: " + dataVehicles.getSpeed() + " km/h")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)); // Personalizar color

        currentVehicle=mMap.addMarker(markerOptions);
        currentVehicleId=dataVehicles.getVehicleId();
        //TODO mostrar constrain con ruta de path
        xpand_vehicle_detail.setVisibility(View.VISIBLE);
        xpand_vehiclescrud .setVisibility(View.GONE);
        this.path=dataVehicles.getPath();
        fillVehiclesAdminDetail();
        if(dotPath!=null) {
            refreshDrawPathPoliline(dotPath);
        }
    }
    @Override
    public void setVehiclePath(String data) {
        Log.e("savePath","datos salvados Path = "+data                                                                     );

    }
    public void goUserLocation(LatLng locationUser) {
        Toast.makeText(getContext(), "ir a la ubicacion del usuario", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void closeEdiotorZone() {
        mMap.clear();
        closeCrud.performClick();
    }

    @Override
    public void drawZonesOnView(List<dataGetAllZones> data) {
        if(data!=null){
            bottomSheetsZonasViewDialog.checkExistingZone(data);
        }
        for(dataGetAllZones zone:data){
            setUpPoligonOrCircle(zone.getDotZoness());

        }
    }

    @Override
    public void setVehicles(List<dataVehicles> data) {
        Log.e("vehiculos", "Se solicitan vehiculos");
        this.mvehicles=data;
        if(mvehicles!=null){
            setVehiclesInMap();
        }
    }
    //region animation marker
    private void setVehiclesInMap() {
        if (mvehicles == null || mvehicles.isEmpty()) {
            return; // Evitar errores si la lista está vacía o nula.
        }

        // Verificar que mMap está correctamente inicializado
        if (mMap == null) {
            return;
        }

        // Crear un mapa temporal para rastrear los marcadores actualizados
        Map<String, Marker> updatedMarkers = new HashMap<>();

        // Recorrer los datos y agregar o actualizar los marcadores
        for (dataVehicles vehiculo : mvehicles) {
            String vehicleId = vehiculo.getVehicleId();
            LatLng position = new LatLng(
                    Double.valueOf(vehiculo.getLatitude()),
                    Double.valueOf(vehiculo.getLongitude())
            );

            // Verificar si los datos del vehículo son correctos
            if (position.latitude == 0 || position.longitude == 0) {
                continue; // Salta este vehículo si la posición es inválida
            }

            // Verificar si ya existe un marcador para este vehículo en el mapa
            Marker marker = markerVehiculosMap.get(vehicleId);
            if (marker != null) {
                // Si ya existe un marcador, lo actualizamos con animación
                LatLng oldPosition = marker.getPosition();
                if (!oldPosition.equals(position)) {
                    // Animate the marker to the new position
                    animateMarker(marker, position,getContext());
                }
                marker.setSnippet("Velocidad: " + vehiculo.getSpeed() + " km/h");
            } else {
                // Si el marcador no existe, creamos uno nuevo
                MarkerOptions markerOptions = new MarkerOptions()
                        .position(position)
                        .title("Vehículo ID: " + vehicleId)
                        .anchor(.5f,.5f)
                        .snippet("Velocidad: " + vehiculo.getSpeed() + " km/h")
                        .icon(getBitmapDescriptorFromVector(getContext(),R.drawable.d,.85f))//BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)) // Personalizar color
                        .draggable(false); // Hacerlo no arrastrable si no es necesario

                // Agregar el nuevo marcador al mapa
                marker = mMap.addMarker(markerOptions);
                if (marker != null) {
                    // Añadimos el nuevo marcador al mapa de marcadores
                    markerVehiculosMap.put(vehicleId, marker);
                    updatedMarkers.put(vehicleId, marker);
                }
            }
        }

        // Actualizamos el mapa de marcadores activos con los nuevos
        // No necesitamos eliminar los marcadores que ya están presentes.
        markerVehiculosMap.putAll(updatedMarkers);

    }

    // Método para animar un marcador de su posición antigua a la nueva
    private void animateMarker(final Marker marker, final LatLng toPosition, Context context) {
        final LatLng fromPosition = marker.getPosition();
        final long duration = 1000; // Duración de la animación en milisegundos

        // Calcular la dirección del movimiento
        final float bearing = computeBearing(fromPosition, toPosition);
        final int resourceId = getMarkerResourceForBearing(bearing);

        // Obtener el BitmapDescriptor correcto
        final BitmapDescriptor icon = getBitmapDescriptorFromVector(context, resourceId,.85f);

        // Aplicar solo una vez el cambio de ícono antes de la animación
        marker.setIcon(icon);

        // Interpolador para interpolar entre dos latitudes y longitudes
        LatLngInterpolator latLngInterpolator = new LatLngInterpolator.LinearFixed();
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(duration);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                LatLng currentPosition = latLngInterpolator.interpolate(fraction, fromPosition, toPosition);
                marker.setPosition(currentPosition);
            }
        });
        valueAnimator.start();
    }
    // Interpolador para movimiento suave entre latitudes y longitudes
    public interface LatLngInterpolator {
        LatLng interpolate(float fraction, LatLng from, LatLng to);

        class LinearFixed implements LatLngInterpolator {
            @Override
            public LatLng interpolate(float fraction, LatLng from, LatLng to) {
                double lat = from.latitude + (to.latitude - from.latitude) * fraction;
                double lng = from.longitude + (to.longitude - from.longitude) * fraction;
                return new LatLng(lat, lng);
            }
        }
    }
    private float computeBearing(LatLng fromPosition, LatLng toPosition) {
        double lat1 = Math.toRadians(fromPosition.latitude);
        double lon1 = Math.toRadians(fromPosition.longitude);
        double lat2 = Math.toRadians(toPosition.latitude);
        double lon2 = Math.toRadians(toPosition.longitude);

        double dLon = lon2 - lon1;

        double y = Math.sin(dLon) * Math.cos(lat2);
        double x = Math.cos(lat1) * Math.sin(lat2) - Math.sin(lat1) * Math.cos(lat2) * Math.cos(dLon);

        double initialBearing = Math.atan2(y, x);

        // Convertir de radianes a grados y normalizar el ángulo
        return (float) ((Math.toDegrees(initialBearing) + 360) % 360);
    }
    private int getMarkerResourceForBearing(float bearing) {
        int angle = Math.round(bearing / 30) * 30; // Redondear al múltiplo de 30 más cercano

        switch (angle) {
            case 0:
                Log.e("angleV","0");
                return R.drawable.a;
            case 30:
                Log.e("angleV","30");
                return R.drawable.b;
            case 60:
                Log.e("angleV","60");
                return R.drawable.c;
            case 90:
                Log.e("angleV","90");
                return R.drawable.d;
            case 120:
                Log.e("angleV","120");
                return R.drawable.d;
            case 150:
                Log.e("angleV","150");
                return R.drawable.g;
            case 180:
                Log.e("angleV","180");
                return R.drawable.h;
            case 210:
                Log.e("angleV","210");
                return R.drawable.h;
            case 240:
                Log.e("angleV","240");
                return R.drawable.j;
            case 270:
                Log.e("angleV","270");
                return R.drawable.k;
            case 300:
                Log.e("angleV","300");
                return R.drawable.h;
            case 330:
                Log.e("angleV","330");
                return R.drawable.a;
            default:
                Log.e("angleV","default");
                return R.drawable.d; // Imagen por defecto
        }
    }
    private BitmapDescriptor getBitmapDescriptorFromVector(Context context, int vectorResId, float scale) {
        // Get the vector drawable
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        if (vectorDrawable == null) return null;

        // Scale the drawable by adjusting the width and height
        int width = (int) (vectorDrawable.getIntrinsicWidth() * scale);
        int height = (int) (vectorDrawable.getIntrinsicHeight() * scale);

        // Set the bounds for the drawable to scale it
        vectorDrawable.setBounds(0, 0, width, height);

        // Create a bitmap with the scaled size
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);

        // Draw the vector onto the canvas
        vectorDrawable.draw(canvas);

        // Return the bitmap as a BitmapDescriptor
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    //endregion
    public void goToBoundsZone(dataGetAllZones zone) {
        //
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();

        for(dotZonesm dot :zone.getDotZoness())
        {
            LatLng dotfinal=new LatLng(Double.valueOf( dot.getLatitud()),Double.valueOf(dot.getLongitud()));
            boundsBuilder.include(dotfinal);
        }
        // Create LatLngBounds from the builder
        LatLngBounds bounds = boundsBuilder.build();

        // Create a camera update to fit the bounds with a padding (adjust padding as necessary)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, 100); // 100 is the padding in pixels

        // Move the camera to fit the bounds
        mMap.moveCamera(cameraUpdate);

    }


    private void setMarkers(List<dataFullUsers> mUsers) {//estos son los usuarios
        if(mMap!=null) {
            for (int i = 0; i < mUsers.size(); i++) {
                double lat = Double.parseDouble(mUsers.get(i).getLatUser());
                double lng = Double.parseDouble(mUsers.get(i).getLongUser());
                LatLng ubicacion = new LatLng(lat, lng);
                mMap.addMarker(new MarkerOptions()
                        .position(ubicacion)
                        .title("Marker " + i));
            }
        }
    }
    private void fillAdapterCrud(List<dotZonesm> dotZoness) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvDetailZones.setLayoutManager(layoutManager);

        adapterCrud = new adapterCrudZones(this, dotZoness, getContext());
        rvDetailZones.setAdapter(adapterCrud);

        // Attach ItemTouchHelper for swipe functionality
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // No move action needed
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Get the position of the item that was swiped
                int position = viewHolder.getAdapterPosition();

                // Remove the item from the adapter and the list
                mMap.clear();
                adapterCrud.notifyRemovedOnSwipe(position);
            }
        });

        itemTouchHelper.attachToRecyclerView(rvDetailZones);
        if(!dotZoness.isEmpty()){
        setUpPoligonOrCircle(dotZoness);
        }
    }

    private void setUpPoligonOrCircle(List<dotZonesm> dotZoness) {
        if(dotZoness.size()==1) {
            Glide.with(getContext()).load(R.drawable.circles).into(imageTypeZone);
            ratioEdtxt.setVisibility(View.VISIBLE);
            int alfa= ContextCompat.getColor(getContext(), R.color.alfa);
            int bluealfa= ContextCompat.getColor(getContext(), R.color.blueAddwithalpha);
             editableCircle = mMap.addCircle(new CircleOptions()
                    .center(new LatLng( Double.valueOf(dotZoness.get(0).getLatitud()),  Double.valueOf(dotZoness.get(0).getLongitud())))
                     .radius(Double.valueOf(ratio == null || ratio.isEmpty() ? "50" : ratio))
                     .strokeColor(alfa)
                    .strokeWidth(0)
                    .strokeWidth(3)
                    .fillColor(bluealfa));
        }else if(dotZoness.size()==2){
            Glide.with(getContext()).load(R.drawable.circles).into(imageTypeZone);
            Toast.makeText(getContext(), "agregar un punto para crear un poligono o eliminalo para crear un circulo", Toast.LENGTH_SHORT).show();//todo crear un dialogo con esto
        }
        else if(dotZoness.size()>=3){
            Glide.with(getContext()).load(R.drawable.poligons).into(imageTypeZone);
            textView5.setVisibility(View.GONE);
            ratioEdtxt.setVisibility(View.GONE);
            int alfa= ContextCompat.getColor(getContext(), R.color.alfa);
            int bluealfa= ContextCompat.getColor(getContext(), R.color.blueAddwithalfa);
            List <LatLng> dotPosition=new ArrayList<>() ;
            dotPosition.clear();
            for(dotZonesm dots:dotZoness){
                dotPosition.add(new LatLng( Double.valueOf( dots.getLatitud()), Double.valueOf(dots.getLongitud())));
            }
        editablePoligon= mMap.addPolygon(new PolygonOptions()
                    .addAll(dotPosition)
                    .strokeColor(Color.BLACK)
                        .strokeWidth(3)
                    .fillColor(bluealfa));

        }
    }

    public void setDots(List<dotZonesm> dotZoness) {//guarda los puntos del recycler heredado
        this.dotZones=dotZoness;

    }
    public void editZonesValues(String zoneId, String descZone, String ratio, String zoneName) {
        this.zoneId=zoneId;
        this.nameZone=zoneName;
        this.descZone=descZone;
        this.ratio=ratio;
        nameZoneEdtx.setText(zoneName);
        descZoneEdtxt.setText(descZone);
        ratioEdtxt.setText(ratio);
    }
    public void ZoneCrud(Integer type) {
        callKml();
        this.typeEditZone=type;
        if(typeEditZone==1){
            //Toast.makeText(getContext(), "crear", Toast.LENGTH_SHORT).show();
            xpand_crud.setVisibility(View.VISIBLE);
            List<dotZonesm> dotZoness=new ArrayList<>();

            /**esto es para inicializar la zona con valor minimo ya que no se ve en el mapa menos de 50*/
            Glide.with(getContext()).load(R.drawable.circles).into(imageTypeZone);
            ratio="50";
            ratioEdtxt.setText("50");
            /***/

            fillAdapterCrud(dotZoness);
        }else if(typeEditZone==2){
           // Toast.makeText(getContext(), "editar", Toast.LENGTH_SHORT).show();
            xpand_crud.setVisibility(View.VISIBLE);
            fillAdapterCrud(dotZones);
        }else if(typeEditZone==3){
            //Toast.makeText(getContext(), "eliminar", Toast.LENGTH_SHORT).show();
           // xpand_crud.setVisibility(View.VISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), R.style.CustomAlertDialogTheme);
            builder.setTitle("Zona") // Set the title
                    .setMessage("Deseas eliminar esta zona") // Set the message
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Action for "OK" button
                            presenter.eraseZones(zoneId);
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

    public void saveNewDot(List<dotZonesm> dotZoness, int position) {

        if (dotZonenew != null) {/**esto solo remuieve el marcador de nuevo punto creado*/
            dotZonenew.remove();
            dotZonenew=null;

        }
        this.dotZones=dotZoness;
        mMap.clear();
        adapterCrud.UpdateView(dotZones);
    }
    public void saveNewDotV(List<dotVehiclesPath> pathDots, int position) {

            if (dotPathnew != null) {/**esto solo remuieve el marcador de nuevo punto creado*/
                dotPathnew.remove();
                dotPathnew=null;

            }
            this.dotPath=pathDots;
            //mMap.clear();
        refreshDrawPathPoliline(pathDots);
            madapterVehiclesCrudDetail.UpdateView(dotPath);
        }

    public void removeNewDot(List<dotZonesm> dotZoness, int position) {
        if (dotZonenew != null) {/**esto solo remuieve el marcador de nuevo punto creado*/
            dotZonenew.remove();
            dotZonenew=null;

        }
        this.dotZones=dotZoness;
        adapterCrud.notifyRemoved(position);
    }
      public void removeNewDotV(List<dotVehiclesPath> pathDots, int position) {
            if (dotPathnew != null) {/**esto solo remuieve el marcador de nuevo punto creado*/
                dotPathnew.remove();
                dotPathnew=null;

            }
            this.dotPath=pathDots;
          refreshDrawPathPoliline(pathDots);
            madapterVehiclesCrudDetail.notifyRemoved(position);
        }
    private void refreshDrawPathPoliline(List<dotVehiclesPath> pathDots) {
        if(pathDots!=null) {
            if(pathDots.size()>1) {
                int bluealfa= ContextCompat.getColor(getContext(), R.color.purple_700);
                PolylineOptions polylineOptions = new PolylineOptions()
                        .color(bluealfa) // Azul (ARGB)
                        .width(10);
                for (dotVehiclesPath dot : pathDots) {
                    LatLng dotPos = new LatLng(
                            Double.valueOf(dot.getLatitud()),
                            Double.valueOf(dot.getLongitud())
                    );
                    polylineOptions.add(dotPos);
                }

                polylinePath = mMap.addPolyline(polylineOptions);
                this.dotPath=pathDots;
                if(madapterVehiclesCrudDetail!=null) {
                    madapterVehiclesCrudDetail.notifyDataSetChanged();
                }
            }else{
                Toast.makeText(getContext(), "Nesecitas agregar al menos dos puntos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressLint("PotentialBehaviorOverride")
    public void editDotVehicle(List<dotVehiclesPath> pathDots, int position, String latitud, String longitud) {//este metodo deberia de crear una polilinea
        //Toast crear polilinea
        refreshDrawPathPoliline(pathDots);
        LatLng dotPos = new LatLng(
                Double.valueOf(latitud),
                Double.valueOf(longitud)
        );

        Marker marker = mMap.addMarker(new MarkerOptions()
                        .position(dotPos)
                        .title("punto "+position)
                        .draggable(true));
        Log.d("MarkerDrag1", "Marcador " + marker.getTitle()+" marcadorlat: "+latitud+" marcadorlong: "+longitud);
        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                Log.d("MarkerDrag", "Inicio de arrastre: " + marker.getTitle());
            }

            @Override
            public void onMarkerDrag(Marker marker) {
                LatLng position = marker.getPosition();
              //  Log.d("MarkerDrag", "Arrastrando: " + position.latitude + ", " + position.longitude);
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                // Obtén la nueva posición del marcador
                LatLng finalLatLong = marker.getPosition();
                Log.e("MarkerDrag", "vDragging ended at v1 b: " + finalLatLong.latitude + ", " + finalLatLong.longitude);

                // Update the marker's position in the adapter
                mMap.clear();
                pathDots.get(position).setLatitud(String.valueOf(finalLatLong.latitude));
                pathDots.get(position).setLongitud(String.valueOf(finalLatLong.longitude));
                refreshDrawPathPoliline(pathDots);
                marker.remove();
                marker=null;
            }
        });
    }


    @SuppressLint("PotentialBehaviorOverride")
    public void editDotZone(List<dotZonesm> dotZoness, int position) {//este metodo es para crear poligonos detecta si hay un punto(crea un circulo), dos(solicita un punto extra) o 3(crea un poligono triangular)
        // Verificar el tamaño de dotZoness y proceder según el caso
        Log.e("drawTempZone","Editar dotZoness: "+dotZoness.size());
        if (dotZoness.size() == 1) {
            Log.e("Editar","click circulo");
            // Si hay solo 1 punto, dibujar un círculo
            LatLng dotPos = new LatLng(
                    Double.valueOf(dotZoness.get(position).getLatitud()),
                    Double.valueOf(dotZoness.get(position).getLongitud())
            );

            // Dibujar un círculo en lugar de un marcador
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(dotPos)
                    .title("Editando punto")
                    .draggable(true)
            );
            int alfa= ContextCompat.getColor(getContext(), R.color.alfa);
            int bluealfa= ContextCompat.getColor(getContext(), R.color.blueAddwithalpha);
            editableCircle = mMap.addCircle(new CircleOptions()
                    .center(new LatLng( Double.valueOf(dotZoness.get(0).getLatitud()),  Double.valueOf(dotZoness.get(0).getLongitud())))
                    .radius(Double.valueOf(ratio == null || ratio.isEmpty() ? "50" : ratio))
                    .strokeColor(alfa)
                    .strokeWidth(3)
                    .fillColor(bluealfa));
            mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                @Override
                public void onMarkerDragStart(Marker marker) {
                    Log.d("MarkerDrag", "Inicio de arrastre: " + marker.getTitle());
                }

                @Override
                public void onMarkerDrag(Marker marker) {
                    LatLng position = marker.getPosition();
                    Log.d("MarkerDrag", "Arrastrando: " + position.latitude + ", " + position.longitude);
                }

                @Override
                public void onMarkerDragEnd(Marker marker) {
                    // Obtén la nueva posición del marcador
                    LatLng finalPosition = marker.getPosition();
                    Log.e("MarkerDrag", "Dragging ended at v1: " + finalPosition.latitude + ", " + finalPosition.longitude);

                    // Update the marker's position in the adapter
                    mMap.clear();
                    adapterCrud.updateDotPosition( finalPosition);
                }
            });

        } else if (dotZoness.size() == 2) {
            // Si hay 2 puntos, no hacer nada
            Log.d("editDotZone", "No se realiza ninguna acción con 2 puntos.");
        } else if (dotZoness.size() >= 3) {
            // Si hay 3 o más puntos, mantener la funcionalidad actual
            // Obtén la posición actual del punto que quieres editar
            LatLng dotPos = new LatLng(
                    Double.valueOf(dotZoness.get(position).getLatitud()),
                    Double.valueOf(dotZoness.get(position).getLongitud())
            );

            // Mueve el marcador al nuevo punto y hazlo editable
            Marker marker = mMap.addMarker(new MarkerOptions()
                    .position(dotPos)
                    .title("Editando punto")
                    .draggable(true)
            );

            // Listener para manejar el evento de arrastre del marcador
            mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                @Override
                public void onMarkerDragStart(Marker marker) {
                    Log.d("MarkerDrag", "Inicio de arrastre: " + marker.getTitle());
                }

                @Override
                public void onMarkerDrag(Marker marker) {
                    LatLng position = marker.getPosition();
                    Log.d("MarkerDrag", "Arrastrando: " + position.latitude + ", " + position.longitude);
                }

                @Override
                public void onMarkerDragEnd(Marker marker) {
                    // Obtén la nueva posición del marcador
                    LatLng finalPosition = marker.getPosition();
                    Log.e("Editar", "Arrastre terminado en: " + finalPosition.latitude + ", " + finalPosition.longitude);

                    // Actualiza el punto en el polígono
                    editablePoligon.getPoints().set(position, finalPosition);

                    // Actualiza los datos en la lista de puntos
                    dotZonesm updatedDot = dotZoness.get(position);
                    updatedDot.setLatitud(String.valueOf(finalPosition.latitude));
                    updatedDot.setLongitud(String.valueOf(finalPosition.longitude));

                    // Opcional: Actualiza el polígono visualmente si es necesario
                    refreshPolygon(editablePoligon, finalPosition, position, dotZoness);

                    // Elimina el marcador, ya que el punto ha sido actualizado
                    marker.remove();
                }
            });
        }
    }
    private void refreshPolygon(Polygon polygon, LatLng finalPosition, int position, List<dotZonesm> dotZoness) {
        if (dotZoness.size() >= 3) {
            // Solo actualiza el polígono si hay 3 o más puntos
            dotZoness.set(position, new dotZonesm(String.valueOf(finalPosition.latitude), String.valueOf(finalPosition.longitude)));
            mMap.clear();
            adapterCrud.updateAtSingularDot(dotZoness);
        } else if (dotZoness.size() == 1) {
            // Si hay solo 1 punto, dibujar un círculo
            LatLng dotPos = new LatLng(
                    Double.valueOf(dotZoness.get(position).getLatitud()),
                    Double.valueOf(dotZoness.get(position).getLongitud())
            );
            int bluealfa= ContextCompat.getColor(getContext(), R.color.blueAddwithalpha);
            // Dibujar un círculo en lugar de un marcador
            mMap.addCircle(new CircleOptions()
                    .center(dotPos)
                    .radius(Double.valueOf( ratio))  // Ajustar el radio según sea necesario
                    .strokeColor(Color.RED)
                    .fillColor(bluealfa)
            );
        }
        // Si hay 2 puntos, no hacer nada
    }


    public void updateAfterScrollMarker(List<dotZonesm> dotZoness) {
        this.dotZones=dotZoness;
    }
    public void updateAfterScrollMarkerV(List<dotVehiclesPath> dotPath) {
        this.dotPath=dotPath;
    }
    @SuppressLint("PotentialBehaviorOverride")
    private void setupDragNewMarker() {//onDragListener Marker
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
                //yLog.d("MarkerDrag", "Dragging at: " + position.latitude + ", " + position.longitude);
            }

            @Override
            public void onMarkerDragEnd(Marker marker) {//este metodo se debe moderar sirve para dos casos el de la zona y el de la ruta del vehiculo
                // Called when the user stops dragging the marker
                LatLng finalPosition = marker.getPosition();
                Log.e("MarkerDrag", "vDragging ended at v1 a: " + finalPosition.latitude + ", " + finalPosition.longitude+" is adapterCrud visible "+adapterCrud);

                // Update the marker's position in the adapter
                if(adapterCrud!=null) {//aqui se maneja solo si el adaptador de la zona no es nulo
                    mMap.clear();
                    if (adapterCrud != null) {
                        adapterCrud.updateDotPosition(finalPosition); // Implement update logic in your adapter
                    }
                }
                if(madapterVehiclesCrudDetail!=null){
                  // mMap.clear();
                    if(madapterVehiclesCrudDetail!=null){
                    madapterVehiclesCrudDetail.updateDotPosition(finalPosition);
                    }
                }
                marker.remove();

            }
        });

        if(adapterCrud!=null){
            if(dotZonenew.getPosition()!=null) {
                adapterCrud.addDot(dotZonenew.getPosition());
            }
        }
        if(madapterVehiclesCrudDetail!=null){
            madapterVehiclesCrudDetail.addDot(dotPathnew.getPosition());
        }
    }
    public void drawTempZone(List<dotZonesm> dotZoness) {
        Log.e("drawTempZone", "drawTempZone");
        mMap.clear();
        if(!dotZoness.isEmpty()){
            setUpPoligonOrCircle(dotZoness);
        }else{
            Log.e("drawTempZone", "drawTempZone is empty");
        }
    }
    public void drawTempPoliline(List<dotVehiclesPath> pathDots){
        Log.e("Path","pendiente dibujarpolilinea");
        if(!pathDots.isEmpty()){
            this.dotPath=pathDots;
        }
    }
    public void updateTempZone(List<dotZonesm> dotZoness) {
        Toast.makeText(getContext(), "updateTempZone", Toast.LENGTH_SHORT).show();
        if(!dotZoness.isEmpty()){
            setUpPoligonOrCircle(dotZoness);
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
            case R.id.colonias:
                bottomSheetsZonasViewDialog= new bottomSheetsZonasView();
                bottomSheetsZonasViewDialog.show(getChildFragmentManager(),"bottomSheetsZonasView");
                presenter.getZonesView();
                break;
            case R.id.users:
                if(xpand_usercrud.getVisibility()==View.VISIBLE){
                    xpand_usercrud.setVisibility(View.GONE);
                }else{
                    xpand_usercrud.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.close_crud_vehicles_view:
                xpand_vehiclescrudView.setVisibility(View.GONE);
                break;
            case R.id.closeCrudVehiclesDetail:
                if (dotPathnew != null) {
                    dotPathnew.remove();
                    dotPathnew=null;

                }
                mMap.clear();
                dotPath.clear();
                switchVehicles_view.setChecked(false);
                xpand_vehicle_detail.setVisibility(View.GONE);
                break;
          case R.id.updatePath:
              presenter.savePathVehicle(currentVehicleId,dotPath);
            xpand_vehicle_detail.setVisibility(View.GONE);
              break;
            case  R.id.vehiculos://TODO esto es para ver vehiculos desde usuario
                if(xpand_vehiclescrudView.getVisibility()==View.VISIBLE){
                    xpand_vehiclescrudView.setVisibility(View.GONE);
                }else{
                    xpand_vehiclescrudView.setVisibility(View.VISIBLE);
                    fillVehicles();
                }

                break;
            case  R.id.vehiculosB://TODO esto es para ver vehiculos desde administrador
                if(xpand_vehiclescrud.getVisibility()==View.VISIBLE){
                    xpand_vehiclescrud.setVisibility(View.GONE);
                }else{
                    xpand_vehiclescrud.setVisibility(View.VISIBLE);
                    fillVehiclesAdmin();
                }
                break;
            case R.id.zonesButton://TODO esto es para zonas
                mMap.clear();
                callKml();
                markerVehiculosMap.clear();
                zonesConfiguratuon zoneconfig = new zonesConfiguratuon();
                zoneconfig.show(getChildFragmentManager(), "zonesConfiguratuon");
                break;
            case R.id.closeCrud://TODO esto es para zonas

                if (dotZonenew != null) {
                    dotZonenew.remove();
                    dotZonenew=null;

                }
                mMap.clear();
                xpand_crud.setVisibility(View.GONE);


                break;
            case R.id.updateCrud://TODO esto es para zonas
                if(typeEditZone==1){
                    Gson gson= new Gson();
                    String json=gson.toJson(dotZones);
                    Log.e("PUNTOS","Dots "+json);
                    if(dotZones!=null) {
                        if(!nameZoneEdtx.getText().toString().isEmpty()) {
                            if(dotZones.size()==1) {
                                Log.e("PUNTOS","one dot");
                                if(!ratioEdtxt.getText().toString().isEmpty()) {

                                    presenter.createZone(nameZoneEdtx.getText().toString(),descZoneEdtxt.getText().toString(), ratioEdtxt.getText().toString(), dotZones);
                                }else{
                                    Log.e("PUNTOS","isEmpty");
                                    Toast.makeText(getContext(), "Necesitas agregar un radio a la zona", Toast.LENGTH_SHORT).show();
                                }
                            }else if(dotZones.size()==2) {
                                Log.e("PUNTOS","two dots");
                                Toast.makeText(getContext(), "Necesitas agregar otro punto a la zona", Toast.LENGTH_SHORT).show();
                            }else{
                                Log.e("PUNTOS","two 3+");
                                if(freModeDotsZones!=null&&freModeDotsZones.size()>3){
                                    dotZones=freModeDotsZones;
                                }
                                presenter.createZone(nameZoneEdtx.getText().toString(),descZoneEdtxt.getText().toString(), "1", dotZones);
                                switchFreeDotMode.setChecked(false);
                            }
                        }else{
                            Toast.makeText(getContext(), "Necesitas agregar un Nombre a la zona", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Log.e("PUNTOS","else dotsnull");
                        if(freModeDotsZones!=null&&freModeDotsZones.size()>3){
                            dotZones=freModeDotsZones;
                            presenter.createZone(nameZoneEdtx.getText().toString(),descZoneEdtxt.getText().toString(), "1", dotZones);
                            switchFreeDotMode.setChecked(false);
                        }else {
                            Toast.makeText(getContext(), "Necesitas guardar al menos un punto antes guardar informacion", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else if(typeEditZone==2){//

                    //nameZoneEdtx
                    //  descZoneEdtxt.getText().toString()
                    Log.e("PUNTOS","type 2 "+freModeDotsZones.size());
                    if(freModeDotsZones!=null&&freModeDotsZones.size()>3){
                        dotZones=freModeDotsZones;
                    }
                    Log.e("PUNTOS","type 2 "+dotZones.size());
                    presenter.updateZone(zoneId,descZoneEdtxt.getText().toString(),ratioEdtxt.getText().toString(),dotZones,nameZoneEdtx.getText().toString());//todo se debe de pooder actualizar el nombre
                    switchFreeDotMode.setChecked(false);
                }
                break;
            case R.id.addtextDotVehicle://TODO esto es para vehiculos administrador y agregar uhn punto
                if(dotPathnew==null){
                    dotPathnew=mMap.addMarker(new MarkerOptions().position(mMap.getCameraPosition().target).title("Nueva marca").draggable(true));
                    setupDragNewMarker();
                }else{
                    Toast.makeText(getContext(), "ya haz creado el marcador", Toast.LENGTH_SHORT).show();
                }
                rvDetailVehicleDots.scrollToPosition(madapterVehiclesCrudDetail.getItemCount() - 1);
                break;
            case R.id.addtextDot://TODO esto es para un punto en la zona
                if(dotZonenew==null) {
                    mMap.clear();
                    dotZonenew = mMap.addMarker(new MarkerOptions().position(mMap.getCameraPosition().target).title("Nuevo punto").draggable(true));
                    setupDragNewMarker();

                }else{
                    Toast.makeText(getContext(), "ya haz creado el marcador", Toast.LENGTH_SHORT).show();
                }
                rvDetailZones.scrollToPosition(adapterCrud.getItemCount() - 1);
                break;
            }

        }
}

