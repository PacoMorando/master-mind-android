package sas.mastermind.android.dao;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

import sas.mastermind.core.models.Game;

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
        return new String[]{"Juego 1", "Juego 2", "Juego 3", "Juego 4", "Juego 5", "Juego 6", "Juego 7"};
    }

    @Override
    public boolean exist(String name) {/*
        return this.gameDao.getGame(name) != null;*/
        return false;
    }
}