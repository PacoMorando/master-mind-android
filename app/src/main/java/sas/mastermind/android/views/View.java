package sas.mastermind.android.views;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import sas.mastermind.android.R;
import sas.mastermind.android.views.play.PlayView;
import sas.mastermind.android.views.save.SaveDialog;
import sas.mastermind.android.views.start.StartView;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.ResumeController;
import sas.mastermind.core.controllers.SaveController;
import sas.mastermind.core.controllers.StartController;

public class View extends sas.mastermind.core.views.View {
    private final FragmentManager fragmentManager;
    private final StartView startView;
    private final PlayView playView;
    private final SaveDialog saveView;
    private final ResumeView resumeView;

    public View(FragmentManager supportFragmentManager) {
        this.fragmentManager = supportFragmentManager;
        this.startView = new StartView();
        this.playView = new PlayView();
        this.saveView = new SaveDialog();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        this.setFragmentView(R.id.fragment_container_view, this.startView);
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.setFragmentView(R.id.fragment_container_view, this.playView);
        this.playView.interact(playController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.saveView.setSaveController(saveController);
        this.saveView.setCancelable(false);
        this.saveView.show(fragmentManager.beginTransaction(), "save game");
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.setFragmentView(R.id.fragment_container_view, this.resumeView);
        this.resumeView.interact(resumeController);
    }

    private void setFragmentView (int fragmentContainerViewID, Fragment fragmentView){
        this.fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(fragmentContainerViewID, fragmentView, null)
                .commit();
    }
}