package com.example.qiany.commonproject.core;

import android.app.Activity;
import android.content.Context;
import android.os.Process;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author caiwenqing
 * @data 2018/5/11
 * description:
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }

        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack();
        }

        activityStack.add(activity);
    }

    public Activity currentActivity() {
        return (Activity)activityStack.lastElement();
    }

    public void finishActivity() {
        Activity activity = (Activity)activityStack.lastElement();
        this.finishActivity(activity);
    }

    public void finishActivity(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }

    }

    public void finishActivity(Class<?> cls) {
        Iterator var2 = activityStack.iterator();

        while(var2.hasNext()) {
            Activity activity = (Activity)var2.next();
            if (activity.getClass().equals(cls)) {
                this.finishActivity(activity);
                break;
            }
        }

    }

    public void finishAllActivity() {
        int i = 0;

        for(int size = activityStack.size(); i < size; ++i) {
            if (null != activityStack.get(i)) {
                this.finishActivity((Activity)activityStack.get(i));
                break;
            }
        }

        activityStack.clear();
    }

    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null) {
            Iterator var1 = activityStack.iterator();

            while(var1.hasNext()) {
                Activity activity = (Activity)var1.next();
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        }

        return null;
    }

    public static Stack<Activity> getActivitys() {
        return activityStack;
    }

    public void AppExit(Context context) {
        try {
            this.finishAllActivity();
            Process.killProcess(Process.myPid());
            System.exit(0);
        } catch (Exception var3) {
            ;
        }

    }

    public int getActivityCount() {
        int count = activityStack.size();
        return count;
    }

    public void removeActivity(Activity activity) {
        if (activityStack != null) {
            if (activityStack.contains(activity)) {
                activityStack.remove(activity);
            }

            if (activity != null && !activity.isFinishing()) {
                activity.finish();
                activity = null;
            }

        }
    }
}
