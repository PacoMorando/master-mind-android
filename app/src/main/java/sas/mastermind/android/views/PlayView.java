package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.R;
import sas.mastermind.android.databinding.PlayViewBinding;
import sas.mastermind.core.controllers.PlayController;

public class PlayView extends Fragment {
    private PlayViewBinding binding;
    private PlayController playController;
    public void interact(PlayController playController) {

        String secretCombination = playController.getSecretCombination().toString();
        System.out.println(secretCombination);
        System.out.println(this + "OHOHOHOHOHOHOHOHOHOOHOH");
        //Toast.makeText(getContext(), secretCombination, Toast.LENGTH_SHORT).show();
        this.playController = playController;
        playController.next();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = PlayViewBinding.inflate(inflater, container, false);
        this.binding.setPlayView(this);
        View view = binding.getRoot();
        System.out.println(this + "XLXLXLXLXLXLXLXLXLXLXLXLXLX");
        return view;

    }

    public void redo(){
        String controller;
        if (this.playController == null){
            controller = "missing cotroller";
        }else {
            controller = this.playController.toString();
        }
        System.out.println(this + "OHOHOHOHOHOHOHOHOHOOHOH");
         Toast.makeText(getContext(), controller, Toast.LENGTH_SHORT).show();
    }

    public void addNames(){
        String secretCombination = this.playController.getSecretCombination().toString();
        System.out.println(secretCombination);
        Toast.makeText(getContext(), secretCombination, Toast.LENGTH_SHORT).show();
     //   String names[] = {"Pudin", "Nata", "Neni", "Paco", "Euler", "Asgard","Pudin", "Nata", "Neni", "Paco", "Euler", "Asgard","Pudin", "Nata", "Neni", "Paco", "Euler", "Asgard"};
    }
}
