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
            SaveDialog saveDialog = new SaveDialog(this.playController);
            saveDialog.setCancelable(false); // esto es para que no se pueda clicar fuer del dialogo, pero tengo que TODO programar que el boton de propose se desactive cuando termine la partida
            saveDialog.show(Activity.getInstance().getSupportFragmentManager(),"save game");
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
        this.playController.next();//ESTE NEXT ME MANDA AL SAVE CONTROLLER
    }

    public void addProposedCombination() {
        this.proposedCombinationView.addProposedCombination(this.playController);
    }

    public void pintarCombinacionSecreta() {// TODO este se va a tener que ir porque era solo para probar
        this.secretCombinationView.showRevealed();
    }
}