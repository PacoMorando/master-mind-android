package sas.mastermind.android.views;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class BoardView {
    private final SecretCombinationView secretCombinationView;
    private ResultView resultView;

    public BoardView(PlayController playController) {
        this.secretCombinationView = new SecretCombinationView(playController.getSecretCombination());
        Activity.setFragmentView(R.id.secretCombinationFragmentContainer, this.secretCombinationView);
        //################ ESTO NO SE SI VA AQUIIIIIII ###################
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
        Activity.setFragmentView(R.id.proposedCombinationFragmentContainer, proposedCombinationView);
    }

    public void showBoard(PlayController playController) {
        System.out.println(this.secretCombinationView + "BOARD VIEW");
        this.secretCombinationView.showUnrevealed();
        new ResultView(playController).showProposedCombinationsResults();//creo que este lo voy a programar aqui... creo...
    }

    public void showGameResult(PlayController playController) {
        if (playController.isWinner()) {
            //Message.WINNER.write();
        } else {
            this.secretCombinationView.showRevealed();
            //Message.LOSER.write();
        }
        playController.next();
    }

    public void pintarCombinacionSecreta(){
        this.secretCombinationView.showRevealed();
    }
}
