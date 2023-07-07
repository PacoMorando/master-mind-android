package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import sas.mastermind.android.databinding.ProposedCombinationBinding;

public class ProposedCombinationView extends Fragment {
    private ProposedCombinationBinding binding;
    private final ArrayList<NumberPicker> proposedCombinationColors = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = ProposedCombinationBinding.inflate(inflater, container, false);
        this.binding.setProposedCombinationView(this);
        return this.binding.getRoot();
    }

    private void setColors() {
        /*https://youtu.be/dWq5CJDBDVE*/
        this.proposedCombinationColors.add(this.binding.proposedColorOne);
        this.proposedCombinationColors.add(this.binding.proposedColorTwo);
        this.proposedCombinationColors.add(this.binding.proposedColorOne);
        this.proposedCombinationColors.add(this.binding.proposedColorOne);
    }
}
