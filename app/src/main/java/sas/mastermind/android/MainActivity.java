package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AndroidMasterMind androidMasterMind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void toast(String message) { //TODO eliminar este metodo que solo es para pruebas chapusas
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}