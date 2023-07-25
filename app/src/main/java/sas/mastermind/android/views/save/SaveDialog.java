package sas.mastermind.android.views.save;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.SaveController;

public class SaveDialog extends AppCompatDialogFragment {
    private SaveController saveController;

    public void setSaveController(SaveController saveController) {
        this.saveController = saveController;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        builder.setTitle((R.string.save_question))
                .setPositiveButton(R.string.dialog_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        saveGame();
                    }
                })
                .setNegativeButton(R.string.dialog_negative, (dialogInterface, i) -> {
                    this.saveController.next();
                    ((MainActivity) requireActivity()).next();
                })
                .setCancelable(false);
        return builder.create();
    }

    private void saveGame() {
        if (this.saveController.hasName()) {
            this.saveController.save();
            this.saveController.next();
            ((MainActivity) requireActivity()).next();
        } else {
            NameDialog nameDialog = new NameDialog(this.saveController);
            nameDialog.setCancelable(false);
            nameDialog.show(requireActivity().getSupportFragmentManager(), "name");
        }
    }
}