package com.l.marc.proyecto_1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 5000; // el tiempo de ejecución, que fasiiiil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goMain = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(goMain);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
