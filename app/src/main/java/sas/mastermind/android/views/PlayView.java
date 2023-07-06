package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import sas.mastermind.android.R;
import sas.mastermind.android.databinding.PlayViewBinding;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    private PlayViewBinding binding;
    private PlayController playController;
    public void interact(PlayController playController) {
        this.playController = playController;
        playController.next();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = PlayViewBinding.inflate(inflater, container, false);
        this.binding.setPlayView(this);
        View view = binding.getRoot();
        this.setBoard();
        return view;

    }

    private void setBoard() {
        binding.boardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.boardRecyclerView.setAdapter(new BoardAdapter());
    }

    public void redo(){
        String controller;
        if (this.playController == null){
            controller = "missing cotroller";
        }else {
            controller = this.playController.toString();
        }
         Toast.makeText(getContext(), controller, Toast.LENGTH_SHORT).show();
    }

    public void undo(){
        Toast.makeText(getContext(), this.playController.getSecretCombination().toString(), Toast.LENGTH_SHORT).show();
        /*binding.boardRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.boardRecyclerView.setAdapter(new BoardAdapter());*/
    }
}
