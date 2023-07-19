package sas.mastermind.android.views;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;

public class NameDialog extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.game_name, null);
        TextInputEditText gameName = view.findViewById(R.id.gameName);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());
        builder.setTitle("Set a name")
                .setNeutralButton("Cancel", (dialogInterface, i) -> {
                })
                .setPositiveButton("Save", (dialogInterface, i) -> {
                    ((MainActivity) requireActivity()).toast(gameName.getText() + " Has been save");
                })
                .setView(view);
        return builder.create();
    }
}