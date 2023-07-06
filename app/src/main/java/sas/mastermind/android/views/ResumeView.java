package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import sas.mastermind.android.R;
import sas.mastermind.core.controllers.ResumeController;

public class ResumeView extends Fragment {
    public void interact(ResumeController resumeController) {
        resumeController.resume(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resume_view, container, false);
    }
}
