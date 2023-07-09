package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.databinding.PlayViewBinding;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    private PlayController playController;
    private PlayViewBinding binding;
    private BoardView boardView;

    public void interact(PlayController playController) {
        this.playController = playController;
        this.boardView = new BoardView(playController);
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
        this.boardView.showBoardResults();
    }

    public void addProposeCombination() {
        this.boardView.addProposedCombination();
        this.boardView.showBoardResults();
    }

    public void undo() {
       // Activity.toast(this.playController.getSecretCombination().toString());
        if (this.playController.isUndoable()){//TODO DESABILITAR EL BOTON SI isUndoable = false
            this.playController.undo();
            this.boardView.showBoardResults();
        }
    }

    public void redo() {
        //this.boardView.pintarCombinacionSecreta();//TODO METER UN TEXT VIEW QUE PONGA LA COMBINACION SECRETA PARA HACER PRUEBAS
        if (this.playController.isRedoable()){ //TODO DESABILITAR EL BOTON SI isRedoable = false
            this.playController.redo();
            this.boardView.showBoardResults();
        }
    }

    public void exit() {
        //TODO programar un boton de exit que lance un SaveDialog
    }
}
