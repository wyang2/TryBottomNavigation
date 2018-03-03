package com.example.yangwenhan.bottomnavigation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private SearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout)findViewById(R.id.main_frame);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.main_nav);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        searchFragment = new SearchFragment();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_home:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_profile:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(profileFragment);
                        return true;

                    case R.id.nav_search:
                        bottomNavigationView.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(searchFragment);
                        return true;

                        default:
                            return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }
}
