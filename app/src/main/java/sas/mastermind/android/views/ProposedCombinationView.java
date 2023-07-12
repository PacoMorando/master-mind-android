package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.android.databinding.ProposedCombinationBinding;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

public class ProposedCombinationView extends Fragment {
    private ProposedCombinationBinding binding;
    private final ArrayList<NumberPicker> proposedCombinationColors = new ArrayList<>();
    private String[] combinationColors;
    private ArrayList<ProposedCombination> proposeCombinations;//TODO BOrrar este que no se usa

    public ProposedCombinationView(ArrayList<ProposedCombination> proposeCombinations) {
        this.proposeCombinations = proposeCombinations;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ProposedCombinationBinding.inflate(inflater, container, false);
        this.binding.setProposedCombinationView(this);
        this.combinationColors = getResources().getStringArray(R.array.combinatios_colors);
        this.setColors(this.combinationColors);
        return this.binding.getRoot();
    }

    private void setColors(String[] combinationColors) {
        /*this.proposedCombinationColors.add(this.binding.proposedColorOne);
        this.proposedCombinationColors.add(this.binding.proposedColorTwo);
        this.proposedCombinationColors.add(this.binding.proposedColorThree);
        this.proposedCombinationColors.add(this.binding.proposedColorFour);

        for (NumberPicker color : this.proposedCombinationColors) {
            color.setMinValue(0);
            color.setMaxValue(combinationColors.length - 1);
            color.setDisplayedValues(combinationColors);
        }*/
    }

    public void addProposedCombination(PlayController playController) {
        playController.addProposedCombination(this.getProposedCombinationString());
    }

    private String getProposedCombinationString() {
        StringBuilder proposedCombinationString = new StringBuilder();
        for (NumberPicker color : this.proposedCombinationColors) {
            proposedCombinationString.append(this.combinationColors[color.getValue()]);
        }
        return proposedCombinationString.toString();
    }
}