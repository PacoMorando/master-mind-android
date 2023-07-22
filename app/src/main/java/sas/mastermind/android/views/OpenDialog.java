package sas.mastermind.android.views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.util.Objects;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.StartController;

public class OpenDialog extends AppCompatDialogFragment {
    private final StartController startController;

    public OpenDialog(StartController startController) {
        this.startController = startController;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(R.layout.open_game, null);
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(requireActivity());
        this.setSavedGamesRecyclerView(view);
        builder.setTitle("Select Game")
                .setNeutralButton("Cancel", (dialogInterface, i) -> {
                })
                .setView(view);
        return builder.create();
    }

    private void setSavedGamesRecyclerView(View view) {
        RecyclerView savedGamesRecyclerView = view.findViewById(R.id.savedGames);
        SavedGamesRecyclerAdapter savedGamesRecyclerAdapter = new SavedGamesRecyclerAdapter(this.startController.getGamesNames());
        savedGamesRecyclerAdapter.setOpenDialog(this);
        savedGamesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        savedGamesRecyclerView.setAdapter(savedGamesRecyclerAdapter);
    }

    public void showGameNameClicked(String name) {
        this.dismiss();
        this.startController.start(name);
        ((MainActivity) requireActivity()).toast(name);
        ((MainActivity) requireActivity()).next();
    }
}