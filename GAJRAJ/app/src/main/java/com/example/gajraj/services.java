package com.example.gajraj;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class services extends AppCompatActivity {
    TabLayout tab;
    ViewPager viewPager;
    LadiesFragment lf;
    OnBackPressedCallback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
        setupTabIcons();

        callback=new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent i=new Intent(getApplicationContext(),mainpage.class);
                startActivity(i);
            }
        };

        getOnBackPressedDispatcher().addCallback(this,callback);



    }

    private void setupTabIcons() {
        tab.getTabAt(0).setIcon(R.drawable.gentslogo);
        tab.getTabAt(1).setIcon(R.drawable.ladieslogo);
    }
    public void showghair(View view)
    {
        GhairFragment gh=new GhairFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,gh).commit();
    }
    public void showgbeard(View view)
    {
        GBeardFragment gb=new GBeardFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,gb).commit();
    }
    public void showgfacial(View view)
    {
        GfacialFragment gf=new GfacialFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,gf).commit();
    }
    public void showgmassage(View view)
    {
        GmassageFragment gm=new GmassageFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,gm).commit();
    }

  public void showhair(View view)
    {

                LhairFragment llf=new LhairFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,llf).commit();

    }
    public void showmakeup(View view)
    {
        LmakeupFragment lmf=new LmakeupFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,lmf).commit();
    }
    public void showfacial(View view)
    {
        LfacialFragment lff=new LfacialFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,lff).commit();
    }
    public void showmanicure(View view)
    {
        LmanicureFragment lmf=new LmanicureFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,lmf).commit();
    }
    public void showpedicure(View view)
    {
        LpedicureFragment lpf=new LpedicureFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,lpf).commit();
    }
    public void showwaxing(View view)
    {
        LwaxingFragment lwf=new LwaxingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,lwf).commit();
    }
}