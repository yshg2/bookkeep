package com.simple_bookkeep.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.simple_bookkeep.android.adapter.RecordPagerAdapter;
import com.simple_bookkeep.android.frag_record.IncomeFragment;
import com.simple_bookkeep.android.frag_record.BaseRecordFragment;
import com.simple_bookkeep.android.frag_record.OutcomeFragment;

import java.util.ArrayList;
import java.util.List;


public class RecordActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        tabLayout=findViewById(R.id.record_tabs);
        viewPager=findViewById(R.id.record_vp);
        initPager();
    }

    private void initPager() {
        List<Fragment>fragmentList=new ArrayList<>();
        OutcomeFragment outFrag = new OutcomeFragment();
        IncomeFragment InFrag = new IncomeFragment();
        fragmentList.add(outFrag);
        fragmentList.add(InFrag);
        //创建适配器
        RecordPagerAdapter pagerAdapter = new RecordPagerAdapter(getSupportFragmentManager(), fragmentList);
        //设置适配器
        viewPager.setAdapter(pagerAdapter);
        //tabLayout和viewPager进行关联
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.record_iv_back:
                finish();
                break;
        }
    }
}