package sas.mastermind.android.views.start;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.databinding.StartViewBinding;
import sas.mastermind.android.views.start.OpenDialog;
import sas.mastermind.core.controllers.StartController;

public class StartView extends Fragment {
    private StartController startController;
    private StartViewBinding binding;

    public void interact(StartController startController) {
        this.startController = startController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = StartViewBinding.inflate(inflater, container, false);
        binding.setStartView(this);
        this.setOpenGameEnable();
        View view = binding.getRoot();
        return view;
    }

    private void setOpenGameEnable() {
        this.binding.openGameButton.setEnabled(this.startController.getGamesNames().length > 0);
    }

    public void openGame() {
        new OpenDialog(this.startController).show(requireActivity().getSupportFragmentManager(), "open game");
    }

    public void start(){
        this.startController.start();
        ((MainActivity) requireActivity()).next();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }
}