package sas.mastermind.android.views;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class BoardView {
    private final PlayController playController;
    private final SecretCombinationView secretCombinationView;
    private final ProposedCombinationView proposedCombinationView;
    private ResultsView resultsView;

    public BoardView(PlayController playController) { // Plantearse que el play controller sea un parametro de la clase
        this.playController = playController;
        this.secretCombinationView = new SecretCombinationView(this.playController.getSecretCombination());
        Activity.setFragmentView(R.id.secretCombinationFragmentContainer, this.secretCombinationView);
        this.proposedCombinationView = new ProposedCombinationView(this.playController.getProposeCombinations());
        Activity.setFragmentView(R.id.proposedCombinationFragmentContainer, this.proposedCombinationView);
        this.resultsView = new ResultsView(this.playController);
        Activity.setFragmentView(R.id.resultsRecyclerViewFragmentContainer, this.resultsView);
    }

    public void showBoardResults() {
        if (!this.playController.isFinished()) {
            this.showBoard();
        } else {
            this.showBoard();
            this.showGameResult(this.playController);
        }
    }

    private void showBoard() {
        this.secretCombinationView.showUnrevealed();
        this.resultsView.showProposedCombinationsResult(this.playController);
    }

    private void showGameResult(PlayController playController) {
        if (playController.isWinner()) {
            //Message.WINNER.write();
            this.showBoard();
            Activity.toast("Has ganado!");
            this.secretCombinationView.showRevealed();
        } else {
            //Message.LOSER.write();
            this.showBoard();
            Activity.toast("Has perdido!");
            this.secretCombinationView.showRevealed();
        }
        playController.next();
    }

    public void addProposedCombination() {
        this.proposedCombinationView.addProposedCombination(this.playController);
    }

    public void pintarCombinacionSecreta() {///este se va a tener que ir porque era solo para probar
        this.secretCombinationView.showRevealed();
    }
}
