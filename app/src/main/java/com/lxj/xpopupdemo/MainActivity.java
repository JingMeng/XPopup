package com.lxj.xpopupdemo;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.util.navbar.NavigationBarObserver;
import com.lxj.xpopup.util.navbar.OnNavigationBarListener;
import com.lxj.xpopupdemo.fragment.AllAnimatorDemo;
import com.lxj.xpopupdemo.fragment.CustomAnimatorDemo;
import com.lxj.xpopupdemo.fragment.CustomPopupDemo;
import com.lxj.xpopupdemo.fragment.ImageViewerDemo;
import com.lxj.xpopupdemo.fragment.PartShadowDemo;
import com.lxj.xpopupdemo.fragment.QuickStartDemo;

public class MainActivity extends AppCompatActivity {

    PageInfo[] pageInfos = new PageInfo[]{
            new PageInfo("蹇€熷紑濮?, new QuickStartDemo()),
            new PageInfo("灞€閮ㄩ槾褰?, new PartShadowDemo()),
            new PageInfo("鍥剧墖娴忚", new ImageViewerDemo()),
            new PageInfo("灏濊瘯涓嶅悓鍔ㄧ敾", new AllAnimatorDemo()),
            new PageInfo("鑷畾涔夊脊绐?, new CustomPopupDemo()),
            new PageInfo("鑷畾涔夊姩鐢?, new CustomAnimatorDemo())
    };

    TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(actionBar.getTitle() + BuildConfig.VERSION_NAME);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        XPopup.setPrimaryColor(getResources().getColor(R.color.colorPrimary));
//        XPopup.setAnimationDuration(1000);
//        XPopup.setPrimaryColor(Color.RED);


        ToastUtils.showShort("onCreate ...");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ToastUtils.showShort("config change...");
    }

    class MainAdapter extends FragmentPagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return pageInfos[i].fragment;
        }

        @Override
        public int getCount() {
            return pageInfos.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return pageInfos[position].title;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewPager.removeAllViews();
        viewPager = null;
        pageInfos = null;
    }
}

