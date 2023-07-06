package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import sas.mastermind.android.databinding.SecretCombinationBinding;
import sas.mastermind.core.models.SecretCombination;

public class SecretCombinationView extends Fragment {
    SecretCombination secretCombination;
    private SecretCombinationBinding binding;
    private ArrayList <TextView> secretCombinationColors;

    public SecretCombinationView(SecretCombination secretCombination) {
        this.secretCombination = secretCombination;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = SecretCombinationBinding.inflate(inflater, container, false);
        this.binding.setSecretCombinationView(this);
        this.setColors();
        return this.binding.getRoot();
    }

    private void setColors() {
        this.secretCombinationColors.add(this.binding.secretColorOne);
        this.secretCombinationColors.add(this.binding.secretColorTwo);
        this.secretCombinationColors.add(this.binding.secretColorThree);
        this.secretCombinationColors.add(this.binding.secretColorFour);
    }

    public void showUnrevealed() {
        for (TextView color : this.secretCombinationColors){
            color.setText("?");
        }
    }

    public void showRevealed() {

    }
}