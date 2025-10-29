package com.digimat.showcase.Tutorial.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.digimat.showcase.Menu.view.layoutInteface;
import com.digimat.showcase.R;
import com.digimat.showcase.Tutorial.adapter.AdapterHelpV2;

import java.util.ArrayList;
import java.util.List;

public class Tutorial extends Fragment implements View.OnClickListener {
    public static final String TAG = Tutorial.class.getSimpleName();
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private AdapterHelpV2 adapterViewPager;
    private RecyclerView imgvStep;
    private int positionCurrentItem = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_help, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        viewPager = view.findViewById(R.id.view_pager_loginhelp);
        imgvStep = view.findViewById(R.id.imgvStep);
        TextView btnSkip = view.findViewById(R.id.txt_btn_skip);
        TextView btnNext = view.findViewById(R.id.txt_btn_next);

        btnSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        fragmentList = new ArrayList<>();

        adapterViewPager = new AdapterHelpV2(getChildFragmentManager(), fragmentList);
        viewPager.setAdapter(adapterViewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                positionCurrentItem = position;
                if (position == 0) {
                  //  imgvStep.setImageResource(R.drawable.dots_step_1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_btn_next:
                if (positionCurrentItem == 8) {
                    getActivity().onBackPressed();
                } else {
                    viewPager.setCurrentItem(positionCurrentItem + 1, true);
                }
                break;
            case R.id.txt_btn_skip:
                getActivity().onBackPressed();
                break;
        }
    }
}