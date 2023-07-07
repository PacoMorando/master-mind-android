package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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
        View view = binding.getRoot();
        System.out.println(this);
        this.setBoard();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.showBoardResult();
    }

    private void setBoard() {
        this.binding.boardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.binding.boardRecyclerView.setAdapter(new BoardRecyclerAdapter());
        //this.showBoard(playController);
    }

    private void showBoard(PlayController playController) {
            this.boardView.showBoard(playController);
    }

    private void showBoardResult() {
        if (!this.playController.isFinished()) {
            this.boardView.showBoard(playController);
            System.out.println("SHOW BOARD RESULT ON RESUME PLAY VIEW");
        } else {
            boardView.showGameResult(playController);
        }
    }

    public void redo(){
        this.boardView.pintarCombinacionSecreta();
    }

    public void undo(){
        Toast.makeText(getContext(), this.playController.getSecretCombination().toString(), Toast.LENGTH_SHORT).show();
        /*binding.boardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.boardRecyclerView.setAdapter(new BoardAdapter());*/
    }
}
