package com.example.qiany.commonproject.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

import com.example.qiany.commonproject.core.AppManager;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public class ToastUtils {

    private static Toast mToast;

    public static void ToastCenter(String msg) {
        toast(msg, -1, Gravity.CENTER, Toast.LENGTH_SHORT);
    }

    public static void ToastCenter(int resId) {
        toast("", resId, Gravity.CENTER, Toast.LENGTH_SHORT);
    }

    public static void ToastBottom(String msg) {
        toast(msg, -1, Gravity.BOTTOM, Toast.LENGTH_SHORT);
    }

    public static void ToastBottom(int resId) {
        toast("", resId, Gravity.BOTTOM, Toast.LENGTH_SHORT);
    }

    private static void toast(CharSequence msg, int resId, int gravity, int duration) {
        Activity activity = AppManager.getAppManager().currentActivity();
        if (activity != null) {
            if (!TextUtils.isEmpty(msg)) {
                if (mToast == null) {
                    mToast = Toast.makeText(activity, msg, duration);
                }
                mToast.setText(msg);
            } else {
                if (mToast == null) {
                    mToast = Toast.makeText(activity, "" + activity.getResources().getText(resId), duration);
                }

                mToast.setText(activity.getResources().getText(resId) + "");
            }

            mToast.setDuration(duration);
            if (gravity != 0) {
                mToast.setGravity(gravity, 0, 0);
            }

            mToast.show();
        }
    }
}
