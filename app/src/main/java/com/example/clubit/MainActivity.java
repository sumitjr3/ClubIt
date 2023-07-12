package com.example.clubit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

        loadFragment(new HomeFragment());

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.home) {
            loadFragment(new HomeFragment());
        } else if (itemId == R.id.profile) {
            loadFragment(new profileFragment());
        } else if (itemId == R.id.club) {
            loadFragment(new ClubFragment());
        } else if (itemId == R.id.create) {
            loadFragment(new CreateFragment());
        } else if (itemId == R.id.leaderBoard) {
            loadFragment(new LeaderboardFragment());
        }
        return true;
    }
}