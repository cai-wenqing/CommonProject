package com.example.qiany.commonproject.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.qiany.commonproject.R;


/**
 * @author caiwenqing
 * @data 2018/7/26
 * description:多状态切换view
 */
public class MultiStateView extends FrameLayout {

    public static final int STATE_EMPTY = 10001;
    public static final int STATE_FAIL = 10002;
    public static final int STATE_NONET = 10003;

    private SparseArray<View> mStatusViewArray = new SparseArray<>();
    private SparseIntArray mLayoutIDArray = new SparseIntArray();
    private int mCurrentStatus = -1;
    private onClickRetryListener mListener;

    public MultiStateView(@NonNull Context context) {
        super(context);
    }

    public MultiStateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiStateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void addStateView(int status, int layoutID) {
        mLayoutIDArray.put(status, layoutID);
    }

    /**
     * 获取指定状态的View
     *
     * @param status
     * @return
     */
    public View getView(int status) {
        return mStatusViewArray.get(status);
    }

    /**
     * 获取当前状态View
     *
     * @return
     */
    public View getCurrentView() {
        View view = getView(mCurrentStatus);
        if (view == null) {
            throw new NullPointerException("current status view is null,status = " + mCurrentStatus);
        }
        return view;
    }

    /**
     * 获取当前状态
     *
     * @return
     */
    public int getCurrentStatus() {
        return mCurrentStatus;
    }


    /**
     * 切换视图
     *
     * @param status
     */
    public void setViewStatus(int status) {
        if (getVisibility() != VISIBLE) {
            setShow(true);
        }
        if (status != mCurrentStatus) {
            if (mCurrentStatus != -1) {
                getCurrentView().setVisibility(GONE);
            }
            mCurrentStatus = status;
            View view = getView(status);
            if (view != null) {
                view.setVisibility(VISIBLE);
            } else {
                int layoutID = mLayoutIDArray.get(status);
                if (layoutID == 0) {
                    return;
                }
                view = LayoutInflater.from(getContext()).inflate(layoutID, this, false);
                if (status == STATE_FAIL || status == STATE_NONET) {
                    View clickView = view.findViewById(R.id.item_tv_try);
                    if (clickView != null) {
                        clickView.setOnClickListener(new OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (mListener != null) {
                                    mListener.onClickRetry(mCurrentStatus);
                                }
                            }
                        });
                    }
                }
                mStatusViewArray.put(status, view);
                addView(view);
                view.setVisibility(VISIBLE);
            }
        }
    }

    public void setShow(boolean show) {
        if (show) {
            this.setVisibility(VISIBLE);
        } else {
            this.setVisibility(GONE);
        }
    }


    public interface onClickRetryListener {
        void onClickRetry(int status);
    }

    public void setOnClickRetryListener(onClickRetryListener listener) {
        mListener = listener;
    }
}
