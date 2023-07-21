package sas.mastermind.android.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.SaveController;

public class SaveDialog extends AppCompatDialogFragment {
    private final SaveController saveController;

    public SaveDialog(SaveController saveController) {
        this.saveController = saveController;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) { //TODO PLANTEARME QUE ESTA CLASE SE CREE EN LA CLASE VIEW
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());
        builder.setTitle(this.titleMessage())
                .setMessage(R.string.save_question)
                .setPositiveButton(R.string.save_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        saveGame();
                    }
                })
                .setNegativeButton(R.string.save_negative, (dialogInterface, i) -> {
                    saveController.next();
                    ((MainActivity) requireActivity()).next();
                });
        return builder.create();
    }

    private void saveGame() {
        if (this.saveController.hasName()){
            this.saveController.save();
            this.saveController.next();
        }else {
            new NameDialog(this.saveController).show(requireActivity().getSupportFragmentManager(), "name");
        }
        //((MainActivity) requireActivity()).toast("persistence has not been implemented yet \n:(");//TODO borrar cuando se implente la persistencia
       // ((MainActivity) requireActivity()).next();
    }

    private String titleMessage() {
       /* if (this.playController.isFinished()) {
            if (this.playController.isWinner()) {
                return getString(R.string.winner_message);
            } else {
                return getString(R.string.looser_message);
            }
        } else {
            return getString(R.string.exit_dialog);
        }*/return getString(R.string.exit_dialog);
    }
}