package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import sas.mastermind.android.views.MainFragmentManager;
import sas.mastermind.android.views.SaveView;
import sas.mastermind.android.views.StartView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragmentManager.init(getSupportFragmentManager());
        System.out.println("ON CREATE MAIN ACTIVITYYYYYYYYYYYY");
        new AndroidMasterMind().play();
    }

    public void setExample(View view) {
        MainFragmentManager.setView(R.id.fragment_container_view, ExampleFragment.class);
        System.out.println("PLAY EXAMPLE");
    }

    public void setStartView(View view) {
        MainFragmentManager.setView(R.id.fragment_container_view, StartView.class);
        System.out.println("PLAY START");
    }
}