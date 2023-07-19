package sas.mastermind.android.dao;

public class SessionDAO extends sas.mastermind.core.dao.SessionDAO {
    @Override
    public void load(String name) {
        this.sessionDTO.setName(name);
        //TODO este metodo debe pasarle un core.mode.Game al this.sessionDTO "this.sessionDTO.loadGame(core.model.Game'creado a partir de leer la db segun el name')"
    }

    @Override
    public void save(String name) {
        //TODO el name lo va a recibir del dialog que llame a este metodo, con base a ese name guardar en la base de datos
        //gameDao.insertAll(new Game(name, this.sessionDTO.getSecretCombination().toString()));
        //proposedCombinationsDAO.insert(new ProposedCombination(name, this.sessionDTO.getProposeCombinations())); el getProposedCombinatios antes se debe de convertir en un List<String>
    }

    @Override
    public String[] getGamesNames() {
        return new String[0];
    }

    @Override
    public boolean exist(String name) {
        return false;
    }
}
