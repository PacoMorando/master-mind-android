package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import sas.mastermind.android.dao.AppDataBase;
import sas.mastermind.android.dao.Game;
import sas.mastermind.android.dao.GameDao;
import sas.mastermind.android.dao.ProposedCombination;
import sas.mastermind.android.dao.ProposedCombinationDAO;

public class MainActivity extends AppCompatActivity {
    private final AndroidMasterMind androidMasterMind = new AndroidMasterMind(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.androidMasterMind.play();

    }

    @Override
    protected void onResume() {
        super.onResume();

        //AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "mastermind-games").allowMainThreadQueries().build();
        //GameDao gameDao = db.gameDao();
        //ProposedCombinationDAO proposedCombinationDAO = db.proposedCombinationDAO();

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