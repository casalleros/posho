package com.l.marc.proyecto_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.l.marc.proyecto_1.Notificaciones.MyFirebaseInstanceIdService;


public class MainActivity extends AppCompatActivity {
    String tokenRecuperado;
    MyFirebaseInstanceIdService myFirebaseInstanceIdService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFirebaseInstanceIdService = new MyFirebaseInstanceIdService();

        myFirebaseInstanceIdService.devolverElToken(tokenRecuperado);
        Log.d("token", "He recuperado: "+tokenRecuperado);
    }


}
