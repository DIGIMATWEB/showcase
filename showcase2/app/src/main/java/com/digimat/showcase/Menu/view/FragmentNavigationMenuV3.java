package com.digimat.showcase.Menu.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.digimat.showcase.Alerts.view.alertsUser;
import com.digimat.showcase.Menu.models.MenuData;

import java.util.ArrayList;
import java.util.List;

import com.digimat.showcase.Menu.presenter.presenterMenus;
import com.digimat.showcase.Menu.presenter.presenterMenusImpl;
import com.digimat.showcase.Profile.view.profileViewImplements;
import com.digimat.showcase.R;
import com.digimat.showcase.Zonas.view.Zonas;
import com.digimat.showcase.availableApps.view.appsViewImpl;

public class FragmentNavigationMenuV3  extends Fragment implements View.OnClickListener , menuView {
    public static final String TAG = FragmentNavigationMenuV3.class.getSimpleName();

    private ImageView iconMenu1,iconMenu2,iconMenu3,iconMenu4,iconMenu5;
    private ImageView circleButtonefect1,circleButtonefect2,circleButtonefect3,circleButtonefect4,circleButtonefect5;
    private TextView menu1txt,menu2txt,menu3txt,menu4txt,menu5txt;
    private Animation zoomIcon,zoomIcon2,zoomIconCircle1,zoomIconCircle2,zoomIconCircle3,zoomIconCircle4,zoomIconCircle5;
    private List<Integer> cveobjects=new ArrayList<>();
    public static List<Integer> orderList=new ArrayList<>();
    private Guideline guideline1,guideline2,guideline3,guideline4,guideline5;
    private presenterMenus presenter;
    private List<MenuData> myemenuItems=new ArrayList<>();

