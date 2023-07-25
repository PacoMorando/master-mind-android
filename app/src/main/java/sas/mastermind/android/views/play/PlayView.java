package sas.mastermind.android.views.play;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.databinding.PlayViewBinding;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    private PlayController playController;
    private PlayViewBinding binding;
    private BoardView boardView;
    private boolean isNextStateEnable;

    public void interact(PlayController playController) {
        this.isNextStateEnable = true;
        this.playController = playController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = PlayViewBinding.inflate(inflater, container, false);
        this.binding.setPlayView(this);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.boardView = new BoardView(playController, (MainActivity) requireActivity());
        this.boardView.showBoardResults();
        this.setEnableButtons();
    }

    private void setEnableButtons() {
        this.binding.undo.setEnabled(this.playController.isUndoable());
        this.binding.redo.setEnabled(this.playController.isRedoable());
        this.binding.addProposeCombination.setEnabled(!this.playController.isFinished());
    }

    public void addProposeCombination() {
        this.boardView.addProposedCombination();
        this.boardView.showBoardResults();
        this.setEnableButtons();
        this.showFinishDialog();
    }

    public void undo() {
        if (this.playController.isUndoable()) {
            this.playController.undo();
            this.boardView.showBoardResults();
        }
        this.setEnableButtons();
    }

    public void redo() {
        if (this.playController.isRedoable()) {
            this.playController.redo();
            this.boardView.showBoardResults();
        }
        this.setEnableButtons();
        this.showFinishDialog();
    }

    private void showFinishDialog() {
        if (this.playController.isFinished()) {
            new FinishDialog(this.playController, this.playController.isWinner()).show(requireActivity().getSupportFragmentManager(), "finish");
        }
    }

    public void exit() {
        playController.next();
        ((MainActivity) requireActivity()).next();
    }
}