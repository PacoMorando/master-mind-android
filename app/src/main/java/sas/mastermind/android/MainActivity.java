package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import sas.mastermind.android.views.MainFragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container_view, ExampleFragment.class, null)
                    .commit();
        }
        MainFragmentManager.init(getSupportFragmentManager());
        new AndroidMasterMind().play();
    }
}