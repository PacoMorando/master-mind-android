package sas.mastermind.android;


import androidx.appcompat.app.AppCompatActivity;

import sas.mastermind.android.dao.SessionDAO;
import sas.mastermind.core.controllers.AcceptorController;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

public class AndroidMasterMind {
    private final Logic logic;
    private final View view;

    public AndroidMasterMind(AppCompatActivity appCompatActivity) {
        this.logic = new LogicImplementation(new SessionDAO(appCompatActivity.getApplicationContext()));
        this.view = new sas.mastermind.android.views.View(appCompatActivity.getSupportFragmentManager());
    }

    protected void play() {
        AcceptorController acceptorController;
        acceptorController = this.logic.getController();
        if (acceptorController != null) {
            this.view.interact(acceptorController);
        }
    }
}