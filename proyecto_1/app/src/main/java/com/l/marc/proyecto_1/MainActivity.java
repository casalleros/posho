package com.l.marc.proyecto_1;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.l.marc.proyecto_1.Login.Login_Fragment;
import com.l.marc.proyecto_1.Notificaciones.MyFirebaseInstanceIdService;
import com.l.marc.proyecto_1.ViewPager.ViewPagerAdapter;
import com.l.marc.proyecto_1.ViewPager.ViewPagerFragment;


public class MainActivity extends AppCompatActivity implements NavigationHost, ViewPagerFragment.inicializarTabHost{
    String tokenRecuperado;
    MyFirebaseInstanceIdService myFirebaseInstanceIdService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFirebaseInstanceIdService = new MyFirebaseInstanceIdService();

        myFirebaseInstanceIdService.devolverElToken(tokenRecuperado);
        Log.d("token", "He recuperado: "+tokenRecuperado);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new Login_Fragment())
                    .commit();
        }
    }

    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {//Que fasil!

        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    @Override
    public void iniciliazarTab(TabLayout tl1, final ViewPager v1) {
        tl1.addTab(tl1.newTab().setText("PERFIL"));
        tl1.addTab(tl1.newTab().setText("NOTICIES"));
        tl1.setTabGravity(tl1.GRAVITY_FILL);

        final ViewPagerAdapter pageAd = new ViewPagerAdapter(getSupportFragmentManager(),tl1.getTabCount());

        v1.setAdapter(pageAd);
        v1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tl1));
        v1.setCurrentItem(1);
        
        tl1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                v1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
