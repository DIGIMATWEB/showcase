package com.digimat.showcase.Tutorial.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.digimat.showcase.Mas.view.masFrament;
import com.digimat.showcase.Menu.view.layoutInteface;
import com.digimat.showcase.Profile.adapter.adapterProfile;
import com.digimat.showcase.R;
import com.digimat.showcase.Tutorial.adapter.AdapterHelpV2;
import com.digimat.showcase.Tutorial.adapter.adapterDots;

import java.util.ArrayList;
import java.util.List;

public class Tutorial extends Fragment implements View.OnClickListener {
    public static final String TAG = Tutorial.class.getSimpleName();
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private AdapterHelpV2 adapterViewPager;
    private RecyclerView imgvStep;
    private int positionCurrentItem = 0;
    private adapterDots adapter;
    private Integer postionDot=0;

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
        fillSizeDots();

    }

    private void fillSizeDots() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        imgvStep.setLayoutManager(layoutManager);
        adapter=new adapterDots(postionDot,getContext());
        imgvStep.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_btn_next:
                if (postionDot< adapter.getItemCount()-1 ) {
                    postionDot=postionDot+1;
                    adapter.notifyNext(postionDot);
                } else {
                    Toast.makeText(getContext(), "Limite superior excedido", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txt_btn_skip:
                if(postionDot!=0){
                    if(postionDot>0){
                        postionDot=postionDot-1;
                        adapter.notifyNext(postionDot);
                    }else{
                        Toast.makeText(getContext(), "Limite inferior excedido", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    FragmentManager manager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    masFrament moreOptions = new masFrament();
                    transaction.replace(R.id.conteinerMainFragments, moreOptions, masFrament.TAG).commit();
                }

                break;
        }
    }
}