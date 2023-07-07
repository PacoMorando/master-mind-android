package sas.mastermind.android.views;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class BoardView {
    private final SecretCombinationView secretCombinationView;
    private final ProposedCombinationView proposedCombinationView;
    private ResultsView resultsView;

    public BoardView(PlayController playController) {
        this.secretCombinationView = new SecretCombinationView(playController.getSecretCombination());
        Activity.setFragmentView(R.id.secretCombinationFragmentContainer, this.secretCombinationView);
        this.proposedCombinationView = new ProposedCombinationView(playController.getProposeCombinations());
        Activity.setFragmentView(R.id.proposedCombinationFragmentContainer, this.proposedCombinationView);
        this.resultsView = new ResultsView(playController);
        Activity.setFragmentView(R.id.resultsRecyclerViewFragmentContainer, this.resultsView);
    }

    public void showBoardResult(PlayController playController) {
        if (!playController.isFinished()) {
            this.showBoard();
            Activity.toast(String.valueOf(playController.getCurrentAttempt()));
        } else {
            this.showGameResult(playController);
            Activity.toast(String.valueOf(playController.getCurrentAttempt()));
        }
    }

    private void showBoard() {
        this.secretCombinationView.showUnrevealed();
        this.resultsView.showProposedCombinationsResults();
    }

    private void showGameResult(PlayController playController) {
        if (playController.isWinner()) {
            //Message.WINNER.write();
        } else {
            this.secretCombinationView.showRevealed();
            //Message.LOSER.write();
            Activity.toast("Has perdido!");
        }
        playController.next();
    }

    public void addProposedCombination(PlayController playController) {
        this.proposedCombinationView.addProposedCombination(playController);
    }

    public void pintarCombinacionSecreta() {///este se va a tener que ir porque era solo para probar
        this.secretCombinationView.showRevealed();
    }
}
