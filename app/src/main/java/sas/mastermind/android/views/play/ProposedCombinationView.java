package sas.mastermind.android.views.play;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import sas.mastermind.android.databinding.ProposedCombinationBinding;
import sas.mastermind.core.controllers.PlayController;

public class ProposedCombinationView extends Fragment {
    private ProposedCombinationBinding binding;
    private final ArrayList<ColorPicker> proposedCombinationColors = new ArrayList<>();

    public ProposedCombinationView() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ProposedCombinationBinding.inflate(inflater, container, false);
        this.binding.setProposedCombinationView(this);
        this.setColors();
        return this.binding.getRoot();
    }

    private void setColors() {
        this.proposedCombinationColors.add(new ColorPicker(this.binding.pickerOne));
        this.proposedCombinationColors.add( new ColorPicker(this.binding.pickerTwo));
        this.proposedCombinationColors.add(new ColorPicker(this.binding.pickerThree));
        this.proposedCombinationColors.add(new ColorPicker(this.binding.pickerFour));
    }

    public void addProposedCombination(PlayController playController) {
        playController.addProposedCombination(this.getProposedCombinationString());
    }

    private String getProposedCombinationString() {
        StringBuilder proposedCombinationString = new StringBuilder();
        for (ColorPicker color : this.proposedCombinationColors) {
            proposedCombinationString.append(color.getColorPicked());
        }
        return proposedCombinationString.toString();
    }
}