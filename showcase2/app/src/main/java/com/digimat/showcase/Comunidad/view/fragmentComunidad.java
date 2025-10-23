package com.digimat.showcase.Comunidad.view;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.digimat.showcase.Dialogs.dialogFragmentProgress;
import com.digimat.showcase.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;

public class fragmentComunidad extends Fragment implements OnMapReadyCallback,  View.OnClickListener{
    public static final String TAG = fragmentComunidad.class.getSimpleName();
    private MapView mView;
    private GoogleMap mMap;
    private dialogFragmentProgress dialogProgres;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comunidad, container, false);
        initTrackingMapFragment(view,savedInstanceState);
        return view;
    }


    private void initTrackingMapFragment(View view, Bundle savedInstanceState) {
        bindViews(view);
        onCreateViewMap(savedInstanceState);
//        callVehicles();
//        presenter.requestUsers();
    }

    private void onCreateViewMap(Bundle savedInstanceState) {
        mView.onCreate(savedInstanceState);
        Log.e("onCreateViewMap", "OK");

        if (mView != null) {
            mView.getMapAsync(this);
        }
    }

    private void bindViews(View view) {
        mView = view.findViewById(R.id.map_view_tracking_comunidad);
        dialogProgres= new dialogFragmentProgress();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        dialogProgres.show(fragmentManager, "dialogFragmentProgress");
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setTrafficEnabled(true);
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
//        if(mvehicles!=null){
//            setVehiclesInMap();
//        }
    }

    private void uiSettingsMap(GoogleMap mMap) {
        UiSettings uiSettings = mMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setRotateGesturesEnabled(false);
        mMap.setPadding(0, 0, 0, 100);
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
}
