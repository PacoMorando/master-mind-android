package sas.mastermind.android.views.play;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.android.databinding.SecretCombinationBinding;
import sas.mastermind.android.views.CombinationColors;
import sas.mastermind.core.models.SecretCombination;

public class SecretCombinationView extends Fragment {
    private final SecretCombination secretCombination;
    private SecretCombinationBinding binding;
    private final ArrayList<ImageView> secretCombinationColors = new ArrayList<>();

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
        for (ImageView color : this.secretCombinationColors) {
            color.setImageResource(R.drawable.token_secret);
        }
    }

    public void showRevealed() {
        String secretCombination = this.secretCombination.toString();
        for (int i = 0; i < this.secretCombinationColors.size(); i++) {
            this.secretCombinationColors.get(i).setImageResource(CombinationColors.valueOf(String.valueOf(secretCombination.charAt(i))).getColorResource());
        }
    }
}