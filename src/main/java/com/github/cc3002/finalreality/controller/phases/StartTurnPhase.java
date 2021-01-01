package com.github.cc3002.finalreality.controller.phases;

import com.github.cc3002.finalreality.model.character.Enemy;
import com.github.cc3002.finalreality.model.character.ICharacter;

public class StartTurnPhase extends Phase{
    ICharacter playingChar;
    /*

     */
    public StartTurnPhase() {
        this.playingChar = controller.startTurn();
    }

    @Override
    public void toDecisionPhase() {
        controller.setPhase(new PlayerDecisionPhase(playingChar));
    }

    @Override
    public void toEnemySelectingPhase() {
        controller.setPhase(new EnemySelectingPhase((Enemy)playingChar));
    }
}
