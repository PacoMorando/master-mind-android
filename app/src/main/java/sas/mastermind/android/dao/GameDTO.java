package sas.mastermind.android.dao;

import java.util.ArrayList;
import java.util.List;

import sas.mastermind.core.models.Game;
import sas.mastermind.core.models.ProposedCombination;
import sas.mastermind.core.models.SecretCombination;

public class GameDTO {
    SecretCombination secretCombination;
    ArrayList<sas.mastermind.core.models.ProposedCombination> proposedCombinations = new ArrayList<>();

    public GameDTO (String secretCombination, List<sas.mastermind.android.dao.ProposedCombination> proposedCombinations){
        this.setSecretCombination(secretCombination);
        this.setProposedCombinations(proposedCombinations);
    }

    public Game getLoadedGame(){
        return new Game(this.secretCombination, this.proposedCombinations);
    }

    private void setProposedCombinations(List<sas.mastermind.android.dao.ProposedCombination> proposedCombinations) {
        for (sas.mastermind.android.dao.ProposedCombination proposedCombination : proposedCombinations) {
            this.proposedCombinations.add(new ProposedCombination(proposedCombination.combination));
        }
    }

    private void setSecretCombination(String secretCombination) {
        this.secretCombination = new SecretCombination(secretCombination);
    }
}
