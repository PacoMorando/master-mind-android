package sas.mastermind.android.views.save;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

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
        builder.setTitle(R.string.name_dialog_title)
                .setNeutralButton(getString(R.string.dialog_neutral), (dialogInterface, i) -> {
                    this.saveController.next();
                    ((MainActivity) requireActivity()).next();
                })
                .setPositiveButton(R.string.dialog_save, (dialogInterface, i) -> {
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
            ((MainActivity) requireActivity()).next();
        }
    }

    private void showAlreadyExistNameDialog(String name) {
        Toast.makeText(requireContext(), "\n\n" + name + " Already Exist" + "\n\n", Toast.LENGTH_SHORT).show();
        NameDialog alreadyExistNameDialog = new NameDialog(this.saveController);
        alreadyExistNameDialog.setCancelable(false);
        alreadyExistNameDialog.show(requireActivity().getSupportFragmentManager(), "Exist");
    }
}