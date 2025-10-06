package com.digimat.showcase.Login.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.digimat.showcase.GeneralUtils.GeneralConstantsV2;
import com.digimat.showcase.Login.presenter.presensterLoginImpl;
import com.digimat.showcase.Login.presenter.presenterLogin;
import com.digimat.showcase.Menu.view.menuViewImpl;
import com.digimat.showcase.R;

public class LoginViewImpl extends Fragment implements View.OnClickListener ,loginView{
    public static final String TAG = LoginViewImpl.class.getSimpleName();
    private CardView buttonLogin;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private presenterLogin presenter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        initLoginViewImpl(view);
        return view;
    }

    private void initLoginViewImpl(View view) {
        buttonLogin =view.findViewById(R.id.buttonLogin);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonLogin.setOnClickListener(this);
        presenter= new presensterLoginImpl(this,getContext());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonLogin:
               //presenter.requestLogin();
                if(editTextUsername.getText().toString().equals("Digimat")&&editTextPassword.getText().toString().equals("12345")) {
                    SharedPreferences prefs = getContext().getSharedPreferences(GeneralConstantsV2.CREDENTIALS_PREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString(GeneralConstantsV2.TOKEN_PREFERENCES, "1C2DS23SX322X2X32");
                    editor.commit();
                    succesLogin();
                }else{
                    Toast.makeText(getContext(), "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
                break;


        }
    }

    @Override
    public void succesLogin() {
        Intent intent = new Intent(getContext(), menuViewImpl.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_CLEAR_TOP);//
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
