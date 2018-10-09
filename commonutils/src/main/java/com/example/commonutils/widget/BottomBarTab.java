package com.example.commonutils.widget;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.commonutils.R;
import com.example.commonutils.utils.DpUtils;


public class BottomBarTab extends LinearLayout {
    private ImageView mIcon;
    private Context mContext;
    private TextView mTextView;
    private int mTabPosition = -1;

    public BottomBarTab(Context context, @DrawableRes int icon, String title) {
        this(context, null, icon, title);
    }


    public BottomBarTab(Context context, AttributeSet attrs, int icon, String title) {
        this(context, attrs, 0, icon, title);
    }

    public BottomBarTab(Context context, AttributeSet attrs, int defStyleAttr, int icon, String title) {
        super(context, attrs, defStyleAttr);
        init(context, icon, title);
    }

    private void init(Context context, int icon, String title) {
        mContext = context;

        setOrientation(LinearLayout.VERTICAL);
        mIcon = new ImageView(context);
        int size = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
        LayoutParams params = new LayoutParams(size, size);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.topMargin = DpUtils.dip2px(context, 2.5f);
        mIcon.setImageResource(icon);
        mIcon.setLayoutParams(params);

        LayoutParams textViewParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        textViewParams.gravity = Gravity.CENTER_HORIZONTAL;
        textViewParams.topMargin = DpUtils.dip2px(context, 2.5f);
        textViewParams.bottomMargin = DpUtils.dip2px(context, 2.5f);
        mTextView = new TextView(context);
        mTextView.setText(title);
        mTextView.setTextSize(DpUtils.dip2px(context, 3.2f));
        mTextView.setLayoutParams(textViewParams);
        mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.tab_unselect));
        addView(mIcon);
        addView(mTextView);
    }

    ScaleAnimation scaleAnimation2 = (ScaleAnimation) AnimationUtils.loadAnimation(getContext(), R.anim.bottomscalea);

    @Override
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected) {
            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary));
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.colorPrimary));

            mIcon.setAnimation(scaleAnimation2);
            mTextView.setAnimation(scaleAnimation2);
            scaleAnimation2.start();
        } else {
            mIcon.setColorFilter(ContextCompat.getColor(mContext, R.color.transparent));
            mTextView.setTextColor(ContextCompat.getColor(mContext, R.color.tab_unselect));
        }
    }


    public void setTabPosition(int position) {
        mTabPosition = position;
        if (position == 0) {
            setSelected(true);
        }
    }

    public int getTabPosition() {
        return mTabPosition;
    }
}
