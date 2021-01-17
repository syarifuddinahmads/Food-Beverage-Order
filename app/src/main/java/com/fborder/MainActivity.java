package com.fborder;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        openFragment(HomeFragment.newInstance("", ""));
    }

    // klik menu bottom
    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    openFragment(HomeFragment.newInstance("",""));
                    return true;
                case R.id.navigation_transaction:
                    openFragment(TransactionFragment.newInstance("",""));
                    return true;
                case R.id.navigation_account:
                    openFragment(AccountFragment.newInstance("",""));
                    return true;
            }
            return false;
        }
    };

    private void openFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
