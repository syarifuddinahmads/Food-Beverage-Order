package com.fborder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private long pressBack;
    private static final int TIME_INTERVAL = 2000;
    private SharedPreferences preferences;
    public static final String is_login = "is_login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // init fragment set
        openFragment(HomeFragment.newInstance("", ""));

        // hide action bar
        getSupportActionBar().hide();

        //init bottom menu
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

    }

    // klik menu bottom
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    openFragment(HomeFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_transaction:
                    openFragment(TransactionFragment.newInstance("", ""));
                    return true;
                case R.id.navigation_account:
                    openFragment(AccountFragment.newInstance("", ""));
                    return true;
            }
            return false;
        }
    };

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (pressBack + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(getBaseContext(), "Klik 2 kali untuk keluar...",    Toast.LENGTH_SHORT).show();
        }
        pressBack = System.currentTimeMillis();
    }
}
