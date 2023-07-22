package sas.mastermind.android.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.SaveController;

public class NameDialog extends AppCompatDialogFragment {
    private final SaveController saveController;

    public NameDialog(SaveController saveController) {
        this.saveController = saveController;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.game_name, null);
        TextInputEditText gameName = view.findViewById(R.id.gameName);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        builder.setTitle("Set a name")
                .setNeutralButton("Cancel", (dialogInterface, i) -> {
                })
                .setPositiveButton("Save", (dialogInterface, i) -> {
                    this.save(String.valueOf(gameName.getText()));
                })
                .setView(view);
        return builder.create();
    }

    private void save(String name) {
        if (this.saveController.exists(name)) {
            this.showAlreadyExistNameDialog(name);
        } else {
            this.saveController.save(name);
            this.saveController.next();
            ((MainActivity) requireActivity()).toast(name + " Has been save");
            ((MainActivity) requireActivity()).next();
        }
    }

    private void showAlreadyExistNameDialog(String name) {
        ((MainActivity) requireActivity()).toast("\n\n" + name + " Already Exist" + "\n\n");
        NameDialog alreadyExistNameDialog = new NameDialog(this.saveController);
        alreadyExistNameDialog.show(requireActivity().getSupportFragmentManager(), "Exist");
    }
}