package sas.mastermind.android.views.start;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import sas.mastermind.android.MainActivity;
import sas.mastermind.android.R;
import sas.mastermind.core.controllers.StartController;

public class OpenDialog extends AppCompatDialogFragment implements SavedGamesRecyclerAdapter.OnSavedGameClickListener {
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
                .setNeutralButton(getString(R.string.dialog_neutral), (dialogInterface, i) -> {
                })
                .setView(view);
        return builder.create();
    }

    private void setSavedGamesRecyclerView(View view) {
        RecyclerView savedGamesRecyclerView = view.findViewById(R.id.savedGames);
        SavedGamesRecyclerAdapter savedGamesRecyclerAdapter = new SavedGamesRecyclerAdapter(this.startController.getGamesNames());
        savedGamesRecyclerAdapter.setSavedGameClickListener(this);
        savedGamesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        savedGamesRecyclerView.setAdapter(savedGamesRecyclerAdapter);
    }

    @Override
    public void onClickListener(String name) {
        this.dismiss();
        this.startController.start(name);
        ((MainActivity) requireActivity()).next();
    }
}