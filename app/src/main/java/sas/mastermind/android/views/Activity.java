package sas.mastermind.android.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class Activity {
    static AppCompatActivity activity;
    static FragmentManager supportFragmentManager;

    public static void init(AppCompatActivity activity) {
        Activity.activity = activity;
    }

    public static android.content.Context getContext() {
        return Activity.activity;
    }

    public static AppCompatActivity getInstance() {
        return Activity.activity;
    }

    public static void setFragmentView(int fragmentContainerView, Fragment fragmentView) {
        if (supportFragmentManager == null) {
            Activity.supportFragmentManager = activity.getSupportFragmentManager();
        }
        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(fragmentContainerView, fragmentView, null)
                .commit();
    }
}