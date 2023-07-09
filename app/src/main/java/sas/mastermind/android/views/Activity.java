package sas.mastermind.android.views;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import sas.mastermind.android.MainActivity;

public class Activity {
    static MainActivity activity;
    static FragmentManager supportFragmentManager;

    public static void init(MainActivity activity) {
        Activity.activity = activity;
    }

    public static android.content.Context getContext() {
        return Activity.activity;
    }

    public static MainActivity getInstance() {
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

    public static void toast(String message){
        Toast.makeText(Activity.getContext(),message,Toast.LENGTH_SHORT).show();
    }
}