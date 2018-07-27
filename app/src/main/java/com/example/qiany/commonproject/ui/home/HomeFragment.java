package com.example.qiany.commonproject.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qiany.commonproject.R;
import com.example.qiany.commonproject.ui.base.BaseFragment;
import com.example.qiany.commonproject.widget.MultiStateView;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import io.reactivex.functions.Consumer;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    private static final String TAG = "HomeFragment";

    @BindView(R.id.home_ll_test)
    LinearLayout llTest;
    @BindView(R.id.home_btn_test_bugly)
    Button btnTest1;
    @BindView(R.id.home_btn_test2)
    Button btnTest2;
    @BindView(R.id.home_btn_tv_content)
    TextView tvContent;

    private int count = 0;

    public static HomeFragment newInstance() {
        Bundle bundle = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        RxView.clicks(btnTest1)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (count == 0) {
                            onEmpty();
                            count++;
                        } else if (count == 1) {
                            onFail();
                            count++;
                        } else if (count == 2) {
                            onNoNet();
                            count++;
                        } else if (count == 3) {
                            onSuccess();
                            count++;
                        }
                    }
                });
    }

    @Override
    public void initData() {
        mPresenter.getArtistData(0);
    }

    @Override
    public void loadMoreArtist() {

    }

    @Override
    public void onRetry(int status) {
        if (status == MultiStateView.STATE_NONET) {
            toastMsg("无网络，点击了重试");
        } else if (status == MultiStateView.STATE_FAIL) {
            toastMsg("加载失败，点击了重试");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
