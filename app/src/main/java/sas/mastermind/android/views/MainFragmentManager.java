package sas.mastermind.android.views;

import androidx.fragment.app.FragmentManager;

public class MainFragmentManager {
    static FragmentManager supportFragmentManager;

    public static void init (FragmentManager supportFragmentManager){
        MainFragmentManager.supportFragmentManager = supportFragmentManager;
    }

    public static void setView (int fragmentContainerView, Class fragmentViewClass){
        supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(fragmentContainerView, fragmentViewClass, null)
                .commit();
    }
}
