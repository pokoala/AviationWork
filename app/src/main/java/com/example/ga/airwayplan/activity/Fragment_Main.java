package com.example.ga.airwayplan.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.ga.airwayplan.R;
import com.example.ga.airwayplan.adapter.MyFragmentPagerAdapter;
import com.example.ga.airwayplan.adapter.NoScrollViewPager;
import com.example.ga.airwayplan.fragment.Add_plan;
import com.example.ga.airwayplan.fragment.Plan;
import com.example.ga.airwayplan.fragment.User;

import java.util.ArrayList;

public class Fragment_Main extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private BottomNavigationView navigation;
    public NoScrollViewPager viewPager;
    private Add_plan addplan = new Add_plan();
    private Plan plan = new Plan();
    private User user = new User();
    ArrayList<Fragment> fragmentList = new ArrayList<>();


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            viewPager.setCurrentItem(item.getOrder());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment__main);
        initView();
        fragmentList.add(addplan);
        fragmentList.add(plan);
        fragmentList.add(user);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(),fragmentList );
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setCurrentItem(0);
    }

    protected void initView(){
        viewPager = (NoScrollViewPager) findViewById(R.id.viewPage);
        viewPager.addOnPageChangeListener(this);
        viewPager.setNoScroll(true);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigation.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
