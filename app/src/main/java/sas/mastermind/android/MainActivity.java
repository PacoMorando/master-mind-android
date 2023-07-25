package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private AndroidMasterMind androidMasterMind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO Configuracion para que no se pueda girar la pantalla
        this.androidMasterMind = new AndroidMasterMind(this);
        this.androidMasterMind.play();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void setFragmentView(int fragmentContainerView, Fragment fragmentView) {
        this.getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .replace(fragmentContainerView, fragmentView, null)
                .commit();
    }

    public void next() {
        this.androidMasterMind.play();
    }

    public void next(View view) {
        this.androidMasterMind.play();
    }
}