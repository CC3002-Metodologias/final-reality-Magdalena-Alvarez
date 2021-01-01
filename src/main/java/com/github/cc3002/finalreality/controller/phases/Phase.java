package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.controller.GameController;

public class Phase {
    protected GameController controller;

    public void setController (GameController controller){
        this.controller = controller;
    }

    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    public void toDecisionPhase(){}
    public void toEnemySelectingPhase(){}
    public void toStartTurnPhase(){}
    public void toAttackPhase(){}
    public void toEndTurnPhase(){}
    public void toMagicState(){}
    public void toInventoryState(){}
    public void toPlayerSelectingPhase(){}

}
