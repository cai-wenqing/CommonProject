package com.example.qiany.commonproject.ui.home;

import com.example.qiany.commonproject.ui.base.BaseContract;

/**
 * @author caiwenqing
 * @data 2018/5/12
 * description:
 */
public interface HomeContract {

    interface View extends BaseContract.View{

        void loadMoreArtist();
    }

    interface Presenter extends BaseContract.Presenter<View>{

        void getBannerData();

        void getArtistData(int page);
    }
}
