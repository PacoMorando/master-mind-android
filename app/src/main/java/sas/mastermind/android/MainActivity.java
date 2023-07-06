package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import sas.mastermind.android.views.Activity;

public class MainActivity extends AppCompatActivity {
    private final AndroidMasterMind androidMasterMind = new AndroidMasterMind();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activity.init(this);
        this.androidMasterMind.play();
    }

    public void next(View view) {
        this.androidMasterMind.play();
    }
}