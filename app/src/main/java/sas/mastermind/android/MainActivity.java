package sas.mastermind.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sas.mastermind.android.dao.AppDataBase;
import sas.mastermind.android.dao.Game;
import sas.mastermind.android.dao.GameDao;
import sas.mastermind.android.dao.ProposedCombination;
import sas.mastermind.android.dao.ProposedCombinationDAO;

public class MainActivity extends AppCompatActivity {
    private final AndroidMasterMind androidMasterMind = new AndroidMasterMind(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.androidMasterMind.play();

    }

    @Override
    protected void onResume() {
        super.onResume();

        AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "mastermind-games").allowMainThreadQueries().build();
        GameDao gameDao = db.gameDao();
        ProposedCombinationDAO proposedCombinationDAO = db.proposedCombinationDAO();
        //gameDao.insertAll(this.insertGames()[0],this.insertGames()[1], this.insertGames()[2], this.insertGames()[3]);
        List<Game> games = gameDao.getGames();
        //populateProposedCombination(proposedCombinationDAO, games);
        //gameDao.deleteAll(games.get(0),games.get(1));
        List<ProposedCombination> proposedCombinationsGame1 = proposedCombinationDAO.gameProposedCombinations(games.get(0).name);
        List<ProposedCombination> proposedCombinationsGame2 = proposedCombinationDAO.gameProposedCombinations(games.get(1).name);
        List<ProposedCombination> proposedCombinationsGame3 = proposedCombinationDAO.gameProposedCombinations(games.get(2).name);
        List<ProposedCombination> proposedCombinationsGame4 = proposedCombinationDAO.gameProposedCombinations(games.get(3).name);


        TextView textViewTest = findViewById(R.id.database_test);

        textViewTest.setText(
                this.proposedCombinationBuilder(proposedCombinationsGame1)+"\n"+
                this.proposedCombinationBuilder(proposedCombinationsGame2)+"\n"+
                this.proposedCombinationBuilder(proposedCombinationsGame3)+"\n"+
                this.proposedCombinationBuilder(proposedCombinationsGame4)+"\n"
        );

    }

    public String dataInfo(List<Game> games) {
        StringBuilder stringBuilder = new StringBuilder();
        if (games.size() > 0) {
            for (Game game : games) {
                stringBuilder.append(game.name + "\n" + game.secretCombination + "\n");
            }
            return stringBuilder.toString();
        }else {
            return "No hay nada";
        }
    }

    public String proposedCombinationBuilder(List<ProposedCombination> proposedCombinations){
        StringBuilder stringBuilder = new StringBuilder();
        if (proposedCombinations.size()>0){
            for (ProposedCombination proposedCombination : proposedCombinations) {
                stringBuilder.append(proposedCombination.combination + "\n");
            }
            return stringBuilder.toString();
        }else {
            return "No hay combinaciones";
        }
    }

    private Game[] insertGames() {
        /*Game game1 = new Game("Game1", "rrcc", this.proposedCombinations("gggg", "rrrr", "bbbb"));
        Game game2 = new Game("Game2", "mmgg", this.proposedCombinations("rrrr", "bbbb", "gggg"));
        Game game3 = new Game("Game3", "yybb", this.proposedCombinations("bbbb", "bbbb", "bbbb"));
        Game game4 = new Game("Game4", "rybc", this.proposedCombinations("mmgg", "rrrr", "rybc"));*/
        Game game1 = new Game("Game1", "rrcc");
        Game game2 = new Game("Game2", "mmgg");
        Game game3 = new Game("Game3", "yybb");
        Game game4 = new Game("Game4", "rybc");
        return new Game[]{game1, game2, game3, game4};
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
    private static void populateProposedCombination(ProposedCombinationDAO proposedCombinationDAO, List<Game> games) {
        proposedCombinationDAO.insert(new ProposedCombination(games.get(0).name,"prop1Game1"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(0).name,"prop2Game1"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(0).name,"prop3Game1"));

        proposedCombinationDAO.insert(new ProposedCombination(games.get(1).name,"prop1Game2"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(1).name,"prop2Game2"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(1).name,"prop3Game2"));

        proposedCombinationDAO.insert(new ProposedCombination(games.get(2).name,"prop1Game3"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(2).name,"prop2Game3"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(2).name,"prop3Game3"));

        proposedCombinationDAO.insert(new ProposedCombination(games.get(3).name,"prop1Game4"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(3).name,"prop2Game4"));
        proposedCombinationDAO.insert(new ProposedCombination(games.get(3).name,"prop3Game4"));
    }
}