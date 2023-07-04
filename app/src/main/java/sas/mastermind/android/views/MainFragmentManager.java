package sas.mastermind.android.views;

import androidx.fragment.app.FragmentManager;

public class MainFragmentManager {
    static FragmentManager supportFragmentManager;

    public static void init (FragmentManager supportFragmentManager){
        MainFragmentManager.supportFragmentManager = supportFragmentManager;
    }
}
