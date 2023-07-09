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
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(this.isWinnerMessage())
                .setMessage("Do you want to save?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Activity.toast("Apretaste Yes");
                        Activity.getInstance().next();
                    }
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    Activity.toast("Apretaste no");
                    playController.next();
                    Activity.getInstance().next();
                });
        return builder.create();
    }
    private String isWinnerMessage(){
        if (this.playController.isWinner()){
            return "Has ganao tío!! :D";
        }else {
            return "jajaja perdiste! xD";
        }
    }
}