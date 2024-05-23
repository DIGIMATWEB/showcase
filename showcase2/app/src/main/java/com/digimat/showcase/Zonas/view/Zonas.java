package com.digimat.showcase.Zonas.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.digimat.showcase.R;
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
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

public class Zonas extends Fragment implements OnMapReadyCallback ,zonasView{
    public static final String TAG = Zonas.class.getSimpleName();
    private MapView mView;
    private GoogleMap mMap;
    private List<dataFullVehicles> vehicles;
    private presenterVehicles presenter;
    private Marker vehicle;
    private KmlLayer mKmlLayer;

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
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(18.9567483, -98.9836352), 15.64f));
            }
        }, 4000);
    }

//
    private void uiSettingsMap(GoogleMap googleMap) {
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setRotateGesturesEnabled(false);
        mMap.setPadding(0, 0, 0, 200);
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
}
