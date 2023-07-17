package sas.mastermind.android.views;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class BoardView {
    private final PlayController playController;

    private final SecretCombinationView secretCombinationView;
    private final ProposedCombinationView proposedCombinationView;
    private final ResultsView resultsView;

    public BoardView(PlayController playController, MainActivity mainActivity) {
        this.playController = playController;
        this.secretCombinationView = new SecretCombinationView(this.playController.getSecretCombination());
        mainActivity.setFragmentView(R.id.secretCombinationFragmentContainer, this.secretCombinationView);
        this.proposedCombinationView = new ProposedCombinationView();
        mainActivity.setFragmentView(R.id.proposedCombinationFragmentContainer, this.proposedCombinationView);
        this.resultsView = new ResultsView(this.playController);
        mainActivity.setFragmentView(R.id.resultsRecyclerViewFragmentContainer, this.resultsView);
    }

    public void showBoardResults(MainActivity mainActivity) {
        if (!this.playController.isFinished()) {
            this.secretCombinationView.showUnrevealed();
            this.resultsView.showProposedCombinationsResult();
        } else {
            this.resultsView.showProposedCombinationsResult();
            this.showGameResult(mainActivity);
        }
    }

    private void showGameResult(MainActivity mainActivity) {
        if (this.playController.isWinner()) {
            this.secretCombinationView.showRevealed();
        } else {
            this.secretCombinationView.showRevealed();
        }
        new SaveDialog(this.playController).show(mainActivity.getSupportFragmentManager(),"save game");
    }

    public void addProposedCombination() {
        this.proposedCombinationView.addProposedCombination(this.playController);
    }
}