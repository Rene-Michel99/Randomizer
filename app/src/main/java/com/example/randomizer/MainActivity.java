package com.example.randomizer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tab_layout = findViewById(R.id.tab_layout);
        TabItem rand_num = findViewById(R.id.rand_num);
        TabItem rand_list = findViewById(R.id.rand_lista);
        TabItem rand_dice = findViewById(R.id.rand_dice);
        final ViewPager view_pager =findViewById(R.id.view_pager);

        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(),tab_layout.getTabCount());

        view_pager.setAdapter(adapter);

        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
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