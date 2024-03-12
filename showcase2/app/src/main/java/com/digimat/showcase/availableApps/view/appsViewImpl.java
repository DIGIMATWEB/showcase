package com.digimat.showcase.availableApps.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.digimat.showcase.R;
import com.digimat.showcase.availableApps.adapter.HorizontalAdapter;
import com.digimat.showcase.availableApps.model.dataAvailableApps;
import com.digimat.showcase.availableApps.presenter.presenterAppsAvailable;
import com.digimat.showcase.availableApps.presenter.presenterAppsavailableImpl;

import java.util.ArrayList;
import java.util.List;

public class appsViewImpl extends Fragment implements appsView{
    public static final String TAG = appsViewImpl.class.getSimpleName();
    private ViewPager2 viewPager;
    private HorizontalAdapter adapter;
    private List<String> dataList;
    private presenterAppsAvailable presenter;
    private int mCurrentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_available_apps, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        // Set necessary ViewPager2 configurations
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);
        viewPager.setOffscreenPageLimit(3); // You can adjust this as needed
        viewPager.setPadding(50, 0, 50, 0); // Add padding to create space between ViewPager2's edges and content

        // Set a PageTransformer to achieve the desired effect of showing multiple pages at the same time
        int pageMarginPx = getResources().getDimensionPixelOffset(R.dimen.pageMargin);
        int peekOffsetPx = getResources().getDimensionPixelOffset(R.dimen.peekOffset);
        viewPager.setPageTransformer((page, position) -> {
            float offset = position * -(2 * peekOffsetPx + pageMarginPx);
            page.setTranslationX(offset);
            //Log.e("adapterPosition",""+position+"   ");
            // Scale the center page to be larger
           // float scaleFactor = 0.8f + (1 - Math.abs(position)) * 0.4f; // Scale factor for the center page
            //page.setScaleY(scaleFactor);

            // Move the adjacent pages to the bottom
            //if (position != 0) {
            //    page.setTranslationY(Math.abs(position) * 100); // Adjust the translation value as needed
            //}
        });
        presenter= new presenterAppsavailableImpl(this,getContext());
        presenter.requestMenus();
    }

    @Override
    public void setAppsAvailable(List<dataAvailableApps> data) {
        dataList = new ArrayList<>();

        // Add data to your list
        dataList.add("Item 1");
        dataList.add("Item 2");
        dataList.add("Item 3");

        adapter = new HorizontalAdapter(this,data);
        viewPager.setAdapter(adapter);
        adapter.setCurrentPosition(viewPager.getCurrentItem());

    }

    @Override
    public void update() {
        presenter.requestMenus();
    }

    public void setAvailable(boolean available, String nameApp) {
        presenter.setAvailable(available,nameApp);
    }
}
