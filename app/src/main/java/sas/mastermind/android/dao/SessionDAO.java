package sas.mastermind.android.dao;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sas.mastermind.android.views.SecretCombinationView;
import sas.mastermind.core.models.Game;
import sas.mastermind.core.models.SecretCombination;

public class SessionDAO extends sas.mastermind.core.dao.SessionDAO {
    /*private AppDataBase dataBase;
    private final GameDao gameDao;
    private final ProposedCombinationDAO proposedCombinationDAO;*/

    public SessionDAO(Context context) {
        /*this.dataBase = Room.databaseBuilder(context, AppDataBase.class, "mastermind-games").allowMainThreadQueries().build();;
        this.gameDao = dataBase.gameDao();
        this.proposedCombinationDAO = dataBase.proposedCombinationDAO();*/
    }

    @Override
    public void load(String name) {/*
        this.sessionDTO.setName(name);
        this.sessionDTO.loadGame(this.getLoadedGame(this.gameDao.getGame(name), this.proposedCombinationDAO.gameProposedCombinations(name)));*/
        this.tempLoad(name);
    }

    private Game getLoadedGame(sas.mastermind.android.dao.Game game, List<ProposedCombination> proposedCombinations) {
        return new GameDTO(game.secretCombination, proposedCombinations).getLoadedGame();
    }

    @Override
    public void save(String name) {/*
        if (!this.exist(name)){
            this.gameDao.insert(new sas.mastermind.android.dao.Game(name, this.sessionDTO.getSecretCombination().toString()));
            this.saveProposedCombinations(name);
        }else {
            this.upDateProposedCombinations(name);
        }
        //TODO aqui me va a dar un error, si ya tengo un game salvado y lo quiero volver a grabar va a insertar un game con el mismo nombre y dara error*/
        this.tempSave(name);
    }


    private void saveProposedCombinations(String name) {/*
        for (sas.mastermind.core.models.ProposedCombination proposedCombination : this.sessionDTO.getProposeCombinations()) {
            proposedCombinationDAO.insert(new ProposedCombination(name,proposedCombination.toString()));
        }*/
    }

    private void upDateProposedCombinations(String name) {/*
        //TODO CAMBIAR QUE SE BORRE TODO Y SE REESCRIBA POR UPDATE
        for (ProposedCombination proposedCombination : this.proposedCombinationDAO.gameProposedCombinations(name)) {
            this.proposedCombinationDAO.delete(proposedCombination);
        }
        this.saveProposedCombinations(name);*/
    }

    @Override
    public String[] getGamesNames() {/*
        List<sas.mastermind.android.dao.Game> games = this.gameDao.getGames();
        String[] names = new String[games.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = games.get(i).name;
        }
        return names;*/
        //return new String[]{"Juego 1", "Juego 2", "Juego 3", "Juego 4", "Juego 5", "Juego 6", "Juego 7"};
        return this.tempGetGamesNames();
    }

    @Override
    public boolean exist(String name) {/*
        return this.gameDao.getGame(name) != null;*/
        return false;
    }


    //TODO metodo para salvar en la memoria temporal, todos se borraran cuando esten terminadas los dialogs open/save

    private final HashMap<String, Game> gamesSaved = new HashMap<>();
    private final HashMap<String, SecretCombination> secretCombinationsMap = new HashMap<>();
    private final HashMap<String, ArrayList<sas.mastermind.core.models.ProposedCombination>> proposedCombinationMap = new HashMap<>();

    public void tempLoad(String name){
        this.sessionDTO.setName(name);
        //this.sessionDTO.loadGame(gamesSaved.get(name));
        this.sessionDTO.loadGame(new Game(secretCombinationsMap.get(name),proposedCombinationMap.get(name)));
    }
    public void tempSave(String name) {
        gamesSaved.put(name, new Game(sessionDTO.getSecretCombination(), sessionDTO.getProposeCombinations()));
        secretCombinationsMap.put(name, new SecretCombination(this.sessionDTO.getSecretCombination().toString()));
        proposedCombinationMap.put(name, this.tempSaveProposedCombinations());
    }

    public void tempSave(){
       this.tempSave(this.sessionDTO.getName());
    }

    private ArrayList<sas.mastermind.core.models.ProposedCombination> tempSaveProposedCombinations() {
        ArrayList<sas.mastermind.core.models.ProposedCombination> proposedCombinations = new ArrayList<>();
        for (sas.mastermind.core.models.ProposedCombination proposedCombination : this.sessionDTO.getProposeCombinations()) {
            proposedCombinations.add(new sas.mastermind.core.models.ProposedCombination(proposedCombination.toString()));
        }
        return proposedCombinations;
    }

    public String[] tempGetGamesNames() {
        ArrayList<String> gamesNames = new ArrayList<>();
        gamesSaved.forEach((name, game) -> {
            gamesNames.add(name);
        });
        return gamesNames.toArray(new String[0]);
    }

}