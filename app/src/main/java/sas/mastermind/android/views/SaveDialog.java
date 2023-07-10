package sas.mastermind.android.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import sas.mastermind.core.controllers.PlayController;

public class SaveDialog extends AppCompatDialogFragment {
    private PlayController playController;

    public SaveDialog (PlayController playController){
        this.playController = playController;
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) { //TODO PLANTEARME QUE ESTA CLASE SE CREE EN LA CLASE VIEW
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.titleMessage())
                .setMessage("Do you want to save?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Activity.toast("persistence has not been implemented yet");
                        playController.next();
                        playController.next();
                        Activity.next();
                    }
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    playController.next();
                    playController.next();
                    Activity.next();
                });
        return builder.create();
    }
    private String titleMessage(){
        if (this.playController.isFinished()){
            if (this.playController.isWinner()){
                return "Has ganao tío!! :D";
            }else {
                return "jajaja perdiste! xD";
            }
        }else {
            return "Exit";
        }
    }
}