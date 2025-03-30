package com.example.oope11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import com.example.oope11.adapters.ViewPagerAdapter;
import com.example.oope11.fragments.MatchesFragment;
import com.example.oope11.fragments.PlayersFragment;
import com.example.oope11.fragments.TeamsFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        setupViewPager();
        setupTabLayout();
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        adapter.addFragment(new TeamsFragment(), "Teams");
        adapter.addFragment(new PlayersFragment(), "Players");
        adapter.addFragment(new MatchesFragment(), "Matches");
        viewPager.setAdapter(adapter);
    }

    private void setupTabLayout() {
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(((ViewPagerAdapter) viewPager.getAdapter()).getPageTitle(position))
        ).attach();
    }
}