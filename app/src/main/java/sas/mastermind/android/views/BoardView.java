package sas.mastermind.android.views;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class BoardView {
    private final PlayController playController;
    private final SecretCombinationView secretCombinationView;
    private final ProposedCombinationView proposedCombinationView;
    private final ResultsView resultsView;

    public BoardView(PlayController playController) {
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
            this.secretCombinationView.showUnrevealed();
            this.resultsView.showProposedCombinationsResult();
        } else {
            this.resultsView.showProposedCombinationsResult();
            this.showGameResult();
        }
    }

    private void showGameResult() {
        if (this.playController.isWinner()) {
            Activity.toast("Has ganado!");
            this.secretCombinationView.showRevealed();
        } else {
            Activity.toast("Has perdido!");
            this.secretCombinationView.showRevealed();
        }
        new SaveDialog(this.playController).show(Activity.getSupportFragmentManager(),"save game");//TODO refactorizar el singleton
    }

    public void addProposedCombination() {
        this.proposedCombinationView.addProposedCombination(this.playController);
    }
}