package com.l.marc.proyecto_1.Notificaciones;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    String token;
    @Override
    public void onTokenRefresh() {
        token = FirebaseInstanceId.getInstance().getToken();

    }
    public void devolverElToken(String devolverToken)
    {
        devolverToken = token; // mala merda
    }
}
