package com.DIGIMAT.Showcase.Menu.view;

import com.DIGIMAT.Showcase.Menu.models.MenuData;

import java.util.List;

public interface menuView {
    void showError(String error);
    void closeAppSessionExpired();
    void listItems(List<String> items);

    //void listItems2(List<MenuData> menudata);
}
