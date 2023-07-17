package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {
    private final AndroidMasterMind androidMasterMind = new AndroidMasterMind(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.androidMasterMind.play();
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

    //TODO implentar que no se pueda girar la pantalla y no se si implentar que desaparezca la barra de abajo...
}