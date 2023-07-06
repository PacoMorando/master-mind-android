package sas.mastermind.android.views;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainFragmentManager {
    static FragmentManager supportFragmentManager;

    public static void init (FragmentManager supportFragmentManager){
        MainFragmentManager.supportFragmentManager = supportFragmentManager;
    }

    public static void setView (int fragmentContainerView, Fragment fragmentView){
        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(fragmentContainerView, fragmentView, null)
                .commit();

    }
}
