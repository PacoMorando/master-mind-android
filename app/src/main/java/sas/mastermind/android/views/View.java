package sas.mastermind.android.views;

import androidx.fragment.app.FragmentManager;

import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.ResumeController;
import sas.mastermind.core.controllers.SaveController;
import sas.mastermind.core.controllers.StartController;

public class View extends sas.mastermind.core.views.View {
    private final StartView startView;
    private final PlayView playView;
    private final SaveView saveView;
    private final ResumeView resumeView;

    public View() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.saveView = new SaveView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);
    }

    @Override
    public void visit(SaveController saveController) {
        this.saveView.interact(saveController);
    }
}