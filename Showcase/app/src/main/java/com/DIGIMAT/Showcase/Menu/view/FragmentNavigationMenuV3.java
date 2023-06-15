package com.DIGIMAT.Showcase.Menu.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.DIGIMAT.Showcase.GeneralUtils.GeneralConstantsV2;
import com.DIGIMAT.Showcase.Menu.models.MenuData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.DIGIMAT.Showcase.R;

public class FragmentNavigationMenuV3  extends Fragment implements View.OnClickListener , menuView {
    public static final String TAG = FragmentNavigationMenuV3.class.getSimpleName();

    private ImageView iconMenu1,iconMenu2,iconMenu3,iconMenu4,iconMenu5;
    private ImageView circleButtonefect1,circleButtonefect2,circleButtonefect3,circleButtonefect4,circleButtonefect5;
    private TextView menu1txt,menu2txt,menu3txt,menu4txt,menu5txt;
    private Animation zoomIcon,zoomIcon2,zoomIconCircle1,zoomIconCircle2,zoomIconCircle3,zoomIconCircle4,zoomIconCircle5;
    private List<Integer> cveobjects=new ArrayList<>();
    public static List<Integer> orderList=new ArrayList<>();
    private Guideline guideline1,guideline2,guideline3,guideline4,guideline5;
   // private menuPresenter presenter;
    private List<MenuData> myemenuItems=new ArrayList<>();

