package com.digimat.showcase.Tutorial.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.digimat.showcase.Mas.view.masFrament;
import com.digimat.showcase.R;
import com.digimat.showcase.Tutorial.adapter.adapterDots;

public class Tutorial extends Fragment implements View.OnClickListener {
    public static final String TAG = Tutorial.class.getSimpleName();

    private ImageView imgTutorial;
    private RecyclerView imgvStep;
    private adapterDots adapter;
    private Integer positionDot = 0;
    private TextView btnSkip, btnNext,titleDesc,descText;
    private boolean isFirstLoad = true; // 👈 Added flag

    private int[] tutorialImages = {
            R.drawable.tutorial_a,//perfil
            R.drawable.tutorial_b,//alertas
            R.drawable.tutorial_c//Comunidad
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_help, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        imgTutorial = view.findViewById(R.id.img_tutorial);
        imgvStep = view.findViewById(R.id.imgvStep);
        btnSkip = view.findViewById(R.id.txt_btn_skip);
        btnNext = view.findViewById(R.id.txt_btn_next);

        btnSkip.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        titleDesc= view.findViewById(R.id.titleDesc);
        descText= view.findViewById(R.id.descText);

        fillSizeDots();

        // First image only: set without animation
        imgTutorial.setImageResource(tutorialImages[0]);
        isFirstLoad = false; // 👈 after first load, animations are allowed
    }

    private void fillSizeDots() {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        imgvStep.setLayoutManager(layoutManager);
        adapter = new adapterDots(this,positionDot, getContext());
        imgvStep.setAdapter(adapter);
    }

    private void updateImage(boolean toRight) {
        // 👇 Only skip animation during the very first initialization
        if (isFirstLoad) {
            imgTutorial.setImageResource(tutorialImages[positionDot]);
            return;
        }

        int enterAnim = toRight ? R.anim.slide_in_right : R.anim.slide_in_left;
        int exitAnim = toRight ? R.anim.slide_out_left : R.anim.slide_out_right;

        Animation outAnim = AnimationUtils.loadAnimation(getContext(), exitAnim);
        Animation inAnim = AnimationUtils.loadAnimation(getContext(), enterAnim);

        imgTutorial.startAnimation(outAnim);

        outAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) { }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgTutorial.setImageResource(tutorialImages[positionDot]);
                imgTutorial.startAnimation(inAnim);
            }

            @Override
            public void onAnimationRepeat(Animation animation) { }
        });
    }
    public void configPosition(Integer current) {
        switch (current) {
            case 0:
                titleDesc.setText("Perfil");
                descText.setText("Configura tus datos e informacion de la comunidad a la que perteneces, verifica tu condeo de alertas registradas reportes y seguimiento de tickets");
                break;

            case 1:
                titleDesc.setText("Alertas");
                descText.setText("Revisa las alertas que tiene tu comunidad, registrospor fechas y por tipo de alertas asi como detalles de la resolucion de las mismas");
                break;

            case 2:
                titleDesc.setText("Comunidad");
                descText.setText("Observa el mapa de tu comunidad en tiempo real, asi como algunos servicios periodicos como recoleccion de descechos , tráfico etc... ");
                break;

            default:
                titleDesc.setText("");
                descText.setText("");
                break;
        }
    }
    private void goToNextFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // Aplica las animaciones personalizadas
//        transaction.setCustomAnimations(
//                R.anim.fade_in_out,   // animación de entrada si se usa "back stack"
//                R.anim.fade_out   // animación de salida si se usa "back stack"
//        );

        masFrament moreOptions = new masFrament();
        transaction.replace(R.id.conteinerMainFragments, moreOptions, masFrament.TAG);
        transaction.addToBackStack(null); // opcional si quieres volver atrás
        transaction.commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_btn_next:
                if (positionDot < adapter.getItemCount() - 1) {
                    positionDot++;
                    adapter.notifyNext(positionDot);
                    updateImage(true); // 👉 animate to the right
                    if (positionDot > 0) btnSkip.setText("Anterior");
                } else {
                    goToNextFragment();
                }
                break;

            case R.id.txt_btn_skip:
                if (positionDot > 0) {
                    positionDot--;
                    adapter.notifyNext(positionDot);
                    updateImage(false); // 👈 animate to the left
                    if (positionDot == 0) btnSkip.setText("Omitir");
                } else {
                    goToNextFragment();
                }
                break;
        }
    }



}