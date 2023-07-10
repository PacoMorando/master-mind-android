package sas.mastermind.android.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


import sas.mastermind.android.MainActivity;
import sas.mastermind.android.databinding.ResumeViewBinding;
import sas.mastermind.core.controllers.ResumeController;

public class ResumeView extends Fragment {
    private ResumeController resumeController;
    private ResumeViewBinding binding;
    public void interact(ResumeController resumeController) {
        resumeController.resume(true);
        this.resumeController = resumeController;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = ResumeViewBinding.inflate(inflater, container, false);
        this.binding.setResumeView(this);
        return this.binding.getRoot();
    }

    public void exit (){
        ((MainActivity) requireActivity()).toast("Bye!!");
        this.resumeController.resume(false);
        requireActivity().finishAndRemoveTask();//TODO Este metodo no finaliza por completo la app, la cierra pero no hace lo mismo a que si le doy stop al IDE o la cierro desde el cel
    }
}
