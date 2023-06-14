package com.digimat.showcase.Menu.view;

import com.digimat.showcase.Menu.models.MenuData;

import java.util.List;

public interface menuView {
    void showError(String error);
    void closeAppSessionExpired();
    void listItems(List<String> items);

    //void listItems2(List<MenuData> menudata);
}
