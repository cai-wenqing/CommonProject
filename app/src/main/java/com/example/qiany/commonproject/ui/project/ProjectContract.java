package com.example.qiany.commonproject.ui.project;

import com.example.qiany.commonproject.ui.base.BaseContract;

/**
 * @author caiwenqing
 * @data 2018/5/13
 * description:
 */
public interface ProjectContract {

    interface View extends BaseContract.View{

    }

    interface Presenter extends BaseContract.Presenter<View>{
        void getData();
    }
}
