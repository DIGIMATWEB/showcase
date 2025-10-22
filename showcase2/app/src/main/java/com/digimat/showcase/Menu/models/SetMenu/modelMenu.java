package com.digimat.showcase.Menu.models.SetMenu;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

public class modelMenu {
    private int position;
    private String perfil;
    private String iconName; // ej. "ic_user"

    public modelMenu(int position, String perfil, String iconName) {
        this.position = position;
        this.perfil = perfil;
        this.iconName = iconName;
    }

    public int getPosition() {
        return position;
    }

    public String getPerfil() {
        return perfil;
    }

    public String getIconName() {
        return iconName;
    }

    public Drawable getIconDrawable(Context context) {
        int resId = context.getResources().getIdentifier(iconName, "drawable", context.getPackageName());
        return resId != 0 ? ContextCompat.getDrawable(context, resId) : null;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
}