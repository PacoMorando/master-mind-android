package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.databinding.PlayViewBinding;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    private PlayController playController;//este lo deberia de tener que borrar al final
    private PlayViewBinding binding;
    private BoardView boardView;

    public void interact(PlayController playController) {
        this.playController = playController; // este lo deberia de poder borrar al final;
        this.boardView = new BoardView(playController);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = PlayViewBinding.inflate(inflater, container, false);
        this.binding.setPlayView(this);
        //this.setBoard();
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.boardView.showBoardResult(this.playController);
    }

    /*private void showBoardResult() {
        if (!this.playController.isFinished()) {
            this.boardView.showBoard();
            Activity.toast(String.valueOf(this.playController.getCurrentAttempt()));
        } else {
            boardView.showGameResult(playController);
        }
    }*/

    public void addProposeCombination() {
        this.boardView.addProposedCombination(this.playController);
        this.boardView.showBoardResult(this.playController);
        //Activity.toast(String.valueOf(this.playController.getCurrentAttempt()));
    }

    public void undo() {
        Activity.toast(this.playController.getSecretCombination().toString());
    }

    public void redo() {
        this.boardView.pintarCombinacionSecreta();
    }

    public void exit() {

    }
}
