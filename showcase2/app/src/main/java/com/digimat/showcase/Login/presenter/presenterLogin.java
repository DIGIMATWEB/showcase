package com.digimat.showcase.Login.presenter;

import com.digimat.showcase.Login.model.dataLogin;

public interface presenterLogin {
    void requestLogin(String string, String s);

    void succesLogin(dataLogin data);
}