    private float a,b,c,d,e;     //guidelines value from mainActivity
    private float f1, f2, f3, f4, f5;//guidelines local values from fragment
    private Boolean hasHiddenmenus=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dinamic_menu_v3, container, false);
        checkShared();
        initView(view);
      //  presenter.itemsMenu();
        return view;
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
      //  presenter= new menuPresenterImpl(this,getContext());
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
//      params1.guidePercent =menuViewImpl.a; // 45% // range: 0 <-> 1
//      params2.guidePercent =menuViewImpl.b; // 45% // range: 0 <-> 1
//      params3.guidePercent =menuViewImpl.c; // 45% // range: 0 <-> 1
//      params4.guidePercent =menuViewImpl.d; // 45% // range: 0 <-> 1
//            params5.guidePercent =menuViewImpl.e;
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

                if(menu1txt.getVisibility()==View.VISIBLE){
                    menu1txt.setVisibility(View.GONE);
                    iconMenu1.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect1.setVisibility(View.VISIBLE);
                    circleButtonefect1.startAnimation(zoomIconCircle1);
                    menu1txt.setVisibility(View.VISIBLE);
                    iconMenu1.startAnimation(zoomIcon);

                    menu2txt.setVisibility(View.GONE);
                    menu3txt.setVisibility(View.GONE);
                    menu4txt.setVisibility(View.GONE);
                    menu5txt.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu1txt.getText().toString());//todo cambiar esto por claves

                }
                break;
            case R.id.iconMenu2:
                if(menu2txt.getVisibility()==View.VISIBLE){
                    menu2txt.setVisibility(View.GONE);
                    iconMenu2.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect2.setVisibility(View.VISIBLE);
                    circleButtonefect2.startAnimation(zoomIconCircle2);
                    menu2txt.setVisibility(View.VISIBLE);
                    iconMenu2.startAnimation(zoomIcon);

                    menu1txt.setVisibility(View.GONE);
                    menu3txt.setVisibility(View.GONE);
                    menu4txt.setVisibility(View.GONE);
                    menu5txt.setVisibility(View.GONE);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu2txt.getText().toString());
                }
                break;
            case R.id.iconMenu3:
                if(menu3txt.getVisibility()==View.VISIBLE){
                    menu3txt.setVisibility(View.GONE);
                    iconMenu3.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect3.setVisibility(View.VISIBLE);
                    circleButtonefect3.startAnimation(zoomIconCircle3);
                    menu3txt.setVisibility(View.VISIBLE);
                    iconMenu3.startAnimation(zoomIcon);
                    menu1txt.setVisibility(View.GONE);
                    menu2txt.setVisibility(View.GONE);
                    menu4txt.setVisibility(View.GONE);
                    menu5txt.setVisibility(View.GONE);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu3txt.getText().toString());
                }
                break;
            case R.id.iconMenu4:
                if(menu4txt.getVisibility()==View.VISIBLE){
                    menu4txt.setVisibility(View.GONE);
                    iconMenu4.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect4.setVisibility(View.VISIBLE);
                    circleButtonefect4.startAnimation(zoomIconCircle4);
                    menu4txt.setVisibility(View.VISIBLE);
                    iconMenu4.startAnimation(zoomIcon);
                    menu1txt.setVisibility(View.GONE);
                    menu2txt.setVisibility(View.GONE);
                    menu3txt.setVisibility(View.GONE);
                    menu5txt.setVisibility(View.GONE);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect5.setVisibility(View.GONE);
                    checkItem(menu4txt.getText().toString());

                }
                break;
            case R.id.iconMenu5:
                if(menu5txt.getVisibility()==View.VISIBLE){
                    menu5txt.setVisibility(View.GONE);
                    iconMenu5.startAnimation(zoomIcon2);

                }else
                {
                    circleButtonefect5.setVisibility(View.VISIBLE);
                    circleButtonefect5.startAnimation(zoomIconCircle5);
                    menu5txt.setVisibility(View.VISIBLE);
                    iconMenu5.startAnimation(zoomIcon);
                    menu1txt.setVisibility(View.GONE);
                    menu2txt.setVisibility(View.GONE);
                    menu3txt.setVisibility(View.GONE);
                    menu4txt.setVisibility(View.GONE);
                    circleButtonefect1.setVisibility(View.GONE);
                    circleButtonefect2.setVisibility(View.GONE);
                    circleButtonefect3.setVisibility(View.GONE);
                    circleButtonefect4.setVisibility(View.GONE);
                    checkItem(menu5txt.getText().toString());
                }
                Log.e("myemenuItemssize",""+menu5txt.getText());
                break;
        }
    }

    private void checkItem(String menu) {
        switch (menu) {
            case "Unidades":
                //UnitsFragment();
                break;
            case "Rastreo":
               // TrackingFragment();
                break;
            case "Notificaciones":
               // NotificationsFragment();
                break;
            case "Geozonas":
               // ZonesFragment();
                break;
            case "Checklist":
                Toast.makeText(getContext(), "Modulo aun no implementado", Toast.LENGTH_SHORT).show();
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
    public void listItems(List<String> items) {

    }
/*
    @Override
    public void listItems2(List<MenuData> menudata) {
        //   this.myemenuItems=menudata;
        myemenuItems.clear();
        for (int i = 0; i <menudata.size();i++)
        {
            if(menudata.get(i).isAccess_flag()==true)
            {
                myemenuItems.add(menudata.get(i));
            }
        }
        Log.e("myemenuItemssize","Guardado list "+myemenuItems.size());
        distributionConstrain(myemenuItems);
        SharedPreferences preferences = getContext().getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
        String menu=preferences.getString(GeneralConstantsV2.MENU_DATA_SAVED, null);
        String R1=preferences.getString(GeneralConstantsV2.MENU_DATA_SAVEDR1, null);
        String R2=preferences.getString(GeneralConstantsV2.MENU_DATA_SAVEDR2, null);
        //String Rf=
        //recoge la variable menu de shared preferences
        if(menu!=null) {
            for (int i = 0; i < myemenuItems.size(); i++) {
             //   Log.e("menuv3", "" + myemenuItems.get(i).getObj_name() + " " + myemenuItems.get(i).isAccess_flag() + "   " + myemenuItems.get(i).getCve_object());
            }
            //  Log.e("jsonMenu","Guardado "+menu);
            List<MenuData> newmanuData = Arrays.asList(new GsonBuilder().create().fromJson(menu, MenuData[].class));//todo igual cuando no hay clase List<Object> newmanuData = Arrays.asList(new GsonBuilder().create().fromJson(menu, Object[].class));

            Log.e("jsonMenu","Guardado list "+newmanuData);
            //si el menu de shared es igual a la lista del endpoint
            if(myemenuItems==newmanuData)
            {
                checkSizeAf(newmanuData);// haz la distriubucio de acuerdo a lo de shared
            }else   // si no es igual haz la distribuvion respecto al endpoint y guarda ese valor en shared
            {
                if(myemenuItems.size()==newmanuData.size())//si el tamaño de ambos arrays es el mismo escribe el que se modifico R1 R2 esn shared
                {
                    if(R1!=null)
                    {
                        List<MenuData> menuR1 = Arrays.asList(new GsonBuilder().create().fromJson(R1, MenuData[].class));
                        Log.e("jsonMenu","Guardado list "+menuR1);
                        if(menuR1!=null)//si es diferente si r1 es diferente de null
                        {
                            if(R2!=null)
                            {
                                hasHiddenmenus=true;
                            }
                            distributionConstrain(menuR1);
                            checkSizeAf(menuR1);


                        }else {  //si viene en null la prioridad es lo que quedo en shared
                            checkSizeAf(newmanuData);
                        }
                    }else
                    {
                        checkSizeAf(newmanuData);
                    }
                }else
                {
                    if(R1!=null) {
                        List<MenuData> menuR1 = Arrays.asList(new GsonBuilder().create().fromJson(R1, MenuData[].class));
                        Log.e("jsonMenu", "Guardado list " + menuR1);
                        if(menuR1!=null)//si es diferente si r1 es diferente de null
                        {
                            checkSizeAf(menuR1);
                        }else {//so viene en null ponde lo del endpoint
                            SharedPreferences.Editor editor = preferences.edit();
                            Gson gson = new Gson();
                            String json = gson.toJson(myemenuItems);
                            editor.putString(GeneralConstantsV2.MENU_DATA_SAVED, json);
                            editor.commit();
                            checkSizeAf(myemenuItems);
                        }
                    }else
                    {
                        SharedPreferences.Editor editor = preferences.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(myemenuItems);
                        editor.putString(GeneralConstantsV2.MENU_DATA_SAVED, json);
                        editor.commit();
                        checkSizeAf(myemenuItems);
                    }

                }

            }

        }else
        {///si el menu de shared preferences viene en null se guardan los itemes en shared
            SharedPreferences.Editor editor=preferences.edit();
            Gson gson = new Gson();
            String json = gson.toJson(myemenuItems);
            editor.putString(GeneralConstantsV2.MENU_DATA_SAVED, json);
            editor.commit();
            Log.e("jsonMenu","Nuevo    "+json);
            checkSizeAf(myemenuItems);
        }
    }*/

    private void checkSizeAf(List<MenuData> newmanuData) {

        Log.e("jsonMenu","Guardado list "+newmanuData.size());
        if(newmanuData.size()!=myemenuItems.size())
        {
            for (int i = 0; i < newmanuData.size(); i++) {
                if (i < 4) {
//                    Log.e("jsonMenu", "Guardado list " + newmanuData.get(i).getObj_name() + "    clave " + newmanuData.get(i).getCve_object());
//                    setIconandName(newmanuData.get(i).getCve_object(), i,newmanuData);
                }
            }
        }else {
            for (int i = 0; i < myemenuItems.size(); i++) {
                if (i < 4) {
//                    Log.e("jsonMenu", "Guardado list " + newmanuData.get(i).getObj_name() + "    clave " + newmanuData.get(i).getCve_object());
//                    setIconandName(newmanuData.get(i).getCve_object(), i,myemenuItems);
                }
            }
        }
    }

    public void distributionConstrain(List<MenuData> myemenuItems)
    {
        boolean hasprofile=false;
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
            /*    if(myemenuItems.get(i).getCve_object()==1145)
                {
                    hasprofile=true;
                }*/
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
            }
        }
        else  if(myemenuItems.size()==2)//objectsize//llevaperfil
        {
            for(int i=0;i<myemenuItems.size();i++)
            {
            /*    if(myemenuItems.get(i).getCve_object()==1145)
                {
                    hasprofile=true;
                }*/
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
                setHamburger();
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
            /*    if(myemenuItems.get(i).getCve_object()==1145)
                {
                    hasprofile=true;
                    if(i!=myemenuItems.size()-1)
                    {
                        position=i;
                    }
                }*/
            }
            if(hasprofile==false)
            {
                f1=0.25f;
                f2=0.5f;
                f3=0.75f;
                f4=.75f;
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
            f1=0.2f;
            f2=0.4f;
            f3=0.6f;
            f4=0.8f;
            f5=1;
            constrainGuidelideParamsInit();
            setHamburger();
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
    public void setViewIcons(int position, String obj_name, Drawable icono) {
        switch (position) {
            case 0:/** aqui solo van las animaiones*/
                iconMenu1.setImageDrawable(icono);
                menu1txt.setText(obj_name);
                break;
            case 1:
                iconMenu2.setImageDrawable(icono);
                menu2txt.setText(obj_name);
                break;
            case 2:
                iconMenu3.setImageDrawable(icono);
                menu3txt.setText(obj_name);
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

    public void setHamburger()
    {
    //    setViewIcons( 4,"Más",getResources().getDrawable(R.drawable.ic_mas));
    }
    public void setPerfil()
    {
     //   setViewIcons( 4,"Perfil",getResources().getDrawable(R.drawable.profile_selector));
    }

   /* public void setIconandName(int clave, int position, List<MenuData> myemenuItemsf)
    {
        switch (clave){
            case 1147:{//Unidades clave 1147
            //    Log.e("casemenuoption","case 0."+ myemenuItemsf.get(position).getObj_name());
            //    setViewIcons( position,myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_units_off));
                break;
            }
            case 1146:{//Rastreo clave 1146
               // Log.e("casemenuoption","case 1."+ myemenuItemsf.get(position).getObj_name());
              //  setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.tracking_selector));
                break;
            }

            case 1148:{//Notificaciones clave 1148
              //  Log.e("casemenuoption","case 2."+ myemenuItemsf.get(position).getObj_name());
              //  setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.notifications_selector));
                break;

            }
            case 1149:{//Geozonas clave 1149
                Log.e("casemenuoption","case 3."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_icono_zonas__1_));
                break;
            }
            case 2107:{//Checklist clave 2107
             //   Log.e("casemenuoption","case 4."+ myemenuItemsf.get(position).getObj_name());
              //  setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_checklist_off2));
                break;
            }

            case 1145:{//Perfil clave 1145
           //     Log.e("casemenuoption","case 5."+ myemenuItemsf.get(position).getObj_name());
             //   setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.profile_selector));
                break;

            }
            case 1150:{//Contacto clave 1150
                Log.e("casemenuoption","case 6."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_contact_off));
                break;
            }
            case 2123:{//topDriver clave 2123
                Log.e("casemenuoption","case 7."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_units_off));
                break;
            }
            case 2124:{//Scanner clave 2124
                Log.e("casemenuoption","case 8."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_units_off));
                break;
            }
            case 2125:{//enProgreso clave 2125
                Log.e("casemenuoption","case 9."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_units_off));
                break;
            }
            case 2126:{//completado O clave 2126
                Log.e("casemenuoption","case 10."+ myemenuItemsf.get(position).getObj_name());
                setViewIcons( position, myemenuItemsf.get(position).getObj_name(),getResources().getDrawable(R.drawable.ic_units_off));
                break;
            }

            default: {
                Log.e("casemenuoption","Opcion incorrecta");
            }
        }
    }*/
  /*  private void UnitsFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        UnitsViewImpl unidades = new UnitsViewImpl();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, unidades, UnitsViewImpl.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();
   // }*/
   /* private void TrackingFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        TrackingMapFragment rastreo = new TrackingMapFragment();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, rastreo, TrackingMapFragment.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);*/
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();

  //  }//
    /*private void NotificationsFragment() {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        NotificationsViewImpl notificaciones = new NotificationsViewImpl();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, notificaciones, NotificationsViewImpl.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();
  //  }
   /* private void ZonesFragment() {
        // Toast.makeText(getContext(), "aqui va el fragment de zonas", Toast.LENGTH_SHORT).show();
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        zonesFragment zones = new zonesFragment();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, zones, zonesFragment.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();

    //}



  /*  private void MessageFragment() {

        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ContactViewImpl contacto = new ContactViewImpl();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, contacto, FragmentContactV2.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();

  //  }


  /*  private void profileFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        ProfileViewImpl profile = new ProfileViewImpl();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, profile, ProfileViewImpl.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();
        /**iLLuiminateProfile();
         }*/
    //}


   /* private void moreOptionsFragment() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        MoreOptionsRvViewImpl moreOptions = new MoreOptionsRvViewImpl();//transaction.addToBackStack(UnitsViewImpl.TAG);
        transaction.replace(R.id.conteinerMainFragments, moreOptions, MoreOptionsRvViewImpl.TAG).commit();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        /**aqui se deben iluminar y desabilitar los botones para los menus para que puedan ser oprimidos solo en una ocacion*///iluminate3();

   // }
}
//Unidades          true   1147
//Rastreo           true   1146
//Notificaciones    true   1148
//Geozonas          true   1149
//Checklist         true   2107
//Perfil            true   1145
//Contacto          true   1150
//topDriver         true   2123
//Scanner           true   2124
//enProgreso        true   2125
//completado O      true   2126