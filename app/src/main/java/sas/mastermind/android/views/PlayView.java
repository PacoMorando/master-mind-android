package sas.mastermind.android.views;

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

    public void interact(PlayController playController) {
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
        this.boardView.showBoardResults((MainActivity) getActivity());
        this.setEnableButtons();
    }

    private void setEnableButtons() {
        this.binding.undo.setEnabled(this.playController.isUndoable());
        this.binding.redo.setEnabled(this.playController.isRedoable());
        this.binding.addProposeCombination.setEnabled(!this.playController.isFinished());
    }

    public void addProposeCombination() {
        this.boardView.addProposedCombination();
        this.boardView.showBoardResults((MainActivity) getActivity());
        this.setEnableButtons();
    }

    public void undo() {
        System.out.println("UNDO");
        if (this.playController.isUndoable()){
            this.playController.undo();
            this.boardView.showBoardResults((MainActivity) getActivity());
        }
        this.setEnableButtons();
    }

    public void redo() {
        System.out.println("REDO");
        if (this.playController.isRedoable()){
            this.playController.redo();
            this.boardView.showBoardResults((MainActivity) getActivity());
        }
        this.setEnableButtons();
    }

    public void exit() {
        new SaveDialog(this.playController).show(requireActivity().getSupportFragmentManager(),"exit game");
    }
}