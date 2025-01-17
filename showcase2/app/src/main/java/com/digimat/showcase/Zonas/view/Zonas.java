package com.digimat.showcase.Zonas.view;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.Dialogs.bootmSheetsServicios;
import com.digimat.showcase.Zonas.Dialogs.model.dotZonesm;
import com.digimat.showcase.Zonas.Dialogs.zonesConfiguratuon;
import com.digimat.showcase.Zonas.adapter.adapterCrudZones;
import com.digimat.showcase.Zonas.adapter.adapterUsers;
import com.digimat.showcase.Zonas.model.getVehicles.dataFullUsers;
import com.digimat.showcase.Zonas.presenter.presenterComunities;
import com.digimat.showcase.Zonas.presenter.presenterComunitiesImpl;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.gson.Gson;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;

import java.util.ArrayList;
import java.util.List;

public class Zonas extends Fragment implements OnMapReadyCallback ,zonasView,View.OnClickListener{
    public static final String TAG = Zonas.class.getSimpleName();
    private MapView mView;
    private GoogleMap mMap;
    private List<dataFullUsers> usersAll;
    private presenterComunities presenter;
    private Marker vehicle;
    private KmlLayer mKmlLayer;
    private ImageView buttonServicios,colonias,zonesButton,users,vehiculosB;
    private ConstraintLayout xpand_crud,xpand_usercrud,xpand_vehiclescrud;
    private ImageButton closeCrud,updateCrud;

    private RecyclerView rvDetailZones;

    private adapterCrudZones adapterCrud;
    private List<dotZonesm> dotZones;
    private TextView addtextDot;
    private Marker dotZonenew;
    private String zoneId;
    private String nameZone;
    private String descZone;
    private String ratio;
    private Integer typeEditZone;
    private EditText nameZoneEdtx;
    private EditText descZoneEdtxt;
    private EditText ratioEdtxt;
    private Polygon editablePoligon;
    private Circle editableCircle;
    private ImageView imageTypeZone;
    private adapterUsers madapterUsrs;
    private RecyclerView rvUsrs;
    private Switch switchrank;
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
        xpand_usercrud =view.findViewById(R.id.xpand_usercrud);
        xpand_vehiclescrud =view.findViewById(R.id.xpand_vehiclescrud);
        zonesButton =view.findViewById(R.id.zonesButton);
        vehiculosB=view.findViewById(R.id. vehiculosB);
        users =view.findViewById(R.id.users);
        closeCrud =view.findViewById(R.id.closeCrud);

        rvDetailZones =view.findViewById(R.id.rvDetailZones);
        rvUsrs =view.findViewById(R.id.rvUsrs);
        switchrank =view.findViewById(R.id.switchrank);
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
        addtextDot=view.findViewById(R.id. addtextDot);
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
        closeCrud.setOnClickListener(this);
        zonesButton.setOnClickListener(this);
        vehiculosB.setOnClickListener(this);
        users.setOnClickListener(this);
        buttonServicios.setOnClickListener(this);
        presenter= new presenterComunitiesImpl(this,getContext());

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
            }
        }, 4000);
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
    public void goUserLocation(LatLng locationUser) {
        Toast.makeText(getContext(), "ir a la ubicacion del usuario", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void closeEdiotorZone() {
        mMap.clear();
        closeCrud.performClick();
    }

    private void setMarkers(List<dataFullUsers> mUsers) {
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
                    .radius(Double.valueOf(ratio.isEmpty() ? "50" : ratio))

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

    public void removeNewDot(List<dotZonesm> dotZoness, int position) {
        if (dotZonenew != null) {/**esto solo remuieve el marcador de nuevo punto creado*/
            dotZonenew.remove();
            dotZonenew=null;

        }
        this.dotZones=dotZoness;
        adapterCrud.notifyRemoved(position);
    }
    @SuppressLint("PotentialBehaviorOverride")
    public void editDotZone(List<dotZonesm> dotZoness, int position) {
        // Verificar el tamaño de dotZoness y proceder según el caso
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
                    .radius(Double.valueOf(ratio.isEmpty() ? "50" : ratio))

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
                    Log.e("Editar", "Dragging ended at v1: " + finalPosition.latitude + ", " + finalPosition.longitude);

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
    @SuppressLint("PotentialBehaviorOverride")
    private void setupDragNewMarker() {
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
                Log.e("Editar", "Dragging ended at v1: " + finalPosition.latitude + ", " + finalPosition.longitude);

                // Update the marker's position in the adapter
                mMap.clear();
                adapterCrud.updateDotPosition( finalPosition); // Implement update logic in your adapter

            }
        });

        adapterCrud.addDot(dotZonenew.getPosition());
    }
    public void drawTempZone(List<dotZonesm> dotZoness) {
        Log.e("drawTempZone", "drawTempZone");
        if(!dotZoness.isEmpty()){
            setUpPoligonOrCircle(dotZoness);
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
            case R.id.users:
                if(xpand_usercrud.getVisibility()==View.VISIBLE){
                    xpand_usercrud.setVisibility(View.GONE);
                }else{
                    xpand_usercrud.setVisibility(View.VISIBLE);
                }
                break;
            case  R.id.vehiculosB:
                if(xpand_vehiclescrud.getVisibility()==View.VISIBLE){
                    xpand_vehiclescrud.setVisibility(View.GONE);
                }else{
                    xpand_vehiclescrud.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.zonesButton:
                mMap.clear();
                callKml();
                zonesConfiguratuon zoneconfig = new zonesConfiguratuon();
                zoneconfig.show(getChildFragmentManager(), "zonesConfiguratuon");
                break;
            case R.id.closeCrud:

                if (dotZonenew != null) {
                    dotZonenew.remove();
                    dotZonenew=null;

                }
                mMap.clear();
                xpand_crud.setVisibility(View.GONE);


                break;
            case R.id.updateCrud:
                if(typeEditZone==1){
                    Gson gson= new Gson();
                    String json=gson.toJson(dotZones);
                    Log.e("newZone","Dots "+json);
                    if(dotZones!=null) {
                        if(!nameZoneEdtx.getText().toString().isEmpty()) {
                            if(dotZones.size()==1) {
                                if(!ratioEdtxt.getText().toString().isEmpty()) {
                                    presenter.createZone(nameZoneEdtx.getText().toString(),descZoneEdtxt.getText().toString(), ratioEdtxt.getText().toString(), dotZones);
                                }else{
                                    Toast.makeText(getContext(), "Necesitas agregar un radio a la zona", Toast.LENGTH_SHORT).show();
                                }
                            }else if(dotZones.size()==2) {
                                Toast.makeText(getContext(), "Necesitas agregar otro punto a la zona", Toast.LENGTH_SHORT).show();
                            }else{
                                presenter.createZone(nameZoneEdtx.getText().toString(),descZoneEdtxt.getText().toString(), "1", dotZones);
                            }
                        }else{
                            Toast.makeText(getContext(), "Necesitas agregar un Nombre a la zona", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getContext(), "Necesitas guardar al menos un punto antes guardar informacion", Toast.LENGTH_SHORT).show();
                    }
                }else if(typeEditZone==2){
                    //nameZoneEdtx
                    //  descZoneEdtxt.getText().toString()

                    presenter.updateZone(zoneId,descZoneEdtxt.getText().toString(),ratioEdtxt.getText().toString(),dotZones);//todo se debe de pooder actualizar el nombre
                }
                break;
            case R.id.addtextDot:
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

