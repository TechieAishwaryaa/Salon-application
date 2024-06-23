package com.example.gajraj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class products extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HairFragment hair = new HairFragment();
    SkinFragment skin = new SkinFragment();
    MakeupFragment makeup = new MakeupFragment();
    CardView c1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        bottomNavigationView = findViewById(R.id.bottom);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, hair).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Hair:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, hair).commit();
                        return true;
                    case R.id.skin:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, skin).commit();
                        return true;
                    case R.id.makeup:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, makeup).commit();
                        return true;
                }
                return false;
            }
        });

    }
}




