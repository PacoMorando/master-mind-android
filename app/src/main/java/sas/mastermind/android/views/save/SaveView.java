package sas.mastermind.android.views.save;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.SaveController;

public class SaveView extends Fragment {
    public void interact(SaveController saveController) {
        saveController.next();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.save_view, container, false);
    }
}
