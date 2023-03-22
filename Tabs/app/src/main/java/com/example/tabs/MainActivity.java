package com.example.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;



import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    Toolbar my_apb;
    ViewPager2 my_viewPager;
    TabLayout my_tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_apb = findViewById(R.id.my_toolbar);
        setSupportActionBar(my_apb);

        my_tabLayout = (TabLayout) findViewById(R.id.my_tabs);
        my_viewPager = (ViewPager2) findViewById(R.id.my_viewpager);

        MiAdaptador adapter = new MiAdaptador( this);
        my_viewPager.setAdapter(adapter);
        new TabLayoutMediator( my_tabLayout, my_viewPager, (tab, position) -> tab.setText(adapter.getTabTitle(position))).attach();
    }
}