package com.github.cc3002.finalreality.controller.phases;

public class StartTurnPhase extends Phase{
    /**
     * creates a new start turn phase
     */
    public StartTurnPhase(){
    }
    @Override
    public void toDecisionPhase() {
        changePhase(new PlayerDecisionPhase());
    }

    @Override
    public void toEnemySelectingPhase() {
        changePhase(new EnemySelectingPhase());

    }
}
