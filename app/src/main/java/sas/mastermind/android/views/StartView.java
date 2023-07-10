package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.android.databinding.StartViewBinding;
import sas.mastermind.core.controllers.StartController;

public class StartView extends Fragment {
    private StartViewBinding binding;
    public void interact(StartController startController) {
        startController.start();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = StartViewBinding.inflate(inflater, container, false);
        binding.setStartView(this);
        View view = binding.getRoot();
        return view;
    }

    public void openGame(){
        ((MainActivity)requireActivity()).toast("persistence has not been implemented yet");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

}