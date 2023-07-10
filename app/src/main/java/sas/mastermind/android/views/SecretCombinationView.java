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
import java.util.Objects;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.android.databinding.SecretCombinationBinding;
import sas.mastermind.core.models.SecretCombination;

public class SecretCombinationView extends Fragment {
    private final SecretCombination secretCombination;
    private SecretCombinationBinding binding;
    private final ArrayList<TextView> secretCombinationColors = new ArrayList<>();

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
        for (TextView color : this.secretCombinationColors) {
            color.setText("¿?");
        }
    }

    public void showRevealed() {
        String secretCombination = this.secretCombination.toString();
        for (int i = 0; i < this.secretCombinationColors.size(); i++) {
            this.secretCombinationColors.get(i).setText(String.valueOf(secretCombination.charAt(i)));
        }
    }

    public void pintarCombinacionSecreta() {// TODO este se va a tener que ir porque era solo para probar
        this.binding.secretText.setText(this.secretCombination.toString());
    }
}