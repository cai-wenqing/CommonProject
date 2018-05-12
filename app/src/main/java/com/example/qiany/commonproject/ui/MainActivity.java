package com.example.qiany.commonproject.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseActivity;
import com.example.qiany.commonproject.ui.base.BaseContract;
import com.example.qiany.commonproject.ui.base.MySupportFragment;
import com.example.qiany.commonproject.ui.home.HomeFragment;
import com.example.qiany.commonproject.ui.mine.MineFragment;
import com.example.qiany.commonproject.ui.project.ProjectFragment;
import com.example.qiany.commonproject.ui.tree.TreeFragment;
import com.example.qiany.commonproject.utils.BottomNavigationViewHelper;

import butterknife.BindView;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.main_frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.main_bottomNavigation)
    BottomNavigationView mBottomNavigation;

    private MySupportFragment[] mFragments = new MySupportFragment[4];


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView(View view, Bundle savedInstanceState) {
        //解决多余三个tab时滑动问题
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigation);

        if (savedInstanceState == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = TreeFragment.newInstance();
            mFragments[2] = ProjectFragment.newInstance();
            mFragments[3] = MineFragment.newInstance();

            getSupportDelegate().loadMultipleRootFragment(R.id.main_frameLayout, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]);
        } else {
            mFragments[0] = findFragment(HomeFragment.class);
            mFragments[1] = findFragment(TreeFragment.class);
            mFragments[2] = findFragment(ProjectFragment.class);
            mFragments[3] = findFragment(MineFragment.class);
        }

        mBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        getSupportDelegate().showHideFragment(mFragments[0]);
                        break;
                    case R.id.action_tree:
                        getSupportDelegate().showHideFragment(mFragments[1]);
                        break;
                    case R.id.action_project:
                        getSupportDelegate().showHideFragment(mFragments[2]);
                        break;
                    case R.id.action_mine:
                        getSupportDelegate().showHideFragment(mFragments[3]);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public BaseContract.Presenter createPresenter() {
        return null;
    }
}
