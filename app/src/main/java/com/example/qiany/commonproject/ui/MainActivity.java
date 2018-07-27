package com.example.qiany.commonproject.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.commonutils.widget.BottomBar;
import com.example.commonutils.widget.BottomBarTab;
import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseActivity;
import com.example.qiany.commonproject.ui.base.BaseContract;
import com.example.qiany.commonproject.ui.base.MySupportFragment;
import com.example.qiany.commonproject.ui.home.HomeFragment;
import com.example.qiany.commonproject.ui.mine.MineFragment;
import com.example.qiany.commonproject.ui.project.ProjectFragment;
import com.example.qiany.commonproject.ui.tree.TreeFragment;

import butterknife.BindView;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.main_frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.main_bottomBar)
    BottomBar mBottomBar;


    private MySupportFragment[] mFragments = new MySupportFragment[4];


    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initView(View view, Bundle savedInstanceState) {
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

        mBottomBar.addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "首页"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "体系"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "项目"))
                .addItem(new BottomBarTab(this, R.mipmap.ic_launcher, "我的"));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                getSupportDelegate().showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

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

    @Override
    public void onRetry(int status) {

    }
}