    private float a,b,c,d,e;     //guidelines value from mainActivity
    private float f1, f2, f3, f4, f5;//guidelines local values from fragment
    private Boolean hasHiddenmenus=false;
    private ConstraintLayout menuConstrain;
    private layoutInteface menuActionsListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dinamic_menu_v3, container, false);
        checkShared();
        initView(view);
        presenter.requestMenus();
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof layoutInteface) {
            menuActionsListener = (layoutInteface) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        menuActionsListener = null;
    }
    private void checkShared() {
    }

    private void initView(View view) {
        //region testguidelines
        f1=.2f;
        f2=.4f;
        f3=.6f;
        f4=.8f;
        f5=1;
        //endregion
        menuConstrain =view.findViewById(R.id.menuConstrain);
        //region icons menu
        iconMenu1=view.findViewById(R.id.iconMenu1);
        menu1txt=view.findViewById(R.id.menu1txt);
        circleButtonefect1= view.findViewById(R.id.circleButtonefect1);
        iconMenu1.setOnClickListener(this);


        iconMenu2=view.findViewById(R.id.iconMenu2);
        menu2txt=view.findViewById(R.id.menu2txt);
        circleButtonefect2= view.findViewById(R.id.circleButtonefect2);
        iconMenu2.setOnClickListener(this);

        iconMenu3=view.findViewById(R.id.iconMenu3);
        menu3txt=view.findViewById(R.id.menu3txt);
        circleButtonefect3= view.findViewById(R.id.circleButtonefect3);
        iconMenu3.setOnClickListener(this);

        iconMenu4=view.findViewById(R.id.iconMenu4);
        menu4txt=view.findViewById(R.id.menu4txt);
        circleButtonefect4= view.findViewById(R.id.circleButtonefect4);
        iconMenu4.setOnClickListener(this);

        iconMenu5=view.findViewById(R.id.iconMenu5);
        menu5txt=view.findViewById(R.id.menu5txt);
        circleButtonefect5= view.findViewById(R.id.circleButtonefect5);
        iconMenu5.setOnClickListener(this);
        //endregion
        //region guidelines
        guideline1 = view.findViewById(R.id.guidelinemenu1);
        guideline2 = view.findViewById(R.id.guidelinemenu2);
        guideline3 = view.findViewById(R.id.guidelinemenu3);
        guideline4 = view.findViewById(R.id.guidelinemenu4);
        guideline5 = view.findViewById(R.id.guidelinemenu5);

        constrainGuidelideParamsInit();
        //endregion

        // region animaciones
        zoomIcon= AnimationUtils.loadAnimation(getContext(),
                R.anim.zoom_in);
        zoomIcon2= AnimationUtils.loadAnimation(getContext(),
                R.anim.zoom_out);

        zoomIconCircle1= AnimationUtils.loadAnimation(getContext(),
                R.anim.fade_in_out);
        zoomIconCircle2= AnimationUtils.loadAnimation(getContext(),
                R.anim.fade_in_out);
        zoomIconCircle3= AnimationUtils.loadAnimation(getContext(),
                R.anim.fade_in_out);
        zoomIconCircle4= AnimationUtils.loadAnimation(getContext(),
                R.anim.fade_in_out);
        zoomIconCircle5= AnimationUtils.loadAnimation(getContext(),
                R.anim.fade_in_out);
        //endregion
        menuconfig();
       presenter= new presenterMenusImpl(this,getContext());
    }

    private void constrainGuidelideParamsInit() {

        ConstraintLayout.LayoutParams params1 = (ConstraintLayout.LayoutParams) guideline1.getLayoutParams();
        ConstraintLayout.LayoutParams params2 = (ConstraintLayout.LayoutParams) guideline2.getLayoutParams();
        ConstraintLayout.LayoutParams params3 = (ConstraintLayout.LayoutParams) guideline3.getLayoutParams();
        ConstraintLayout.LayoutParams params4 = (ConstraintLayout.LayoutParams) guideline4.getLayoutParams();
        ConstraintLayout.LayoutParams params5 = (ConstraintLayout.LayoutParams) guideline5.getLayoutParams();

        params1.guidePercent =f1;
        params2.guidePercent =f2;
        params3.guidePercent =f3;
        params4.guidePercent =f4;
        params5.guidePercent =f5;
        guideline1.setLayoutParams(params1);
        guideline2.setLayoutParams(params2);
        guideline3.setLayoutParams(params3);
        guideline4.setLayoutParams(params4);
        guideline5.setLayoutParams(params5);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iconMenu1:/** aqui solo van las animaiones*/
            Log.e("menuClicked","menu clicked "+1);
                showProfile();
                if(menu1txt.getVisibility()==View.VISIBLE){
                   // menu1txt.setVisibility(View.GONE);
                    iconMenu1.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect1.setVisibility(View.VISIBLE);
                    circleButtonefect1.startAnimation(zoomIconCircle1);
                    menu1txt.setVisibility(View.VISIBLE);
                    iconMenu1.startAnimation(zoomIcon);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu1txt.getText().toString());//todo cambiar esto por claves

                }
                Log.e("menu",""+menu1txt.getText());
                if (menuActionsListener != null) {
                    menuActionsListener.onHideMainMenu();
                }
                break;
            case R.id.iconMenu2:
                Log.e("menuClicked","menu clicked "+2);
                fragmentZones();
                if(menu2txt.getVisibility()==View.VISIBLE){
                   // menu2txt.setVisibility(View.GONE);
                    iconMenu2.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect2.setVisibility(View.VISIBLE);
                    circleButtonefect2.startAnimation(zoomIconCircle2);
                    menu2txt.setVisibility(View.VISIBLE);
                    iconMenu2.startAnimation(zoomIcon);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu2txt.getText().toString());
                }
                Log.e("menu",""+menu2txt.getText());
                if (menuActionsListener != null) {
                    menuActionsListener.onHideMainMenu();
                }
                break;
            case R.id.iconMenu3:
                Log.e("menuClicked","menu clicked "+3);
                if (menu3txt.getVisibility() == View.VISIBLE) {
                    iconMenu3.startAnimation(zoomIcon2);
                } else {
                    circleButtonefect3.setVisibility(View.VISIBLE);
                    circleButtonefect3.startAnimation(zoomIconCircle3);
                    menu3txt.setVisibility(View.VISIBLE);
                    iconMenu3.startAnimation(zoomIcon);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);


                }
                if (menuActionsListener != null) {
                    menuActionsListener.onShowMainMenu();
                }
                if (menu3txt.getText().toString().equals("Alertas")) {
                    fragmentALerts();
                }
                break;
            case R.id.iconMenu4:
                Log.e("menuClicked","menu clicked "+4);
                if(menu4txt.getVisibility()==View.VISIBLE){
                   // menu4txt.setVisibility(View.GONE);
                    iconMenu4.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect4.setVisibility(View.VISIBLE);
                    circleButtonefect4.startAnimation(zoomIconCircle4);
                    menu4txt.setVisibility(View.VISIBLE);
                    iconMenu4.startAnimation(zoomIcon);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu4txt.getText().toString());

                }
                Log.e("menu",""+menu4txt.getText());
                break;
            case R.id.iconMenu5:
                Log.e("menuClicked","menu clicked "+5);
                if(menu5txt.getVisibility()==View.VISIBLE){
                  //  menu5txt.setVisibility(View.GONE);
                    iconMenu5.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect5.setVisibility(View.VISIBLE);
                    circleButtonefect5.startAnimation(zoomIconCircle5);
                    menu5txt.setVisibility(View.VISIBLE);
                    iconMenu5.startAnimation(zoomIcon);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    checkItem(menu5txt.getText().toString());
                }
                Log.e("menu",""+menu5txt.getText());
                break;
        }
    }

    private void checkItem(String menu) {
        switch (menu) {
            case "Alertas":
            break;
            case "Unidades":
                break;
            case "Rastreo":
                break;
            case "Notificaciones":
               // NotificationsFragment();
                break;
            case "Geozonas":
               // ZonesFragment();
                break;
            case "Checklist":
                //Toast.makeText(getContext(), "Modulo aun no implementado", Toast.LENGTH_SHORT).show();
                break;
            case "Perfil":
              //  profileFragment();
                break;
            case "Contacto":
             //   MessageFragment();
                break;
            case "topDriver":
                Toast.makeText(getContext(), "Modulo  topDriver aun no implementado", Toast.LENGTH_SHORT).show();
                break;
            case "enProgreso":
                Toast.makeText(getContext(), "Modulo onefleet en progreso  aun no implementado", Toast.LENGTH_SHORT).show();
                break;
            case "completado O":
                Toast.makeText(getContext(), "Modulo onefleet completado aun no implementado", Toast.LENGTH_SHORT).show();
                break;

            case "Scanner":
                Toast.makeText(getContext(), "Modulo onefleet scanner aun no implementado", Toast.LENGTH_SHORT).show();
                break;
            case "Más":
              //  moreOptionsFragment();
                break;

        }
    }
    public void menuconfig()
    {
    }
    @Override
    public void showError(String error) {
    }
    @Override
    public void closeAppSessionExpired() {
    }
    @Override
    public void listItems(List<Integer> items) {
        distributionConstrain( items);
        for(int menu:items){
            setIconandName(menu);
        }
    }
    public void setIconandName(int clave)//, int position, List<MenuData> myemenuItemsf)
    {
        switch (clave){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
//                Log.e("casemenuoption","case 10."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( clave,String.valueOf( clave),getResources().getDrawable(R.drawable.ic_backgroundrocket));
                break;
            default: {
                Log.e("itemsMenu","Opcion incorrecta");
            }
        }
    }
    public void setViewIcons(int menuValue, String obj_name, Drawable icono) {
        switch (menuValue) {
            case 0:/** aqui solo van las animaiones*/
                iconMenu1.setImageDrawable(getResources().getDrawable(R.drawable.profile_map));
                menu1txt.setText("perfil");
                break;
            case 1:
                iconMenu2.setImageDrawable(getResources().getDrawable(R.drawable.admin_account));
                menu2txt.setText("Administracion");
                break;
            case 2:
                iconMenu3.setImageDrawable(getResources().getDrawable(R.drawable.alerts_ico));
                menu3txt.setText("Alertas");
                break;
            case 3:
                iconMenu4.setImageDrawable(icono);
                menu4txt.setText(obj_name);
                break;
            case 4:
                iconMenu5.setImageDrawable(icono);
                menu5txt.setText(obj_name);
                break;
        }
    }

    public void distributionConstrain(List<Integer> myemenuItems)
    {
        boolean hasprofile=true;
        if(myemenuItems.size()==0)//objectsize//llevaperfil
        {
            f1=0;
            f2=0;
            f3=0;
            f4=0;
            f5=1;
            constrainGuidelideParamsInit();
            setPerfil();

            //profileFragment();
        }else  if(myemenuItems.size()==1)//objectsize//llevaperfil
        {
            for(int i=0;i<myemenuItems.size();i++)
            {
            }
            if(hasprofile==false)
            {
                f1=.5f;
                f2=.5f;
                f3=.5f;
                f4=.5f;
                f5=1;
            }else {
                f1=0;
                f2=1;
                f3=1;
                f4=1;
                f5=1;

            }

            constrainGuidelideParamsInit();
            if(hasHiddenmenus)
            {
                setHamburger();
                hasHiddenmenus=false;
            }else
            {
                setPerfil();
                menuConstrain.setVisibility(View.GONE);
            }
        }
        else  if(myemenuItems.size()==2)//objectsize//llevaperfil
        {
            for(int i=0;i<myemenuItems.size();i++)
            {
            }
            if(hasprofile==false)
            {
                f1=.333f;
                f2=.666f;
                f3=.666f;
                f4=.666f;
                f5=1;
            }else
            {
                f1=.5f;
                f2=1;
                f3=1;
                f4=1;
                f5=1;
            }
            constrainGuidelideParamsInit();
            if(hasHiddenmenus)
            {
                fragmentALerts();
                hasHiddenmenus=false;
            }else
            {
                setPerfil();
            }
        }
        else  if(myemenuItems.size()==3)//objectsize//llevaperfil
        {
            int position=0;
            for(int i=0;i<myemenuItems.size();i++)
            {
            }
            if(hasprofile==false)
            {
                f1=0.25f;
                f2=0.5f;
                f3=0.75f;
                f4=.1f;
                f5=1f;
                if(hasHiddenmenus)
                {
                    setHamburger();
                    hasHiddenmenus=false;
                }else
                {
                    setPerfil();
                }

            }else
            {
                f1=.333f;
                f2=.666f;
                f3=1;
                f4=1;
                f5=1;

            }
            constrainGuidelideParamsInit();
        }
        else  if(myemenuItems.size()==4)//objectsize// hamburguesa
        {
            if(hasprofile==false)
            {
                f1=0.25f;
                f2=0.5f;
                f3=0.75f;
                f4=1f;
                f5=1f;
            }else {
                f1 = 0.2f;
                f2 = 0.4f;
                f3 = 0.6f;
                f4 = 0.8f;
                f5 = 1;
            }
            constrainGuidelideParamsInit();
          //  setHamburger();
        }
        else  if(myemenuItems.size()>4)//objectsize
        {

            f1=0.2f;
            f2=0.4f;
            f3=0.6f;
            f4=0.8f;
            f5=1;
            constrainGuidelideParamsInit();
            setHamburger();
        }else  if(myemenuItems==null)//objectsize
        {
            f1=0;
            f2=0;
            f3=0;
            f4=0;
            f5=1;
            constrainGuidelideParamsInit();
            setPerfil();
           // profileFragment();
        }
    }
    public void setHamburger()
    {
    }
    public void setPerfil()
    {
    }
    private void showProfile() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        profileViewImplements profile = new profileViewImplements();
        transaction.replace(R.id.conteinerMainFragments, profile, profileViewImplements.TAG).commit();
    }
    private void fragmentZones() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Zonas zonesFragment = new Zonas();
        transaction.replace(R.id.conteinerMainFragments, zonesFragment, Zonas.TAG).commit();
    }
    private void fragmentALerts() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // 🔹 Limpieza si ya existe
        Fragment prev = manager.findFragmentByTag(alertsUser.TAG);
        if (prev != null) {
            transaction.remove(prev);
        }

        // 🔹 Agregar uno nuevo siempre
        alertsUser apps = new alertsUser();
        transaction.replace(R.id.conteinerMainFragments, apps, alertsUser.TAG);
        transaction.commitAllowingStateLoss(); // 👈 asegura que se ejecute
    }
}
