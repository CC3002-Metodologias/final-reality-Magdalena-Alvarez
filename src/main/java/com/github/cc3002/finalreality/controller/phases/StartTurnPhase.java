package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

public class StartTurnPhase extends Phase{
    /*

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
