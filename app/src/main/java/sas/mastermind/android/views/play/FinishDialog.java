package sas.mastermind.android.views.play;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.PlayController;

public class FinishDialog extends AppCompatDialogFragment {
    private final PlayController playController;
    private boolean winner;

    public FinishDialog(PlayController playController, boolean winner) {
        this.playController = playController;
        this.winner = winner;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        builder.setTitle(this.setMessage())
                .setMessage("Quieres salir?")
                .setPositiveButton(R.string.dialog_positive, (dialogInterface, i) -> {
                    this.playController.next();
                    ((MainActivity) requireActivity()).next();
                })
                .setNegativeButton(R.string.dialog_negative, ((dialogInterface, i) -> {
                }));
        return builder.create();
    }

    private String setMessage() {
        if (this.winner) {
            return getString(R.string.winner_message);
        } else {
            return getString(R.string.looser_message);
        }
    }
}
