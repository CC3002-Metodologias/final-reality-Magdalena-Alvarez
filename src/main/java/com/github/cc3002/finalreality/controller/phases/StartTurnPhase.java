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
        changePhase(new PlayerDecisionPhase(playingChar));
    }

    @Override
    public void toEnemySelectingPhase() {
        changePhase(new EnemySelectingPhase((Enemy)playingChar));
    }
}
